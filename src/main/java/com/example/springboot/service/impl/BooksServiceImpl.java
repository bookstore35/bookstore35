package com.example.springboot.service.impl;

import com.example.springboot.Vo.BooksClassVo;
import com.example.springboot.dao.BooksClassDao;
import com.example.springboot.entity.BooksClass;
import com.example.springboot.service.BooksClassService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksServiceImpl implements BooksClassService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BooksClassDao booksClassDao;


    /**
     * jpa对象
     * @param id
     * @return
     */


    @Override
    public List<BooksClass> selectBooksClass(Integer id) {
        /*
           查询方法
        */
        String sql = "SELECT t1.* from books_class t1 join (SELECT @r AS _id, (SELECT @r:=pid FROM books_class WHERE id = _id) AS pid FROM (SELECT @r:=?) vars, books_class WHERE @r<>0 ) t2 on t2._id=t1.id where 1=1";
        RowMapper<BooksClass> rowMapper = new RowMapper<BooksClass>() {
            /*
                将数据库的查询数据传入到booksClass
             */
            @Override
            public BooksClass mapRow(ResultSet resultSet, int i) throws SQLException {
                BooksClass booksClass = new BooksClass();
                if (resultSet.wasNull()){
                    return booksClass;
                }
                booksClass.setId(resultSet.getInt(1));
                booksClass.setName(resultSet.getString(3));
                booksClass.setPid(resultSet.getInt(2));
                booksClass.setLevel(resultSet.getInt(4));
                return booksClass;
            }
        };

        /*
            返回执行数据库操作
         */
        return jdbcTemplate.query(sql,rowMapper,id); //sql、rowMapper固定，id是传给sql？的参数
    }



    @Override
    public List<BooksClassVo> selectBooksVo(Integer pid, Integer pageNo, Integer pageSize) {
         /*
           查询方法
        */
         StringBuffer sql2=new StringBuffer();
         sql2.append("select a.id,a.book_name ,a.publisher,a.author,a.introduce,a.images_url,b.name,c.seller_name  \n");
         sql2.append("from book a \n");
         sql2.append("left join books_class b on a.cid=b.id\n");
         sql2.append("inner join seller c on c.id=a.sid \n");
         sql2.append("where a.cid=?\n ");
         sql2.append("limit ?,?");

         RowMapper<BooksClassVo> rowMapper = new RowMapper<BooksClassVo>() {
            /*
                将数据库的查询数据传入到booksClass
             */
            @Override
            public BooksClassVo mapRow(ResultSet resultSet, int i) throws SQLException {
                BooksClassVo booksVo = new BooksClassVo();
                if (resultSet.wasNull()){
                    return  booksVo;
                }
                booksVo.setId(resultSet.getInt(1));

                booksVo.setBookName(resultSet.getString(2));
                booksVo.setPublisher(resultSet.getString(3));
                booksVo.setAuthor(resultSet.getString(4));
                booksVo.setIntroduce(resultSet.getString(5));
                booksVo.setImagesUrl(resultSet.getString(6));
                booksVo.setName(resultSet.getString(7));
                booksVo.setSellerName(resultSet.getString(8));
                return booksVo;
            }
        };

        /*
            返回执行数据库操作
         */
        return jdbcTemplate.query(sql2.toString(),rowMapper,pid,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public List<BooksClass> findAll() {
        return booksClassDao.findAll();
    }

    @Override
    public Result insert(BooksClass booksClass) {
        BooksClass old = this.booksClassDao.findByName(booksClass.getName());
        if(old != null){
            return Result.error("该分类已存在");
        }

        booksClass = this.booksClassDao.save(booksClass);
        return Result.success(booksClass);
    }

    @Override
    public Result delete(Integer id) {
        this.booksClassDao.deleteById(id);
        return Result.success("删除成功！");
    }

    @Override
    public Result update(BooksClass booksClass) {

        this.booksClassDao.save(booksClass);
        return Result.success("修改成功!");
    }


    @Override
    public List<BooksClass> listWithTree() {
        // 查找所有菜单数据
        List<BooksClass> lists = booksClassDao.findAll();
        // 把数据组合成树形结构
        List<BooksClass> result = lists.stream()
                // 查找第一级菜单
                .filter(menu -> menu.getLevel() == 1)
                // 查找子菜单并放到第一级菜单中
                .map(menu -> {
                    menu.setChildren(getChildren(menu, lists));
                    return menu;
                })
                // 把处理结果收集成一个 List 集合
                .collect(Collectors.toList());
        return result;
    }


    public static List<BooksClass> getChildren(BooksClass root, List<BooksClass> all) {

        List<BooksClass> children = all.stream()
                // 根据 父菜单 ID 查找当前菜单 ID，以便于找到 当前菜单的子菜单
                .filter(menu -> menu.getPid() == root.getId())
                // 递归查找子菜单的子菜单
                .map((menu) -> {
                    menu.setChildren(getChildren(menu, all));
                    return menu;
                })
                // 把处理结果收集成一个 List 集合
                .collect(Collectors.toList());
        return children;
    }





    //根据父级查出所有所属的子类id
    @Override
    public List<BooksClassVo> selectBooks(Integer id,String bookName, Integer pageNo, Integer pageSize) {
        List param = new ArrayList();
        StringBuffer sql3=new StringBuffer();
        sql3.append("SELECT t.id,t.book_name ,t.publisher,t.author,t.introduce,t.images_url  \n");
        sql3.append(",(select t3.seller_name from seller t3 where t3.id=t.sid) seller_name,t3.name\n");
        sql3.append("from book t\n");
        sql3.append("LEFT JOIN books_class t3 on t3.id=t.cid \n");
        sql3.append("where 1=1\n");
        if(id != null){
            sql3.append("and (t.cid in(SELECT id FROM(SELECT t1.id,IF (find_in_set(pid, @pids) > 0 ,@pids := concat(@pids, ',', id),0) \n");
            sql3.append("AS ischild FROM(SELECT id,pid FROM books_class t ORDER BY pid,id) t1,(SELECT @pids := ?) t2) t3 \n");
            sql3.append("WHERE ischild != 0)or t.cid = ? )\n");
            param.add(id);
            param.add(id);
        }

        if(bookName != null && !"".equals(bookName)){
            sql3.append(" and t.book_name like ?\n");
            param.add("%"+bookName+"%");
        }
        sql3.append("limit ?,?\n");
        param.add(pageNo);
        param.add(pageSize);
        RowMapper<BooksClassVo> rowMapper = new RowMapper<BooksClassVo>() {
            /*
                将数据库的查询数据传入到booksClass
             */
            @Override
            public BooksClassVo mapRow(ResultSet resultSet, int i) throws SQLException {
                BooksClassVo booksVo = new BooksClassVo();
                if (resultSet.wasNull()){
                    return  booksVo;
                }
                booksVo.setId(resultSet.getInt(1));

                booksVo.setBookName(resultSet.getString(2));
                booksVo.setPublisher(resultSet.getString(3));
                booksVo.setAuthor(resultSet.getString(4));
                booksVo.setIntroduce(resultSet.getString(5));
                booksVo.setImagesUrl(resultSet.getString(6));
                booksVo.setName(resultSet.getString(8));
                booksVo.setSellerName(resultSet.getString(7));
                return booksVo;

            }
        };

        /*
            返回执行数据库操作
         */
        return jdbcTemplate.query(sql3.toString(),rowMapper,param.toArray());
//        return jdbcTemplate.query(sql3.toString(),rowMapper,id,id,(number-1)*content,content);

    }
}

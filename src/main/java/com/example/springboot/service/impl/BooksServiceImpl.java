package com.example.springboot.service.impl;

import com.example.springboot.Vo.BooksVo;
import com.example.springboot.dao.BooksClassDao;
import com.example.springboot.entity.BooksClass;
import com.example.springboot.service.BookService;
import com.example.springboot.service.BooksClassService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
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
    public List<BooksVo> selectBooksVo() {
         /*
           查询方法
        */
         StringBuffer sql2=new StringBuffer();
         sql2.append("select a.id,a.book_name ,a.publisher,a.author,a.introduce,a.images_url,b.name,c.seller_name  from book a left join books_class b on a.cid=b.id inner join seller c on a.sid=c.sid");

         RowMapper<BooksVo> rowMapper = new RowMapper<BooksVo>() {
            /*
                将数据库的查询数据传入到booksClass
             */
            @Override
            public BooksVo mapRow(ResultSet resultSet, int i) throws SQLException {
                BooksVo booksVo = new BooksVo();
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
        return jdbcTemplate.query(sql2.toString(),rowMapper);
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




}

package com.example.springboot.service.impl;

import com.example.springboot.Vo.ShoppingCartVo;
import com.example.springboot.dao.BookDao;
import com.example.springboot.dao.ShoppingCartDao;
import com.example.springboot.dao.UserDao;
import com.example.springboot.entity.ShoppingCart;
import com.example.springboot.entity.User;
import com.example.springboot.service.ShoppingCartService;
import com.example.springboot.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartDao shoppingCartDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    UserDao userDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Result getById(Integer id) {
        ShoppingCart shoppingCart = shoppingCartDao.findById(id).get();
        return Result.success(shoppingCart);
    }

    @Override
    public Result insert(ShoppingCart shoppingCart) {

        shoppingCartDao.save(shoppingCart);
        return Result.success("添加成功");
    }



    @Override
    public Result update(ShoppingCart shoppingCart) {
        return Result.success(shoppingCartDao.save(shoppingCart));
    }

    @Override
    public User findAllByUsername(String userName) {

        return userDao.findAllByUsername(userName) ;
    }




    @Override
    public Result delete(Integer id) {
        shoppingCartDao.deleteById(id);
        return Result.success("修改成功!");
    }


    @Override
    public List<ShoppingCartVo> selectCart(Integer uid) {
        StringBuffer sql=new StringBuffer();
        sql.append("select s.id,s.bid,s.number,a.price,a.book_name ,a.publisher,a.author,a.introduce,a.images_url,c.seller_name \n");
        sql.append("from shopping_cart s\n");
        sql.append("left join book a on s.bid = a.id \n");
        sql.append("inner join seller c on c.id=a.sid \n");
        sql.append("where s.uid = ? \n");

        RowMapper<ShoppingCartVo> rowMapper = new RowMapper<ShoppingCartVo>() {
            /*
                将数据库的查询数据传入到booksClass
             */
            @Override
            public ShoppingCartVo mapRow(ResultSet resultSet, int i) throws SQLException {
                ShoppingCartVo shoppingCartVo = new ShoppingCartVo();
                if (resultSet.wasNull()){
                    return  shoppingCartVo;
                }
                shoppingCartVo.setId(resultSet.getInt(1));
                shoppingCartVo.setBid(resultSet.getInt(2));
                shoppingCartVo.setNumber(resultSet.getInt(3));
                shoppingCartVo.setPrice(resultSet.getFloat(4));
                shoppingCartVo.setBookName(resultSet.getString(5));
                shoppingCartVo.setPublisher(resultSet.getString(6));
                shoppingCartVo.setAuthor(resultSet.getString(7));
                shoppingCartVo.setIntroduce(resultSet.getString(8));
                shoppingCartVo.setImagesUrl(resultSet.getString(9));
                shoppingCartVo.setSellerName(resultSet.getString(10));
                return shoppingCartVo;
            }
        };
        return jdbcTemplate.query(sql.toString(),rowMapper,uid);
    }

}

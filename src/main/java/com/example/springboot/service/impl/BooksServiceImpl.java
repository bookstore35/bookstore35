package com.example.springboot.service.impl;

import com.example.springboot.entity.BooksClass;
import com.example.springboot.service.BooksClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksClassService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
}
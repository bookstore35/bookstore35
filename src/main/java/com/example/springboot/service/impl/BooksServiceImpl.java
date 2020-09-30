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


    @Override
    public List<BooksClass> selectBooksClass(Integer id) {
        String sql = "SELECT t1.* from book_class t1 join (SELECT @r AS _id, (SELECT @r:=pid FROM book_class WHERE id = _id) AS pid FROM (SELECT @r:=?) vars, book_class WHERE @r<>0 ) t2 on t2._id=t1.id where 1=1";
        RowMapper<BooksClass> rowMapper = new RowMapper<BooksClass>() {

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


        return jdbcTemplate.query(sql,rowMapper,id);
    }
}

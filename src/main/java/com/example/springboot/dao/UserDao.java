package com.example.springboot.dao;

import com.example.springboot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    /**
     *
     * 根据用户名查用户
     * @param username
     * @return
     */
    public User getByUsername(String username);

    public User getByMobile(String mobile);

    Page<User> findAll(Pageable pageable);

}

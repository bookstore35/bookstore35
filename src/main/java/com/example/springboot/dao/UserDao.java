package com.example.springboot.dao;

import com.example.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    /**
     * 根据用户名查用户
     * @param username
     * @return
     */
    public User getByUsername(String username);
}

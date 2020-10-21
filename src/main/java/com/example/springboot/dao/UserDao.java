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
    /**
     * 自定义sql
     * t:别名
     * **/
    /*//展示位置参数绑定
    @Query(value = "from User u where u.name=?1 and u.password=?2")
    User findByNameAndPassword(String name, String password);

    //展示名字参数绑定
    @Query(value = "from User u where u.name=:name and u.email=:email")
    User findByNameAndEmail(@Param("name")String name, @Param("email")String email);

    //展示like模糊查询
    @Query(value = "from User u where u.name like %:nameLike%")
    List<User> findByNameLike(@Param("nameLike")String nameLike);

    //展示时间间隔查询
    @Query(value = "from User u where u.createDate between :start and :end")
    List<User> findByCreateDateBetween(@Param("start") Date start, @Param("end")Date end);

    //展示传入集合参数查询
    @Query(value = "from User u where u.name in :nameList")
    List<User> findByNameIn(@Param("nameList") Collection<String> nameList);

    //展示传入Bean进行查询（SPEL表达式查询）
    @Query(value = "from User u where u.name=:#{#usr.name} and u.password=:#{#usr.password}")
    User findByNameAndPassword(@Param("usr")User usr);

    //展示使用Spring自带分页查询
    @Query("from User u")
    Page<User> findAllPage(Pageable pageable);

    //展示带有条件的分页查询
    @Query(value = "from User u where u.email like %:emailLike%")
    Page<User> findByEmailLike(Pageable pageable, @Param("emailLike")String emailLike);
*/
}

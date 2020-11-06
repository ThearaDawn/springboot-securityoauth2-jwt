package com.ums.model.dao;

import com.ums.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {

    public User findByUsername(String username);

    @Query("select u from User u where u.username=?1")
    public User findByUsername2(String username);

}

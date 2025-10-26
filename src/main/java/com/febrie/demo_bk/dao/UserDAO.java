package com.febrie.demo_bk.dao;

import com.febrie.demo_bk.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUserName (String userName);

    User getByUserNameAndPassword(String userName,String password);

}

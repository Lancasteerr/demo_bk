package com.febrie.demo_bk.service;

import com.febrie.demo_bk.dao.UserDAO;
import com.febrie.demo_bk.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public boolean isExist (String userName) {
        User user = userDAO.findByUserName(userName);
        return null != user;
    }

    public User getByName (String userName) {
        return userDAO.findByUserName(userName);
    }

    public User get (String userName,String password) {
        return userDAO.getByUserNameAndPassword(userName,password);
    }

    public void add (User user) {
        userDAO.save(user);
    }
}

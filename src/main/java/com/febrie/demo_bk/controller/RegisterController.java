package com.febrie.demo_bk.controller;

import com.febrie.demo_bk.pojo.User;
import com.febrie.demo_bk.result.Result;
import com.febrie.demo_bk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class RegisterController{
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/register")
    @ResponseBody
    public Result register(@RequestBody User requestUser) {
        requestUser.setUserName(HtmlUtils.htmlEscape(requestUser.getUserName()));
        requestUser.setPassword(HtmlUtils.htmlEscape(requestUser.getPassword()));

        if(userService.isExist(requestUser.getUserName())) {
            return new Result(400);
        }
        else {
            userService.add(requestUser);
            return new Result(200);
        }
    }
}

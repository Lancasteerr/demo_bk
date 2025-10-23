package com.febrie.demo_bk.controller;

import com.febrie.demo_bk.pojo.User;
import com.febrie.demo_bk.result.Result;
import com.febrie.demo_bk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    //跨域支持
    @CrossOrigin
    //post请求为api/login将转发到该方法
    @PostMapping(value = "api/login")
    //返回值为响应，转换为json
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String userName = requestUser.getUserName();
        //System.out.println(userName);
        userName = HtmlUtils.htmlEscape(userName);
        //System.out.println(userName);
        User user = userService.get(userName,requestUser.getPassword());
        if(null == user) {
            String message = "账号密码错误";
            System.out.println(message);
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}

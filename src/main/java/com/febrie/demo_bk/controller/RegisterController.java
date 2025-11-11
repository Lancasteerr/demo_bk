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

import java.security.SecureRandom;

@Controller
public class RegisterController{
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/register")
    @ResponseBody
    public Result register(@RequestBody User requestUser) {
        //不hash密码写法:
        requestUser.setUserName(HtmlUtils.htmlEscape(requestUser.getUserName()));
        requestUser.setPassword(HtmlUtils.htmlEscape(requestUser.getPassword()));

        if(userService.isExist(requestUser.getUserName())) {
            return new Result(400);
        }
        else {
            userService.add(requestUser);
           return new Result(200);
        }
//        String userName = requestUser.getUserName();
//        String password = requestUser.getPassword();
//        userName = HtmlUtils.htmlEscape(userName);
//        requestUser.setUserName(userName);
//
//        if(userService.isExist(userName)) {
//            return new Result(400);
//        }
        //生成随机salt
        //不能使用这种方法生成salt 将saltt转为salt会因为不可显示字符发生丢失
//        byte[] saltt = new byte[16];
//        new SecureRandom().nextBytes(saltt);
//        String salt = new String(saltt);
        //toString方法会把字符数组转为16进制或其他可读形式 防止丢失
//        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        //hash次数
//        int times = 2;
        //得到 hash 后的密码
//        String encodePassword = new SimpleHash("md5",password,salt,times).toString();
        //存储用户信息， salt 和 hash 后的密码
//        requestUser.setSalt(salt);
//        requestUser.setPassword(encodePassword);
//        userService.add(requestUser);

//        return new Result(200);
    }
}

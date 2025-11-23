package com.febrie.demo_bk.controller;

import com.febrie.demo_bk.pojo.User;
import com.febrie.demo_bk.result.Result;
import com.febrie.demo_bk.service.UserService;
import com.febrie.demo_bk.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;// 密码加密比较

    //跨域支持
    @CrossOrigin
    //post请求为api/login将转发到该方法
    @PostMapping(value = "api/public/login")
    //返回值为响应，转换为json
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String userName = requestUser.getUserName();
        String password = requestUser.getPassword();
        //转义防xss攻击
        userName = HtmlUtils.htmlEscape(userName);
        password = HtmlUtils.htmlEscape(password);

        User user = userService.getByName(userName);

        //用户不存在
        if(null == user){
            return new Result(400);
        }

        //校验密码
        if(!passwordEncoder.matches(password,user.getPassword())){
            return new Result(400);
        }

        //生成JWT
        String token = JwtUtil.generateToken(userName);

        return new Result(200,token);
    }
}

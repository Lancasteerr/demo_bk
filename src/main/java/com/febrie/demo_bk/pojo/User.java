package com.febrie.demo_bk.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "user")
//json化时忽略"handler","hibernateLazyInitializer"无用属性，提高性能
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "user_name",nullable = true,unique = true)
    String userName;
    @Column(name = "password",nullable = true)
    String password;
    @Column(name = "role",nullable = true)
    String role;

    public User(){ this.role = "ROLE_ADMIN"; }

    public User(int id,String userName,String password,String role){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role != null ? role : "ROLE_ADMIN";//默认用户组为ADMIN
    }

    //JPA必须的getter和setter 可用Lombok
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    //Spring Security必须的方法
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(() -> this.role);//以列表返回用户拥有的角色
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

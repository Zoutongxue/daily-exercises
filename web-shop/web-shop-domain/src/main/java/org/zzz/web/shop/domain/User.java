package org.zzz.web.shop.domain;

import java.io.Serializable;

// 因为要实现网路化传输，所以要实现序列化接口
public class User implements Serializable {
    private String email;
    private String password;
    private String username;

    //  按 Alt + Ins  ->  调用 getter() setter()方法
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //  按 Alt + Ins  ->  重写 toString()方法
    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

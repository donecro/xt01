package com.xt01.dto;


import java.io.Serializable;

/**
 * 系统用户
 *
 * @ClassName: SysUserVo
 * @Description: TODO
 * @author icat
 * @date 2018年8月14日 下午5:20:55
 *
 */

public class SysUserVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;// id
    private String username;// 用户账号
    private String password;// 密码
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}


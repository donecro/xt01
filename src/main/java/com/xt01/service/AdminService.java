package com.xt01.service;

import com.xt01.entity.Admin;
import com.xt01.dto.Login;

import java.sql.SQLException;
import java.util.List;

public interface AdminService {

    Integer CheckLogin(Login login);

    Admin getAdminByLoginId(int loginid);


    List<Admin> getList() throws SQLException;
    int AddAdmin(String account, String uname, String pwd, int power) throws SQLException;
    int DeleteAdmin(int id) throws SQLException;
    int UpdateUsername(int id, String uname) throws SQLException;
    int UpdatePwd(int id, String pwd) throws SQLException;
    int UpdatePower(int id, int power) throws SQLException;


}

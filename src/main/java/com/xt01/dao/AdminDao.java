package com.xt01.dao;

import com.xt01.dto.Login;
import com.xt01.entity.Admin;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AdminDao {

    Integer CheckLogin(@Param("login") Login login);

    Admin getAdminByLoginId(@Param("id") int id);

    List<Admin> QueryAll() throws SQLException;
    int Add(@Param("account") String account,@Param("username") String username,@Param("password") String password, @Param("power") int power) throws SQLException;
    int Delete(@Param("id") int id)throws SQLException;
    int UpdateUsername(@Param("id") int id, @Param("username") String username) throws SQLException;
    int UpdatePwd(@Param("id") int id, @Param("pwd") String pwd) throws SQLException;
    int UpdatePower(@Param("id") int id, @Param("power") int power) throws SQLException;

}

package com.xt01.service.impl;

import com.xt01.dao.AdminDao;
import com.xt01.entity.Admin;
import com.xt01.dto.Login;
import com.xt01.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    //注入Service依赖
    @Autowired private AdminDao adminDao;

    @Override public Integer CheckLogin(Login login) { return adminDao.CheckLogin(login); }

    @Override public Admin getAdminByLoginId(int loginid) { return adminDao.getAdminByLoginId(loginid); }

    @Override public List<Admin> getList() throws SQLException { return adminDao.QueryAll(); }
    @Override public int AddAdmin(String account, String uname, String pwd, int power) throws SQLException { return adminDao.Add(account,uname,pwd,power); }
    @Override public int DeleteAdmin(int id) throws SQLException { return adminDao.Delete(id); }
    @Override public int UpdateUsername(int id, String uname) throws SQLException { return adminDao.UpdateUsername(id, uname); }
    @Override public int UpdatePwd(int id, String pwd) throws SQLException { return adminDao.UpdatePwd(id,pwd); }
    @Override public int UpdatePower(int id, int power) throws SQLException { return  adminDao.UpdatePower(id,power); }


}




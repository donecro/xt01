package com.xt01.service;

import com.xt01.entity.Apply;

import java.util.Date;
import java.util.List;

public interface ApplyService {


    double Price(String bst, int forlong) throws Exception;

    int AddApply(String username,
                 String sex,
                 long uid,
                 long callnum,
                 String usergroup,
                 String address,
                 String bst,
                 int forlong,
                 String identity,
                 int acode,
                 String password,
                 String applytime,
                 double totalfee)throws Exception;


    List<Apply> getList() throws Exception;

    int DoCheck(long uid,String identity) throws Exception;

    int InsertIdentityExcel(
            long uid,
            String username,
            String over,
            String sex,
            String email,
            String identity,
            long callnum,
            String address);

//    List<Apply> queryAllApplyByPage(PageBean<Apply> pagebean) throws Exception;

//    List<Apply> queryTodayByPage(PageBean<Apply> topagebean, Date date) throws Exception;




    List<Apply> queryByPage(int page, int count);

    int queryCount();

    List<Apply> queryToByPage(int page, int count, Date today);

    int queryToCount(Date today);



    int IdentityClean() throws Exception;
}

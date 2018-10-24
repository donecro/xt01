package com.xt01.service.impl;

import com.xt01.dao.ApplyDao;
import com.xt01.dao.SettingDao;
import com.xt01.entity.Apply;
import com.xt01.result.Setting.BTResult;
import com.xt01.service.ApplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {


    /**
     * 输入ApplyDate String--> Impl -->Date
     * 输出ApplyDate Date--> Impl -->String
     */

    //注入Service依赖
    @Autowired
    private ApplyDao applyDao;

    @Autowired
    private SettingDao settingDao;

    @Override
    public double Price(String bst,int forlong) throws Exception {
        double p;
        BTResult bt = settingDao.BTgetByBst(bst);
        if (forlong == 3000){
            p = bt.getMprice();
        }else if (forlong == 3001){
            p = bt.getSprice();
        }else if (forlong == 3002){
            p = bt.getYprice();
        }else {
            p = 1000000000;
        }
        return p;
    }

    @Override
    public int AddApply(String username,
                        String sex,
                        long uid,
                        long callnum,
                        String usergroup,
                        String address,
                        String businesstype,
                        int forlong,
                        String identity,
                        int acode,
                        String password,
                        String applytime,
                        double totalfee) throws Exception {
        return applyDao.Add(username, sex, uid, callnum, usergroup, address, businesstype, forlong, identity, acode,password,
                new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(applytime),totalfee);
    }

    @Override public List<Apply> getList() throws Exception { return applyDao.queryAll(); }

//    @Override
//    public List<Apply> queryAllApplyByPage(PageBean<Apply> pagebean) throws Exception {
//        int startPage = (pagebean.getCurrentPage()-1)*pagebean.getPageCount();
//        int pageCount = pagebean.getPageCount();
//        List<Apply> l = applyDao.queryAllApplyByPage(startPage,pageCount);
//        List<Apply> la = StringUtil.ArToA(l);
//        return la;
//    }
//
//    @Override
//    public List<Apply> queryTodayByPage(PageBean<Apply> pagebean, Date date) throws Exception {
//        int startPage = (pagebean.getCurrentPage()-1)*pagebean.getPageCount();
//        int pageCount = pagebean.getPageCount();
//        List<Apply> l = applyDao.queryTodayByPage(startPage,pageCount,date);
//        List<Apply> la = StringUtil.ArToA(l);
//        return la;
//    }

    @Override public List<Apply> queryByPage(int page, int count) { return applyDao.queryByPage(page, count); }
    @Override public int queryCount() { return applyDao.queryCount(); }


    @Override public List<Apply> queryToByPage(int page, int count, Date today) { return applyDao.queryToByPage(page, count, today); }
    @Override public int queryToCount(Date today) { return applyDao.queryToCount(today); }

    @Override
    public int DoCheck(long uid, String identity) throws Exception {
        if (applyDao.CheckUIdHadApplyExist(uid)!= 0) {
            return -1;   //用户已申请
        }else if (applyDao.CheckUIdExist(uid)==0){
            return -2;  //用户学号不在校检库中
        }else {
            if (applyDao.DoCheckGetIdentity(uid).equals(identity)) return 1;
            else return 0;   //0为非法，1为合法
        }
    }

    @Override
    public int InsertIdentityExcel(long uid, String username, String over, String sex, String email, String identity, long callnum, String address) {
        return applyDao.InsertIdentityExcel(uid, username, over, sex, email, identity, callnum, address);
    }

    @Override public int IdentityClean() throws Exception { return applyDao.IdClear(); }
}




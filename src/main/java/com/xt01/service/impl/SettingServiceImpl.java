package com.xt01.service.impl;

import com.xt01.dao.SettingDao;
import com.xt01.result.Setting.ADResult;
import com.xt01.result.Setting.BTResult;
import com.xt01.result.Setting.UGResult;
import com.xt01.service.SettingService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements SettingService {

    private Logger  logger = LoggerFactory.getLogger(this.getClass());

    @Autowired private SettingDao settingDao;

    @Override public int UGAdd(String ugname) throws Exception { return settingDao.UGAdd(ugname); }
    @Override public int UGDelete(int id) throws Exception {     return settingDao.UGDelete(id); }
    @Override public List<UGResult> UGList() throws Exception {  return settingDao.UGList(); }


    @Override public int ADAdd(String bulid) throws Exception {  return settingDao.ADAdd(bulid); }
    @Override public int ADDelete(int id) throws Exception {     return settingDao.ADDelete(id); }
    @Override public List<ADResult> ADList() throws Exception {  return settingDao.ADList(); }


    @Override public int BTAdd(String bst,double mprice,double qprice, double sprice, double yprice, String remark) throws Exception {
        return settingDao.BTAdd(bst, mprice, qprice, sprice, yprice, remark);
    }

    @Override public int BTUpdate(String bst,double mprice,double qprice, double sprice, double yprice, String remark) throws Exception {
        return settingDao.BTUpdate(bst, mprice, qprice, sprice, yprice, remark);
    }

    @Override public int BTDelete(int id) throws Exception {     return settingDao.BTDelete(id); }
    @Override public List<BTResult> BTList() throws Exception {  return settingDao.BTList(); }


    @Override public String getApplyInfor() throws Exception {   return settingDao.getApplyInfor(); }
    @Override public int setApplyinfor(String ainfor) throws Exception { return settingDao.setApplyinfor(ainfor); }


    @Override public String getMaintainInfor() throws Exception { return settingDao.getMaintainInfor(); }
    @Override public int setMaintainInfor(String minfor) throws Exception { return settingDao.setMaintaininfor(minfor); }


    @Override public String getIntro() throws Exception { return settingDao.getIntro(); }
    @Override public int setIntro(String intro) throws Exception { return settingDao.setIntro(intro); }


}




package com.xt01.service;

import com.xt01.result.Setting.ADResult;
import com.xt01.result.Setting.BTResult;
import com.xt01.result.Setting.UGResult;

import java.util.List;

public interface SettingService {


    /**
     *  Usergroup
     */
    int UGAdd(String ugname) throws Exception;
    int UGDelete(int id) throws Exception;
    List<UGResult> UGList() throws Exception;

    /**
     *  Address
     */
    int ADAdd(String bulid) throws Exception;
    int ADDelete(int id) throws Exception;
    List<ADResult> ADList() throws Exception;

    /**
     *  BusinessType
     */
    int BTAdd(String bst, double mprice,double qprice, double sprice, double yprice, String remark) throws Exception;
    int BTUpdate(String bst, double mprice,double qprice, double sprice, double yprice, String remark) throws Exception;
    int BTDelete(int id) throws Exception;
    List<BTResult> BTList() throws Exception;


    String getApplyInfor() throws Exception;
    int setApplyinfor(String ainfor) throws Exception;

    String getMaintainInfor() throws Exception;
    int setMaintainInfor(String minfor) throws Exception;

    String getIntro() throws Exception;
    int setIntro(String intro) throws Exception;
}

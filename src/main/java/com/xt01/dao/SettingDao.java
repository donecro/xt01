package com.xt01.dao;


import com.xt01.result.Setting.ADResult;
import com.xt01.result.Setting.BTResult;
import com.xt01.result.Setting.UGResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SettingDao {

    /**
     *  Usergroup
     */
    int UGAdd(@Param("ugname") String ugname) throws Exception;

    int UGDelete(@Param("id") int id) throws Exception;

    List<UGResult> UGList() throws Exception;


    /**
     *  Address
     */
    int ADAdd(@Param("build") String bulid) throws Exception;

    int ADDelete(@Param("id") int id) throws Exception;

    List<ADResult> ADList() throws Exception;


    /**
     *  BusinessType
     */
    int BTAdd(@Param("bst") String bst,
              @Param("mprice") double mprice,
              @Param("qprice") double qprice,
              @Param("sprice") double sprice,
              @Param("yprice") double yprice,
              @Param("remark") String remark) throws Exception;

    int BTUpdate(@Param("bst") String bst,
                 @Param("mprice") double mprice,
                 @Param("qprice") double qprice,
                 @Param("sprice") double sprice,
                 @Param("yprice") double yprice,
                 @Param("remark") String remark) throws Exception;

    int BTDelete(@Param("id") int id) throws Exception;

    List<BTResult> BTList() throws Exception;

    BTResult BTgetByBst(@Param("bst") String bst) throws Exception;


    /**
     *  Infor
     */
    String getApplyInfor() throws Exception;

    int setApplyinfor(@Param("ainfor") String ainfor) throws Exception;

    String getMaintainInfor() throws Exception;

    int setMaintaininfor(@Param("minfor") String minfor) throws Exception;

    String getIntro() throws Exception;

    int setIntro(@Param("intro") String intro) throws Exception;
}

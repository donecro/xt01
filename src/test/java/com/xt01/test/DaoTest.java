package com.xt01.test;

import com.xt01.BaseTest;
import com.xt01.dao.AdminDao;
import com.xt01.dao.ApplyDao;
import com.xt01.dao.MaintainDao;
import com.xt01.dto.Login;
import com.xt01.entity.Admin;
import com.xt01.entity.Apply;
import com.xt01.entity.Maintain;
import com.xt01.service.AdminService;
import com.xt01.service.MaintainService;
import com.xt01.service.SettingService;
import com.xt01.utils.StringUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class DaoTest extends BaseTest {


    @Autowired
    private SettingService settingService;
    @Autowired
    private MaintainService maintainService;
    @Autowired
    private MaintainDao maintainDao;
    @Autowired
    private ApplyDao applyDao;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminService adminService;

    @Test
    public void Test3() throws Exception {
        Admin admin = adminDao.getAdminByLoginId(4);
        System.out.println("-------------->>>"+ admin +
                           "\n-------------->>>" + admin.toString());
    }








    @Test
    public  void Test12() throws Exception{
        List<Apply> l = applyDao.queryAll();
        System.out.println("---------------->>>\n" + l);
    }

    @Test
    public  void Test1() throws Exception{
        double sprice = 12.0;
        double yprice = 32.0;
        String c= sprice+"  "+yprice;
        int j = 0;
        String q = "", w = "", e;
        System.out.println("================" + c);
        for (int i=0; i<c.length(); i++){
            e = c.substring(i,i+1);
            if(e.equals(" ")) {
                j += 1;
            }else{
                if (j==0) {
                    q += e;
                    System.out.println("----->" + q);
                }else {
                    w += e;
                    System.out.println("----->" + w);
                }
            }
        }
        System.out.println(q+"<------------->"+w);
    }

    @Test
    public  void Test2() throws Exception{
        String a="无线10M###180.0  300.0";
        int k = 0;
        String bst = "";
        String e;
        for(int i=0; i<a.length();i++){
            e = a.substring(i,i+1);
            if(e.equals("#")){
                k++;
            }else{
                if(k==0){
                    bst += e;
                }
            }
        }
        System.out.println("------------>" + bst);
    }
}

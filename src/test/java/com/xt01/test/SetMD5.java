package com.xt01.test;

import com.xt01.BaseTest;
import com.xt01.utils.MD5Util;
import org.junit.Test;

public class SetMD5 extends BaseTest {

    @Test
    public  void getQ() throws Exception{
        String q = "asd123123";
        System.out.println("-----------" + MD5Util.Md5Encode(q));
    }
}

package com.xt01.test;

import com.xt01.BaseTest;

import com.xt01.dto.JWT;
import com.xt01.dto.ResponseData;
import org.junit.Test;

public class test extends BaseTest {

    @Test
    public void enen() throws Exception {
        String q = JWT.sign(new ResponseData(0,"haha"),3*1000);
        System.out.println("----------" + q);
        ResponseData a = JWT.unsign(q, ResponseData.class);
        System.out.println(a.toString());
    }

}


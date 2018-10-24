package com.xt01.controller;


import com.xt01.dto.SysUserVo;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.yedaxia.apidocs.ApiDoc;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 *  管理员界面
 */
@Controller
//@Deprecated
//@RequestMapping("/2018")
public class ViewController {

    /**
     //进入页面
     @RequestMapping(value = "/hntxxx")
     @ResponseBody
     public ModelAndView AdminIndex() {
     logger.info("status:{}","SomeBody want to login backstage management system...");
     return new ModelAndView("adminindex");
     }*/

    /**
     * 登录入口
     * @return View 页面
     */
    @ApiDoc(SysUserVo.class)
    @RequestMapping("/2018") public String GetIndex(){ return "index"; }

    /**
     * 文档入口
     * @return View 页面
     */
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/docs",method = RequestMethod.GET) public String GetDocs(){ return "docs/index"; }


}

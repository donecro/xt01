package com.xt01.controller;

import com.auth0.jwt.Algorithm;
import com.auth0.jwt.JWTVerifier;
import com.xt01.dto.SysUserVo;
import com.xt01.entity.Admin;
import com.xt01.entity.Apply;
import com.xt01.entity.Maintain;
import com.xt01.service.AdminService;
import com.xt01.service.ApplyService;
import com.xt01.service.MaintainService;
import com.xt01.service.SettingService;
import com.xt01.utils.MD5Util;
import com.xt01.dto.JWT;
import com.xt01.dto.Login;
import com.xt01.dto.ResponseData;
import com.xt01.utils.StringUtil;

import io.github.yedaxia.apidocs.ApiDoc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private MaintainService maintainService;

    @Autowired
    private ApplyService applyService;

    @Autowired
    private SettingService settingService;


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 处理登录
     * @return ResponseData 数据
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public ResponseData Login(HttpServletRequest req) {
        String account = req.getParameter("account");
        String password = MD5Util.Md5Encode(req.getParameter("password"));

        Login login = new Login();
        login.setAccount(account);
        login.setPassword(password);

        ResponseData r = ResponseData.ok();
        //先到数据库验证
        Integer loginid = adminService.CheckLogin(login);

        if (!loginid.equals(null)) {
            Admin admin = adminService.getAdminByLoginId(loginid);
            login.setId(loginid);
            //给用户jwt加密生成token
            String token = JWT.sign(login, 60L * 1000L * 30L);
            //封装成对象返回给客户端
            r.putDataValue("id", login.getId());
            r.putDataValue("token", token);
            r.putDataValue("user", admin);
        } else {
            r = ResponseData.customerError();
        }
        return r;
    }


    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/logout", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public ModelAndView Logout(HttpServletRequest request, HttpServletResponse response, SessionStatus sessionStatus) throws Exception {
        ModelAndView mav = new ModelAndView();

        //清除Session
        HttpSession session = request.getSession();
        session.removeAttribute("account");  //我这里是先取出httpsession中的user属性
        session.removeAttribute("username");
        session.removeAttribute("key");
        session.invalidate();  //然后是让httpsession失效

        //清除Cookie
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setPath(request.getContextPath() + "/");
            response.addCookie(cookie);
        }
        response.sendRedirect(request.getContextPath() + "/");

        mav.setViewName("redirect:/");
        return mav;
    }

    /**
     * 申请列表入口
     * @return View 页面
     */
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/apply",method = RequestMethod.GET)
    public String GetViewAp(){

        return "apply";

    }

    /**
     * 报修列表入口
     * @return View 页面
     */
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/maintain",method = RequestMethod.GET)
    public String GetViewMt(){
        return "maintain";
    }

    /**
     * 个人设置入口
     * @return View 页面
     */
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/person",method = RequestMethod.GET)
    public String GetViewPerson(){
        return "person";
    }

    /**
     * 系统设置入口
     * @return View 页面
     */
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/setting",method = RequestMethod.GET)
    public String GetViewSetting(){
        return "setting";
    }

    /**
     * 管理员操作入口（超级管理员）
     * @return View 页面
     */
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/adminmng",method = RequestMethod.GET)
    public String GetViewAdminMng(){
        return "adminmng";
    }

    /**
     * 校园网申请名单数据
     * @return ResponseData 数据
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/apdata", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public ResponseData GetDataAp(HttpServletRequest req , String token, String key) {
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key)).build();
//        DecodedJWT jwt = verifier.verify(token);
//        Map<String, Claim> claims = jwt.getClaims();
//        System.out.println(claims.get("name").asString());
        int page = Integer.valueOf(req.getParameter("page"));
        int size = 10;
        List<Apply> list = applyService.queryByPage(page, size);
        int count = applyService.queryCount();
        List<Apply> tolist = applyService.queryToByPage(page, size,new Date());
        int tocount = applyService.queryToCount(new Date());
        ResponseData r = ResponseData.ok();
        r.putDataValue("count", count);
        r.putDataValue("list", list);
        r.putDataValue("tocount", tocount);
        r.putDataValue("tolist", tolist);
        return r;
    }

    /**
     * 维修申请名单数据
     * @return ResponseData 数据
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/mtdata", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public ResponseData GetDataMt(HttpServletRequest req) {
        int page = Integer.valueOf(req.getParameter("page"));
        int size = 10;
        List<Maintain> list = maintainService.queryByPage(page, size);
        int count = maintainService.queryCount();
        List<Maintain> tolist = maintainService.queryToByPage(page, size, new Date());
        int tocount = maintainService.queryToCount(new Date());
        ResponseData r = ResponseData.ok();
        r.putDataValue("count", count);
        r.putDataValue("list", list);
        r.putDataValue("tocount", tocount);
        r.putDataValue("tolist", tolist);
        return r;
    }

    /**
     * 管理员名单数据（超级管理员）
     * @return ResponseData 数据
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/admngdata", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public ResponseData GetDataAm(HttpServletRequest req) throws Exception {
        ResponseData r = ResponseData.ok();
        r.putDataValue("count", 10);
        r.putDataValue("list", adminService.getList());
        return r;
    }

    /**
     * 设置数据
     * @return ResponseData 数据
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/stdata",method = RequestMethod.GET)
    public ResponseData GetDataSt(HttpServletRequest req) throws Exception {
        ResponseData r = ResponseData.ok();
        r.putDataValue("intro", settingService.getIntro());
        r.putDataValue("minfor",settingService.getMaintainInfor());
        r.putDataValue("ainfor",settingService.getApplyInfor());
        r.putDataValue("uglist",settingService.UGList());
        r.putDataValue("adlist",settingService.ADList());
        r.putDataValue("btlist",StringUtil.BTFalseToTure(settingService.BTList()));
        return r;
    }
}

package com.xt01.controller;

import com.xt01.dto.ResponseData;
import com.xt01.dto.SysUserVo;
import com.xt01.service.AdminService;
import com.xt01.service.ApplyService;
import com.xt01.service.SettingService;
import com.xt01.utils.MD5Util;
import com.xt01.utils.StringUtil;

import io.github.yedaxia.apidocs.ApiDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *  设置
 */
@Controller
public class SettingController {

    @Autowired
    private ApplyService applyService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private SettingService settingService;

    /**
     * 系统设置_校园网介绍更改
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/infor/intro", method = RequestMethod.POST)
    public ResponseData InforIntroSet(HttpServletRequest req) throws Exception {
        String intro = new String(req.getParameter("intro").getBytes("iso-8859-1"), "utf-8");
        int i = settingService.setIntro(intro);
        ResponseData r =ResponseData.ok();
        if (i != 1) r = ResponseData.badRequest();
        return r;
    }

    /**
     * 系统设置_校园网申请须知更改
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/infor/apply", method = RequestMethod.POST)
    public ResponseData InforApplySet(HttpServletRequest req) throws Exception {
        String ainfor = new String(req.getParameter("ainfor").getBytes("iso-8859-1"), "utf-8");
        int i = settingService.setApplyinfor(ainfor);
        ResponseData r =ResponseData.ok();
        if (i != 1) r = ResponseData.badRequest();
        return r;
    }

    /**
     * 系统设置_维修申请须知更改
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/infor/maintain", method = RequestMethod.POST)
    public ResponseData InforMaintainSet(HttpServletRequest req) throws Exception {
        String minfor = new String(req.getParameter("minfor").getBytes("iso-8859-1"), "utf-8");
        int i = settingService.setMaintainInfor(minfor);
        ResponseData r =ResponseData.ok();
        if (i != 1) r = ResponseData.badRequest();
        return r;
    }

    /**
     * 系统设置_用户组删除
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/ugdel",method = RequestMethod.POST)
    public ResponseData UGDel(HttpServletRequest req) throws Exception {
        int i = settingService.UGDelete(Integer.valueOf(req.getParameter("id")));
        ResponseData r =ResponseData.ok();
        if (i != 1) r = ResponseData.badRequest();
        return r;
    }

    /**
     * 系统设置_用户组添加
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/ugadd",method = RequestMethod.POST)
    public ResponseData UGAdd(HttpServletRequest req) throws Exception{
        String ugname = new String(req.getParameter("ugname").getBytes("iso-8859-1"), "utf-8");
        int i = settingService.UGAdd(ugname);
        ResponseData r =ResponseData.ok();
        if (i != 1) r = ResponseData.badRequest();
        return r;
    }

    /**
     * 系统设置_地址删除
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/addel",method = RequestMethod.POST)
    public ResponseData ADDel(HttpServletRequest req) throws Exception{
        int i = settingService.ADDelete(Integer.valueOf(req.getParameter("id")));
        ResponseData r =ResponseData.ok();
        if (i != 1) r = ResponseData.badRequest();
        return r;
    }

    /**
     * 系统设置_地址添加
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/adadd",method = RequestMethod.POST)
    public ResponseData ADAdd(HttpServletRequest req) throws Exception {
        String build = new String(req.getParameter("build").getBytes("iso-8859-1"), "utf-8");
        int i = settingService.ADAdd(build);
        ResponseData r =ResponseData.ok();
        if (i != 1) r = ResponseData.badRequest();
        return r;
    }

    /**
     * 系统设置_业务类型删除
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/btdel",method = RequestMethod.POST)
    public ResponseData BTDel(HttpServletRequest req) throws Exception {
        int i = settingService.BTDelete(Integer.valueOf(req.getParameter("id")));
        ResponseData r =ResponseData.ok();
        if (i != 1) r = ResponseData.badRequest();
        return r;
    }

    /**
     * 系统设置_业务类型增加
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/btadd",method = RequestMethod.POST)
    public ResponseData BTAdd(HttpServletRequest req) throws Exception {
        String bst = new String(req.getParameter("bst").getBytes("iso-8859-1"), "utf-8");
        double mprice = Integer.valueOf(req.getParameter("mprice"));
        double qprice = Integer.valueOf(req.getParameter("qprice"));
        double sprice = Integer.valueOf(req.getParameter("sprice"));
        double yprice = Integer.valueOf(req.getParameter("yprice"));
        String remark = "";
        int i = settingService.BTAdd(StringUtil.Tofalse(bst), mprice, qprice, sprice, yprice, remark);
        ResponseData r =ResponseData.ok();
        if (i != 1) r = ResponseData.badRequest();
        return r;
    }

    /**
     * 系统设置_业务类型更改
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/btupdate",method = RequestMethod.POST)
    public ResponseData BTUpdate(HttpServletRequest req) throws Exception {
        String bst = new String(req.getParameter("bst").getBytes("iso-8859-1"), "utf-8");
        String remark = "";
        double mprice = Integer.valueOf(req.getParameter("newmp"));
        double qprice = Integer.valueOf(req.getParameter("qprice"));
        double sprice = Integer.valueOf(req.getParameter("newsp"));
        double yprice = Integer.valueOf(req.getParameter("newyp"));
        int i = settingService.BTUpdate(bst, mprice, qprice, sprice, yprice, remark);
        ResponseData r =ResponseData.ok();
        if (i != 1) r = ResponseData.badRequest();
        return r;
    }

    /**
     * 系统设置_学生信息清除
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/identity/clear",method = RequestMethod.POST)
    public ResponseData IdentityClean(HttpServletRequest req) throws Exception{
        int i = applyService.IdentityClean();
        ResponseData r =ResponseData.ok();
        if (i != 1) r = ResponseData.badRequest();
        return r;
    }

    /**
     * 管理员添加
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public ResponseData AdminAdd(HttpServletRequest req) throws Exception {
        String newaccount = new String(req.getParameter("newaccount").getBytes("iso-8859-1"), "utf-8");
        String newusername = new String(req.getParameter("newusername").getBytes("iso-8859-1"), "utf-8");
        String newpassword = MD5Util.Md5Encode(new String(req.getParameter("newpassword").getBytes("iso-8859-1"), "utf-8"));
        int newpower = Integer.valueOf(req.getParameter("newpower"));
        ResponseData r;
        int state =  adminService.AddAdmin(newaccount,newusername,newpassword,newpower);
        if (state ==1) {
            r = ResponseData.ok();
            r.putDataValue("message", "添加成功");
        }else {
            r = ResponseData.forbidden();
            r.putDataValue("message","添加失败");
        }
        return r;
    }

    /**
     * 管理员删除
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/admin/del",method = RequestMethod.POST)
    public ResponseData AdminDel(HttpServletRequest req) throws Exception{
        String ac = req.getParameter("account");
        Integer id = (Integer) req.getSession().getAttribute("id");
        int i = adminService.DeleteAdmin(id);
        ResponseData r =ResponseData.ok();
        if (i != 1) r = ResponseData.badRequest();
        return r;
    }

    /**
     * 管理员权限更改
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/admin/update/power", method = RequestMethod.POST)
    public ResponseData AdminPower(HttpServletRequest req) throws Exception {
        int id = Integer.valueOf(req.getParameter("id"));
        int ipower = Integer.valueOf(req.getParameter("ipower"));
        ResponseData r;
        int state = adminService.UpdatePower(id,ipower);
        if (state == 1) {
            r = ResponseData.ok();
            r.putDataValue("message", "更改管理员权限成功");
        }else {
            r = ResponseData.forbidden();
            r.putDataValue("message","更改管理员权限失败");
        }

        return r;
    }

    /**
     * 个人设置_用户名更改
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/admin/update/adminname", method = RequestMethod.POST)
    public ResponseData AdminUpdateName(HttpServletRequest req) throws Exception {
        String newusername = new String(req.getParameter("newusername").getBytes("iso-8859-1"), "utf-8");
        ResponseData r;
        Integer id = (Integer) req.getSession().getAttribute("id");
        int state = adminService.UpdateUsername(id,newusername);
        if ( state == 1) {
            r = ResponseData.ok();
            r.putDataValue("message", "更改用户名成功");
        } else {
            r = ResponseData.forbidden();
            r.putDataValue("message", "修改错误，请重新编写");
        }

        return r;
    }

    /**
     * 个人设置_密码更改
     * @return ResponseData 数据
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/admin/update/password", method = RequestMethod.POST)
    public ResponseData AdminUpdatePassword(HttpServletRequest req) throws Exception {
        String newpassword = new String(req.getParameter("newpassword").getBytes("iso-8859-1"), "utf-8");
        ResponseData r;
        Integer id = (Integer) req.getSession().getAttribute("id");
        int state = adminService.UpdatePwd(id,MD5Util.Md5Encode(newpassword));
        if ( state == 1) {
            r = ResponseData.ok();
            r.putDataValue("message", "更改密码成功");
        } else {
            r = ResponseData.forbidden();
            r.putDataValue("message", "修改错误，请重新编写");
        }
        return r;
    }

}

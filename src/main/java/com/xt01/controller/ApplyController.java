package com.xt01.controller;

import com.xt01.dto.SysUserVo;
import com.xt01.result.*;
import com.xt01.result.Setting.ADResult;
import com.xt01.result.Setting.BTResult;
import com.xt01.result.Setting.UGResult;
import com.xt01.service.ApplyService;
import com.xt01.service.SettingService;

import com.xt01.utils.StringUtil;
import io.github.yedaxia.apidocs.ApiDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    @Autowired
    private SettingService settingService;


    //申请流程：  用户须知 -->> 验证表单 -->> 学号和身份证匹配 合法-->> 是否申请过申请 Y-->>  旧用户续费 Update   申请表单 -->> 支付 -->>  支付成功
    //                                                                          N-->>  新用户 Add

    /**
     * 用户须知界面
     * @return
     * @throws Exception
     */
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/p",method = RequestMethod.GET)
    public ModelAndView InPerson(HttpServletRequest req) throws Exception {
        String message = settingService.getApplyInfor();
        return new ModelAndView("person/applymust","message",message);
    }

    /**
     * 验证页面
     * @return
     * @throws Exception
     */
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/person",method = RequestMethod.GET)
    public String Personcheck(HttpServletRequest req) throws Exception {
        return "person/personcheck";
    }

    /**
     * 验证学号和身份证是否违法
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/check", produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    public ModelAndView ApplyCheck(HttpServletRequest req,HttpServletResponse res) throws Exception {
        String username = new   String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
        long   callnum  = Long.valueOf(req.getParameter("callnum"));
        String sex      = new   String(req.getParameter("sex").getBytes("iso-8859-1"), "utf-8");
        long   uid      = Long.valueOf(req.getParameter("uid"));
        String identity = req.getParameter("identity");

        ModelAndView mav = new ModelAndView();
        int key = applyService.DoCheck(uid,identity);
        CheckResult cr = new CheckResult(username,callnum,sex,uid,identity,key);

        if (key==1) {
            HttpSession session = req.getSession();
            session.setAttribute("cr", cr);

            mav.setViewName("person/personsave");
            mav.addObject("uglist",settingService.UGList());
            mav.addObject("adlist",settingService.ADList());
            mav.addObject("btlist",StringUtil.BTFalseToTure(settingService.BTList()));
        }else if(key== -1) {
            mav.setViewName("person/illegal");
            mav.addObject("message","用户已申请");
        }else if(key== -2) {
            mav.setViewName("person/illegal");
            mav.addObject("message","用户学号不在校检库中，请确认学号填写正确");
        }else if(key==0) {
            mav.setViewName("person/illegal");
            mav.addObject("message","用户身份非法,请确认学号和身份证号填写正确");
        }
        return mav;
    }

    /**
     * 支付
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ApiDoc(SysUserVo.class)
    @RequestMapping(value = "/pay", produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    public ModelAndView ApplyPay(HttpServletRequest request) throws Exception {
        CheckResult cr = (CheckResult) request.getSession().getAttribute("cr");

        String add1      = new String(request.getParameter("add1").getBytes("iso-8859-1"), "utf-8");
        String add2      = new String(request.getParameter("add2").getBytes("iso-8859-1"), "utf-8");
        String usergroup = new String(request.getParameter("usergroup").getBytes("iso-8859-1"), "utf-8");
        String bst1      = new String(request.getParameter("bst").getBytes("iso-8859-1"), "utf-8");
        int k = 0;
        String bst = "";
        String e;
        for(int i=0; i<bst1.length();i++){
            e = bst1.substring(i,i+1);
            if(e.equals("#")){
                k++;
            }else{
                if(k==0){
                    bst += e;
                }
            }
        }
        int forlong = Integer.valueOf(request.getParameter("forlong"));
        int acode = 0;
        String address = add1+add2;
        String applytime = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
        double totalfee = applyService.Price(StringUtil.Tofalse(bst),forlong);
        PayResult pr = new PayResult(
                cr.getUsername(),
                cr.getSex(),
                cr.getUid(),
                cr.getCallnum(),
                usergroup,
                address,
                StringUtil.Tofalse(bst),
                forlong,
                cr.getIdentity(),
                acode,
                cr.getIdentity().substring(cr.getIdentity().length()-6),
                applytime,
                totalfee
        );
        request.getSession().setAttribute("pr",pr);
        return  new ModelAndView(new RedirectView("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxab87da843aeec540&redirect_uri=http%3a%2f%2fwww.cnmit.net%2fm%2fweChat%2funifiedOrder&response_type=code&scope=snsapi_base#wechat_redirect"));

    }

}

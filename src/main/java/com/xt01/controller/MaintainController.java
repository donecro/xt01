package com.xt01.controller;

import com.xt01.entity.Maintain;
import com.xt01.result.Setting.ADResult;
import com.xt01.service.MaintainService;
import com.xt01.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/maintain")
public class MaintainController {

    @Autowired
    private SettingService settingService;

    @Autowired
    private MaintainService maintainService;

    // 添加维修表单
    //申请流程：  用户须知 -->> 申请表单 -->> 申请成功，等待维修 -->> 维修状态
    @RequestMapping(value = "/p",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView InMain(HttpServletRequest req) throws Exception {
        String message = settingService.getMaintainInfor();
        return new ModelAndView("person/maintainmust","message",message);
    }

    @RequestMapping(value = "/next",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView SetMain(HttpServletRequest req) throws Exception {
        ModelAndView mav =  new ModelAndView();
        List<ADResult> adl = settingService.ADList();
        mav.setViewName("person/maintain");
        mav.addObject("adl",adl);
        return mav;
    }

    @RequestMapping(value = "/finish",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView ReMain(HttpServletRequest req) throws Exception {
        String username = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
        String account = new String(req.getParameter("account").getBytes("iso-8859-1"), "utf-8");
        long callnum = Long.valueOf(req.getParameter("callnum"));
        String campus = new String(req.getParameter("campus").getBytes("iso-8859-1"), "utf-8");
        String address = new String(req.getParameter("address").getBytes("iso-8859-1"), "utf-8");
        String content = new String(req.getParameter("content").getBytes("iso-8859-1"), "utf-8");
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());

        ModelAndView mav = new ModelAndView();
        Maintain m = new Maintain(username, account, callnum, campus, address, content, date);
        int state = maintainService.submitMaintain(m);
        if (state == 1) {
            mav.setViewName("person/msuccess");
        } else {
            mav.setViewName("person/merror");
        }
        return mav;
    }


    @RequestMapping(value = "/intro",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView InPerson(HttpServletRequest req) throws Exception {
        String message = settingService.getIntro();
        return new ModelAndView("person/intro","message",message);
    }

}


package com.xt01.controller;

import com.xt01.result.PayResult;
import com.xt01.service.ApplyService;
import com.xt01.utils.XMLUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
public class NotifyController {

    @Autowired
    private ApplyService applyService;

    /**
     *  接收微信支付成功通知
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws java.io.IOException
     */
    @RequestMapping("/qweasdzxc/notify")
    public void getnotify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.创建输入输出流
        String notifyStr = "";
        PrintWriter writer = response.getWriter();
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        //2.将结果转换
        String result = new String(outSteam.toByteArray(), "utf-8");
        System.out.println("微信支付通知结果：" + result);
        Map<String, String> map = null;
        try {
            //3.解析微信通知返回的信息
            map = XMLUtil.doXMLParse(result);
        } catch (org.jdom2.JDOMException e) {
            e.printStackTrace();
        }
        // 4.若支付成功，则告知微信服务器收到通知
        if (map.get("return_code").equals("SUCCESS")) {
            if (map.get("result_code").equals("SUCCESS")) {
//                System.err.println("通知微信后台");
                notifyStr = XMLUtil.setXML("SUCCESS", "");
                writer.write(notifyStr);
                writer.flush();
            } else {
                notifyStr = XMLUtil.setXML("ERROR", "");
                writer.write(notifyStr);
                writer.flush();
            }
        }
    }


        @RequestMapping(value = "/qweasdzxc/add",method = RequestMethod.GET)
        @ResponseBody
        public ModelAndView notify(HttpServletRequest request, HttpServletResponse response) throws Exception {
            PayResult pr = (PayResult) request.getSession().getAttribute("pr");
            ModelAndView mav = new ModelAndView();
            System.out.println("===============付款成功==============");
            // ------------------------------
            // 处理业务开始
            // ------------------------------
            // 此处处理订单状态，结合自己的订单数据完成订单状态的更新
            // ------------------------------
            int state =  applyService.AddApply(
                        pr.getUsername(),
                        pr.getSex(),
                        pr.getUid(),
                        pr.getCallnum(),
                        pr.getUsergroup(),
                        pr.getAddress(),
                        pr.getBst(),
                        pr.getForlong(),
                        pr.getIdentity(),
                        pr.getAcode(),
                        pr.getPassword(),
                        pr.getApplytime(),
                        pr.getTotalfee());
            if (state ==1){
                System.out.println("===========申请成功============");
                mav.setViewName("person/asuccess");
            }else {
                System.out.println("===========添加错误============");
                mav.setViewName("person/aerror");
            }
            request.getSession().removeAttribute("cr");
            request.getSession().removeAttribute("pr");
            request.getSession().invalidate();
            return mav;
        }

}

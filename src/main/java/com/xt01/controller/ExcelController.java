package com.xt01.controller;

import com.xt01.entity.Identity;
import com.xt01.service.ApplyService;
import com.xt01.service.ExcelService;

import com.xt01.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @Autowired
    private ApplyService applyService;

    @RequestMapping("/export")
    @ResponseBody
    public ModelAndView export(HttpServletRequest req, HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        String account = (String) req.getSession().getAttribute("account");
        if (account!="" && account!=null){

            response.setContentType("application/binary;charset=UTF-8");
        try{
            ServletOutputStream out=response.getOutputStream();
            String fileName="Xiaoyuanwang " +new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
            excelService.export(out);
            mav.addObject("message","导出成功");
        } catch(Exception e){
            e.printStackTrace();
            mav.addObject("message","导出失败");
        }
        }else {
            mav.setViewName("nologin");
            mav.addObject("message","用户身份凭证已过期，请重新登录");
        }
        return mav;
    }


    @RequestMapping("/today/export")
    @ResponseBody
    public ModelAndView TodayExport(HttpServletRequest req , HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        String account = (String) req.getSession().getAttribute("account");
        if (account!="" && account!=null){
            response.setContentType("application/binary;charset=UTF-8");
        try{
            ServletOutputStream out=response.getOutputStream();
            String fileName="Xiaoyuanwang-Today" +new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
            String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            excelService.TodayExport(out,new Date());
            mav.addObject("message","导出成功");
        } catch(Exception e){
            e.printStackTrace();
            mav.addObject("message","导出失败");
        }
        }else {
            mav.setViewName("nologin");
            mav.addObject("message","用户身份凭证已过期，请重新登录");
        }
        return mav;
    }


    @RequestMapping(value = "/date/export",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView DateExport(HttpServletRequest request,HttpServletResponse response){
        String start = request.getParameter("start");
        String end = request.getParameter("end");

        ModelAndView mav = new ModelAndView();
        String account = (String) request.getSession().getAttribute("account");
        if (account!="" && account!=null){
        response.setContentType("application/binary;charset=UTF-8");
        try{
            ServletOutputStream out=response.getOutputStream();
            String fileName="Xiaoyuanwang "+ start + "to"+end;
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
            Date s = StringUtil.Date2(start);
            Date e = StringUtil.Date2(end);
            excelService.DateExport(out, s, e);
            mav.addObject("message","导出成功");
        } catch(Exception e){
            e.printStackTrace();
            mav.addObject("message","导出失败");
        }
        }else {
            mav.setViewName("nologin");
            mav.addObject("message","用户身份凭证已过期，请重新登录");
        }
        return mav;
    }

    @RequestMapping("/maintain/export")
    @ResponseBody
    public ModelAndView MaintainExport(HttpServletRequest req ,HttpServletResponse response){
            ModelAndView mav = new ModelAndView();
            String account = (String) req.getSession().getAttribute("account");
            if (account!="" && account!=null){

            response.setContentType("application/binary;charset=UTF-8");
        try{
            ServletOutputStream out=response.getOutputStream();
            String fileName= "Baoxiu" +  new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
            excelService.MtExport(out);
            mav.addObject("message","导出成功");
        } catch(Exception e){
            e.printStackTrace();
            mav.addObject("message","导出失败");
        }
            }else {
                mav.setViewName("nologin");
                mav.addObject("message","用户身份凭证已过期，请重新登录");
            }
        return mav;
    }

    @RequestMapping("/maintain/today/export")
    @ResponseBody
    public ModelAndView MaintainTodayExport(HttpServletRequest req ,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        String account = (String) req.getSession().getAttribute("account");
        if (account!="" && account!=null){
        response.setContentType("application/binary;charset=UTF-8");
        try{
            ServletOutputStream out=response.getOutputStream();
            String fileName= "Baoxiu" +  new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
            Date today = new Date();

            excelService.MtTodayExport(out,today);
            mav.addObject("message","导出成功");
        } catch(Exception e){
            e.printStackTrace();
            mav.addObject("message","导出失败");
        }
        }else {
            mav.setViewName("nologin");
            mav.addObject("message","用户身份凭证已过期，请重新登录");
        }
        return mav;
    }

    @RequestMapping(value = "/maintain/date/export",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView MaintainDateExport(HttpServletRequest request, HttpServletResponse response){
        String start = request.getParameter("start");
        String end = request.getParameter("end");

        ModelAndView mav = new ModelAndView();
        String account = (String) request.getSession().getAttribute("account");
        if (account!="" && account!=null){
            response.setContentType("application/binary;charset=UTF-8");
            try{
                ServletOutputStream out=response.getOutputStream();
                String fileName="Baoxiu "+ start + "to"+end;
                response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
                Date s = StringUtil.Date2(start);
                Date e = StringUtil.Date2(end);
                excelService.MtDateExport(out, s, e);
                mav.addObject("message","导出成功");
            } catch(Exception e){
                e.printStackTrace();
                mav.addObject("message","导出失败");
            }
        }else {
            mav.setViewName("nologin");
            mav.addObject("message","用户身份凭证已过期，请重新登录");
        }
        return mav;
    }

    @RequestMapping("/identity/export")
    @ResponseBody
    public ModelAndView IdentityExport(HttpServletRequest req, HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        String account = (String) req.getSession().getAttribute("account");
        if (account!="" && account!=null){

            response.setContentType("application/binary;charset=UTF-8");
            try{
                ServletOutputStream out=response.getOutputStream();
                String fileName="Identity " +new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
                excelService.IdentityExport(out);
                mav.addObject("message","导出成功");
            } catch(Exception e){
                e.printStackTrace();
                mav.addObject("message","导出失败");
            }
        }else {
            mav.setViewName("nologin");
            mav.addObject("message","用户身份凭证已过期，请重新登录");
        }
        return mav;
    }

    @RequestMapping(value="/upload",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView uploadExcel(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        String account = (String) request.getSession().getAttribute("account");
        if (account!="" && account!=null){

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        System.out.println("uploadexcel...");
        InputStream in =null;
        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            System.out.println("文件为空");
        }else {
            System.out.println("文件存在");
        }
        in = file.getInputStream();
            List<Identity> list = excelService.getBankListByExcel(in, file.getOriginalFilename());
            in.close();
            int k = 0;
            for (int i = 0; i < list.size(); i++) {
                Identity identity = list.get(i);

                int state = applyService.InsertIdentityExcel(
                        identity.getUid(),
                        identity.getUsername(),
                        identity.getOver(),
                        identity.getSex(),
                        identity.getEmail(),
                        identity.getIdentity(),
                        identity.getCallnum(),
                        identity.getAddress());
                if (state == 1) {
                    System.out.println("Success!!!");
                    k++;
                } else {
                    System.out.println("False!!!");
                }}
                if (k == list.size()) {
                    mav.setViewName("nologin");
                    mav.addObject("message", "信息导入成功");

                } else {
                    mav.setViewName("nologin");
                    mav.addObject("message", "信息导入不完整，请检查文档格式是否正确");
                }
        }else {
            mav.setViewName("nologin");
            mav.addObject("message","用户身份凭证已过期，请重新登录");
        }
        return mav;
    }
}
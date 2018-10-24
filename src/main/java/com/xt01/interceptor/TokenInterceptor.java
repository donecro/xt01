package com.xt01.interceptor;

import com.xt01.dto.Login;
import com.xt01.dto.JWT;
import com.xt01.dto.ResponseData;

import com.alibaba.fastjson.JSONObject;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class TokenInterceptor implements HandlerInterceptor{

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3) { }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model){ }

    //拦截每个请求
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setCharacterEncoding("utf-8");
        String token = request.getParameter("token");

        //token不存在
        if(token != null) {
            Login login = JWT.unsign(token, Login.class);

            Integer loginId = Integer.valueOf(request.getParameter("loginId"));
            //解密token后的loginId与用户传来的loginId不一致，一般都是token过期
            if(loginId != null && login != null) {
                if(loginId == login.getId()) {
                    return true;
                } else {
                    responseMessage(response, response.getWriter());
                    return false;
                }
            } else {
                responseMessage(response, response.getWriter());
                return false;
            }
        } else {
            responseMessage(response, response.getWriter());
            return false;
        }
    }

    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response, PrintWriter out) {
        ResponseData responseData = ResponseData.forbidden();
        response.setContentType("application/json; charset=utf-8");
        String json = JSONObject.toJSONString(responseData);
        out.print(json);
        out.flush();
        out.close();
    }

}

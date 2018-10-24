package com.xt01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xt01.config.Constant;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/tesyuit")
public class IndexController {
	@RequestMapping(value = "/p")
	public String index(Model model) {
		model.addAttribute("payURL", Constant.PAY_URL);
		return "wx/index";
	}

	@RequestMapping(value = "/t")
    public String indexs(HttpServletRequest request) {
        request.getSession().setAttribute("mon",10);
        return "redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxab87da843aeec540&redirect_uri=http%3a%2f%2fwww.donecro.cn%2fm%2fweChat%2funifiedOrder&response_type=code&scope=snsapi_base#wechat_redirect";
    }
}

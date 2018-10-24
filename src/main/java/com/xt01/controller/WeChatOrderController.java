package com.xt01.controller;

import com.xt01.result.PayResult;
import com.xt01.wxpay.sdk.MyConfig;
import com.xt01.wxpay.sdk.WXPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xt01.config.Constant;
import com.xt01.entity.pay.AuthToken;
import com.xt01.service.PayService;
import com.xt01.utils.PayUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Controller
@RequestMapping(value = "/m/weChat")
public class WeChatOrderController {

	@Autowired
	private PayService payService;

	/**
	 * 统一下单
	 */
	@RequestMapping(value = "/unifiedOrder")
	public ModelAndView unifiedOrde(HttpServletRequest request, Model model) throws Exception {
		ModelAndView mav = new ModelAndView();
		PayResult pr = (PayResult) request.getSession().getAttribute("pr");
        int totalFee = (int) (pr.getTotalfee()*100);
		// 用户同意授权，获得的code
		String code = request.getParameter("code");
		// 通过code获取网页授权access_token
		AuthToken authToken = PayUtils.getTokenByAuthCode(code);
		// 调用统一下单service
		String prepayId = payService.unifiedOrder(authToken, request.getRemoteAddr(),totalFee);
		if (!PayUtils.isEmpty(prepayId)) {
			String timeStamp = PayUtils.getTimeStamp();// 当前时间戳
			String nonceStr = PayUtils.getRandomStr(20);// 不长于32位的随机字符串

			SortedMap<String, Object> signMap = new TreeMap<String, Object>();// 自然升序map
			signMap.put("appId", Constant.APP_ID);
			signMap.put("package", prepayId);
			signMap.put("timeStamp", timeStamp);
			signMap.put("nonceStr", nonceStr);
			signMap.put("signType", "MD5");

			model.addAttribute("appId", Constant.APP_ID);
			model.addAttribute("timeStamp", timeStamp);
			model.addAttribute("nonceStr", nonceStr);
			model.addAttribute("prepayId", prepayId);
			model.addAttribute("paySign", PayUtils.getSign(signMap));// 获取签名
		} else {
			System.out.println("微信统一下单失败,订单编号:失败原因");
			mav.setViewName("person/illegal");
			mav.addObject("message","\nprepay =\n"+prepayId);
			return mav;
		}
		// 将支付需要参数返回至页面，采用h5方式调用支付接口
		mav.setViewName("wx/h5Pay");
		return mav;
	}


	/**
	 * 统一下单
	 */
	@RequestMapping(value = "/unifiedOrder")
	public void unifiedOrder(HttpServletRequest req, Model model) throws Exception {
		WXPay wxpay = new WXPay(new MyConfig());
		Map<String, String> data = new HashMap<String, String>();
		data.put("body", "校园网缴费");
		data.put("out_trade_no", PayUtils.getRandomStr(8));
		data.put("device_info", "WEB");
		data.put("fee_type", "CNY");
		data.put("total_fee", "1");
		data.put("spbill_create_ip", req.getRemoteAddr());
		data.put("notify_url", "http://www.cnmit.net/qweasdzxc/notify");
		data.put("trade_type", "JSAPI");  // 此处指定为JSAPI支付
		data.put("product_id", "12");

		try {
			Map<String, String> resp = wxpay.unifiedOrder(data);
			System.out.println(resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
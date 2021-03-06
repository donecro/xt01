package com.xt01.service.impl;

import com.xt01.service.PayService;
import com.xt01.config.Constant;
import com.xt01.entity.pay.AuthToken;
import com.xt01.entity.pay.PaySendData;
import com.xt01.utils.HttpUtil;
import com.xt01.utils.PayUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

	/**
	 * 微信支付统一下单
	 **/
	public String unifiedOrder(AuthToken authToken, String remoteAddr,int totalFee) {
		Map<String, String> resultMap = null;
		// 统一下单返回的预支付id
		String prepayId = null;
		PaySendData paySendData = new PaySendData();
		// 构建微信支付请求参数集合
		paySendData.setAppId(Constant.APP_ID);
		paySendData.setMch_id(Constant.MCH_ID);
		paySendData.setNotify_url(Constant.NOTIFY_URL);
		paySendData.setTrade_type(Constant.TRADE_TYPE_JSAPI);
		paySendData.setDevice_info(Constant.WEB);
		paySendData.setBody("校园网缴费");
		paySendData.setNonce_str(PayUtils.getRandomStr(32));
		paySendData.setOut_trade_no(PayUtils.getRandomStr(8));
		paySendData.setTotal_fee(totalFee);
		paySendData.setSpbill_create_ip(remoteAddr);
		paySendData.setOpenId(authToken.getOpenid());
		// 将参数拼成map,生产签名
		paySendData.setSign(PayUtils.getSign(buildParamMap(paySendData)));
		// 将请求参数对象转换成xml
		String reqXml = PayUtils.sendDataToXml(paySendData);
		try {
			// 发送请求
			CloseableHttpResponse response = HttpUtil.Post(Constant.UNIFIED_ORDER_URL, reqXml, false);
			try {
				resultMap = PayUtils.parseXml(response.getEntity().getContent());
				// 关闭流
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		} catch (Exception e) {
			System.out.println("微信支付统一下单异常");
		}
		String return_code = resultMap.get("return_code");
		String result_code = resultMap.get("result_code");
		if (Constant.RETURN_SUCCESS.equals(return_code) && Constant.RETURN_SUCCESS.equals(result_code)) {
			// return_code=通信标识
			// result_code=交易标识
			// 只有当returnCode与resultCode均返回“success”，才代表微信支付统一下单成功
			prepayId = "prepay_id=" + resultMap.get("prepay_id");
		}
		return prepayId;
	}

	/**
	 * 构建统一下单参数map 用于生成签名
	 * 
	 * @param data
	 * @return SortedMap<String,Object>
	 */
	private SortedMap<String, Object> buildParamMap(PaySendData data) {
		SortedMap<String, Object> paramters = new TreeMap<String, Object>();
		Field[] fields = data.getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				if (null != field.get(data)) {
					paramters.put(field.getName().toLowerCase(), field.get(data).toString());
				}
			}
		} catch (Exception e) {
			System.out.print("构建签名map错误: ");
			e.printStackTrace();
		}

		return paramters;
	}

}

package com.xt01.service;

import com.xt01.entity.pay.AuthToken;

public interface PayService {
	
	/**
	 * 统一下单接口
	 * @param authToken 授权token
	 * @param remoteAddr 请求主机ip
	 * @return prepayId 预支付id
	 */
	String unifiedOrder(AuthToken authToken, String remoteAddr,int totalFee);

}

package com.xt01.config;

public class Constant {
	/**
	 * 公众号AppId
	 */
	public static final String APP_ID = "wxab87da843aeec540";

	/**
	 * 公众号AppSecret
	 */
	public static final String APP_SECRET = "e1754ba41950f0937c24618cfd03aacc";

	/**
	 * 微信支付商户号
	 */
	public static final String MCH_ID = "1510733361";

	/**
	 * 微信支付API秘钥
	 */
	public static final String KEY = "qwertyuiopASDFGHJKLZXCVBNM123456";

	/**
	 * 微信交易类型:公众号支付
	 */
	public static final String TRADE_TYPE_JSAPI = "JSAPI";

	/**
	 * WEB
	 */
	public static final String WEB = "WEB";

	/**
	 * 返回成功字符串
	 */
	public static final String RETURN_SUCCESS = "SUCCESS";

	/**
	 * 支付地址(包涵回调地址)
	 */
	public static final String PAY_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxab87da843aeec540&redirect_uri=http%3a%2f%2fwww.cnmit.net%2fm%2fweChat%2funifiedOrder&response_type=code&scope=snsapi_base#wechat_redirect";

	/**
	 * 微信统一下单url
	 */
	public static final String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	/**
	 * 微信支付通知url
	 */
	public static final String NOTIFY_URL = "http://www.cnmit.net/qweasdzxc/notify";
	
	/**
	 * 证书位置
	 */
	public static final String CERT_PATH = "classpath:cert/apiclient_cert.p12";

	/**
	 * 通过code获取授权access_token的URL
	 */
	public static String Authtoken_URL(String code) {
		StringBuffer url = new StringBuffer();
		url.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
		url.append(Constant.APP_ID);
		url.append("&secret=");
		url.append(Constant.APP_SECRET);
		url.append("&code=");
		url.append(code);
		url.append("&grant_type=authorization_code");
		return url.toString();
	}
}

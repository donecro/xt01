package com.xt01.wxpay.sdk;

import java.util.HashMap;
import java.util.Map;

public class WXPayExample {


    public static void main(String[] args) throws Exception {

    }

    /**
     *  统一下单
     * @throws Exception
     */
    void A() throws Exception {
        WXPay wxpay = new WXPay(new MyConfig());

        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "腾讯充值中心-QQ会员充值");
        data.put("out_trade_no", "2016090910595900000012");
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", "http://www.example.com/wxpay/notify");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "12");

        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *  订单查询
     * @throws Exception
     */
    void B() throws Exception {
        WXPay wxpay = new WXPay(new MyConfig());

        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", "2016090910595900000012");

        try {
            Map<String, String> resp = wxpay.orderQuery(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 退款查询
     * @throws Exception
     */
    void C() throws Exception {
        WXPay wxpay = new WXPay(new MyConfig());

        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", "2016090910595900000012");

        try {
            Map<String, String> resp = wxpay.refundQuery(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  下载对账单
     * @throws Exception
     */
    void D() throws Exception{
        WXPay wxpay = new WXPay(new MyConfig());

        Map<String, String> data = new HashMap<String, String>();
        data.put("bill_date", "20140603");
        data.put("bill_type", "ALL");
        data.put("tar_type", "GZIP");

        try {
            data = wxpay.fillRequestData(data);
            System.out.println(WXPayUtil.mapToXml(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 收到支付结果通知时，需要验证签名
     * @throws Exception
     */
    void E () throws Exception{
        String notifyData = "...."; // 支付结果通知的xml格式数据

        WXPay wxpay = new WXPay(new MyConfig());

        Map<String, String> notifyMap = WXPayUtil.xmlToMap(notifyData);  // 转换成map

        if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {
            // 签名正确
            // 进行处理。
            // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户侧订单状态从退款改成支付成功
        }
        else {
            // 签名错误，如果数据里没有sign字段，也认为是签名错误
        }
    }

    /**
     * HTTPS请求可选HMAC-SHA256算法和MD5算法签名
     * WXPay wxpay = new WXPay(config, WXPayConstants.SignType.HMACSHA256);
     */
}

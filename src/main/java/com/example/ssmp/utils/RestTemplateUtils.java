package com.example.ssmp.utils;

import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: SSMP
 * @description: http连接工具类
 * @author: kangwei
 * @create: 2022-07-13 08:53
 **/
public class RestTemplateUtils {


    public String post(String url ,Map<String,Object> requestMap){
//        RestTemplate template = new RestTemplate();
//        HttpHeaders header = new HttpHeaders();
//        header.add(HttpHeaders.ACCEPT,"application/json");
//        header.add(HttpHeaders.ACCEPT_ENCODING,"UTF-8");
//        header.add(HttpHeaders.CONTENT_TYPE,"application/json;charset=UTF-8");
//        HttpEntity<?> requestEntity = new HttpEntity<>(requestMap,header);
//        ResponseEntity<String> exchange = template.exchange(url, HttpMethod.POST, requestEntity, String.class);
//        HttpStatus statusCode = exchange.getStatusCode();
//        int value = exchange.getStatusCodeValue();
//        if (200 == value){
//           return exchange.getBody();
////        }
        return "";
    }
    public String postProxy(String url ,Map<String,Object> requestMap,String hostName,int port) throws NoSuchAlgorithmException, KeyManagementException {
//        TrustManager[] trustAllCerts =new TrustManager[] {
//
//                new X509TrustManager() {
//
//                    @Override
//
//                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//
//                        return new X509Certificate[0];
//
//                    }
//
//                    @Override
//
//                    public void checkClientTrusted(
//
//                            java.security.cert.X509Certificate[] certs, String authType) {
//
//                    }
//
//                    @Override
//
//                    public void checkServerTrusted(
//
//                            java.security.cert.X509Certificate[] certs, String authType) {
//
//                    }
//
//                }
//
//        };
//        SSLContext sslContext = SSLContext.getInstance("SSL");
//        sslContext.init(null,trustAllCerts,new SecureRandom());
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostName, port));
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        //requestFactory.set(proxy);
        RestTemplate template = new RestTemplate(requestFactory);
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.ACCEPT,"application/json");
        header.add(HttpHeaders.ACCEPT_ENCODING,"UTF-8");
        header.add(HttpHeaders.CONTENT_TYPE,"application/json;charset=UTF-8");
//        HttpEntity<?> requestEntity = new HttpEntity<>(requestMap,header);
//        ResponseEntity<String> exchange = template.exchange(url, HttpMethod.POST, requestEntity, String.class);
//        HttpStatus statusCode = exchange.getStatusCode();
//        int value = exchange.getStatusCodeValue();
//        if (200 == value){
//           return exchange.getBody();
//        }
        return "";
    }


    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {

//        new RestTemplateUtils().post("")
        requestPost();
    }

    private static void requestPost() throws NoSuchAlgorithmException, KeyManagementException {
        RestTemplateUtils utils = new RestTemplateUtils();
        String url ="https://api.weixin.qq.com/cgi-bin/message/template/send?";
        String hostName ="158.1.232.11";
        int port =8088;
//        String access_token ="58_X2ljIM7UfHfh-USGcToM5oWPHOjiKouMuk_baOKDuvEQNxiOXYCyQrtZkif4P3H_3jlVMtmmFZNQMccWeECT565CJLTPjWlg1_ygawIUxO765dgPTulStfTt_53BiOBuZa3Vk1TdSk64cHWyLCAbAIAZQO";
//        String access_token ="58_31NtutdYzjsWDyURq2IKGBamVKBhSwd7xEHq8vO5IizRQ_eXfDTyNMjT24TNM2U1iXxFfMRcFg5PtbaRCkntI2Q3YELFeq26NTFcmTL3x0xs9ffZs8pWoCJJ-";
//        String access_token ="58_31NtutdYzjsWDyURq2IKGBamVKBhSwd7xEHq8vO5IizRQ_eXfDXTyNMjT24TNM2U1iXxFfMRcFg5PtbaRCkntI2Q3YELFeq26NTFcmTL3xOXS9ffZs8pWoCJJ-pY4mIuX_X6OLaeQxlx7aKZJCHjACAUNS";
        String access_token="58_I33hxoQYIgYSrZrfbWq_J7n6WXMMHTIpABEZUbp3SEizxnKdidAsk45uFPaWOQrPU56-fS5eVTsG8d2wfBUYpMrIYbMzXVe15gUvFXP8ntNe40dwh_BRaeGfFv8gPTat8UQvM0XWYg1jnJEoBUQfAFAKDZ";
        String openId ="o3O_utwQG4p3W-8gEzd87k-qNocI";
        String templateId ="Qo1QcahQ62okY-IJ2mVxdRsBlHf0CfAN6uQDggn0QPg";
        Map mini = new HashMap();
        mini.put("appid","wx29fdffa17ddf4371");
        mini.put("pagepath","pages/login/allRecords");
        Map<String,Object> requestMap = new HashMap<>();

        requestMap.put("access_token",access_token);
        Map<String, Object> data = getData();
        requestMap.put("data",data);
        requestMap.put("access_token",access_token);
        requestMap.put("touser",openId);
        requestMap.put("template_id",templateId);
        requestMap.put("miniprogram",mini);
        String s = utils.postProxy(url+"access_token="+access_token, requestMap, hostName, port);
//        String s = utils.post(url, requestMap);
        System.out.println(s);
    }

    private static Map<String,Object> getData() {
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> first = new HashMap<>();
        Map<String,Object> keyword1 = new HashMap<>();
        Map<String,Object> keyword2 = new HashMap<>();
        Map<String,Object> remark = new HashMap<>();
        first.put("value","亲爱的小盆友，截止昨日小鑫依然没有收到您的还款，您的贷款测试，快点击最下方”南京银行鑫梦享+“进入小程序自助操作还款吧");
        keyword1.put("value","诚易贷");
        keyword2.put("value","￥0.01");
        map.put("keyword1",keyword1);
        map.put("keyword2",keyword2);
        remark.put("value","\n"+"您可可以点击此消息进入小程序-贷款还款进行自助操作还款，或于今日17:00前确保尾号xxxx的还款账号余额充足");
        map.put("value",remark);
        return map;
    }
}

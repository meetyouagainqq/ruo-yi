package com.javasm.sys.util;

import com.alibaba.fastjson.JSONObject;
import com.javasm.commons.enums.E;
import com.javasm.commons.exceptions.MvcException;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Map;

public class IpToAddressUtil {
    //使用腾讯的接口通过ip拿到城市信息
    private static final String KEY = "AUKBZ-JGZ3R-JUPWZ-W3RRH-WR5IS-CXFTO";
    public static String getCityInfo(String ip) {
        String s = null;
        try {
            s = sendGet(ip, KEY);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map map = JSONObject.parseObject(s, Map.class);
        String message = (String) map.get("message");
        if("Success".equals(message)){
            Map result = (Map) map.get("result");
            Map addressInfo = (Map) result.get("ad_info");
            String province = (String) addressInfo.get("province");
            String city = (String) addressInfo.get("city");
            String address =province + " " + city;
            return address;
        }else{
            throw new MvcException(E.LOCATION_FAILED);
        }
    }
    //根据在腾讯位置服务上申请的key进行请求操作
    public static String sendGet(String ip,String key)throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url=   "https://apis.map.qq.com/ws/location/v1/ip";
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("ip", ip));
        params.add(new BasicNameValuePair("key", key));
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        String str = EntityUtils.toString(httpEntity);// 输出请求结果
        httpResponse.close();
        return str;
    }

}


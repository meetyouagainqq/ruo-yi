package com.javasm.sys.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javasm.sys.constant.Constants;
import com.javasm.sys.entity.SysLoginLog;

import com.javasm.sys.service.SysLoginLogService;
import com.javasm.sys.util.spring.SpringUtils;
import eu.bitwalker.useragentutils.UserAgent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.io.BufferedReader;


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * * 记录用户登录信息 如:客户端 操作系统 ip地址 浏览器等
 */
@Component
public class LogMsgUtil {

    private static final Logger logger = LoggerFactory.getLogger(LogMsgUtil.class);

    public static void recordLogin(String username, String status, String message, Object... args) {
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("USER-AGENT"));
                String ipAndCityUrl = "http://pv.sohu.com/cityjson?ie=utf-8";
        String inputLine = "";
        String read = "";
        String ip = "127.0.0.1";
        String address = "内网IP";
        try {
            URL url = new URL(ipAndCityUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while ((read = in.readLine()) != null) {
                inputLine += read;
            }
            String ObjJson=inputLine.substring(inputLine.indexOf("=")+1,inputLine.length()-1);
            JSONObject jsonObj= JSON.parseObject(ObjJson);
            ip=(String) jsonObj.getString("cip");
        } catch (Exception e) {
            ip = "127.0.0.1";
        }
        String myaddress=IpToAddressUtil.getCityInfo(ip);
        StringBuilder str = new StringBuilder();
        str.append(LogUtils.getBlock(ip));
        str.append(LogUtils.getBlock(myaddress));
        str.append(LogUtils.getBlock(username));
        str.append(LogUtils.getBlock(status));
        str.append(LogUtils.getBlock(message));
        logger.info(str.toString(), args);
        String browser = userAgent.getBrowser().getName();
        String os = userAgent.getOperatingSystem().getName();
        //封装登录信息
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setLoginTime(new Date());
        sysLoginLog.setBrowser(browser);
        sysLoginLog.setIpaddr(ip);
        sysLoginLog.setOs(os);
        sysLoginLog.setLoginLocation(myaddress);
        sysLoginLog.setMsg(message);
        sysLoginLog.setUserName(username);
        //操作是否成功的状态设置
        if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)) {
            sysLoginLog.setStatus(Constants.SUCCESS);
        } else if (Constants.LOGIN_FAIL.equals(status)) {
            sysLoginLog.setStatus(Constants.FAIL);
        }
        //插入数据
        SpringUtils.getBean(SysLoginLogService.class).insertSelective(sysLoginLog);
    }
}

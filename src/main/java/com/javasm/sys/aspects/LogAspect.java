package com.javasm.sys.aspects;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javasm.sys.annotation.MyLog;
import com.javasm.sys.dao.SysOprateLogMapper;
import com.javasm.sys.entity.SysOprateLog;
import com.javasm.sys.entity.User;
import com.javasm.sys.entity.ruoyi.SysDepart;
import com.javasm.sys.enums.DepartEnum;
import com.javasm.sys.enums.OperatorStatus;
import com.javasm.sys.service.ruoyi.SysDepartService;
import com.javasm.sys.util.DepartException;
import com.javasm.sys.util.IpToAddressUtil;
import com.javasm.sys.util.ServletUtils;
import com.javasm.sys.util.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;


/**
 * * 操作行为日志记录
 */
@Component
@Aspect
public class LogAspect {
    @Autowired
    private SysOprateLogMapper sysOprateLogMapper;
    @Autowired
    private SysDepartService departService;
    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.javasm.sys.annotation.MyLog)")
    public void actionLogPointCut() {

    }

    /**
     * * 请求处理完执行
     */
    @AfterReturning(pointcut = "actionLogPointCut()", returning = "returnResult")
    public void doAfterReturning(JoinPoint joinPoint, Object returnResult) {
        handleLog(joinPoint, null, returnResult);
    }

    @AfterThrowing(pointcut = "actionLogPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e, null);
    }

    public void handleLog(JoinPoint joinPoint, Exception e, Object returnResult) {
        //获取自定义注解
        MyLog log = getAnnotationLog(joinPoint);
        if (log == null) {
            return;
        }
        HttpServletRequest request = ServletUtils.getRequest();
        HttpSession session = request.getSession(true);
        User user=(User) session.getAttribute("login_user");
        logger.info("获取的用户为:" + user);
        SysOprateLog sysOprateLog = new SysOprateLog();
        //由于success在枚举的第一个位置，故ordinal()的值为0
        sysOprateLog.setStatus(OperatorStatus.SUCCESS.ordinal());
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
            String ObjJson = inputLine.substring(inputLine.indexOf("=") + 1, inputLine.length() - 1);
            JSONObject jsonObj = JSON.parseObject(ObjJson);
            ip = jsonObj.getString("cip");
        } catch (Exception e1) {
            ip = "127.0.0.1";
        }
        String myaddress = IpToAddressUtil.getCityInfo(ip);
        sysOprateLog.setOperTime(new Date());
        sysOprateLog.setOperIp(ip);
        sysOprateLog.setOperLocation(myaddress);
        Integer departId= user.getDepartId();
        if (!StrUtil.isEmpty(departId+"")){
            String departIdStr = Integer.toString(departId);
            SysDepart sysDepart = departService.selectByPrimaryKey(departIdStr);
            sysOprateLog.setDeptName(sysDepart.getDepartName());
        }else {
            throw new DepartException(DepartEnum.NO_DEPART);
        }
        // 将相应的结果放入操作表中
        sysOprateLog.setJsonResult(JSON.toJSONString(returnResult));
        sysOprateLog.setOperUrl(ServletUtils.getRequest().getRequestURI());
        if (user != null) {
            sysOprateLog.setOperName(user.getUserName());
        }
        //操作失败 出现异常
        if (e != null) {
            sysOprateLog.setStatus(OperatorStatus.FAILED.ordinal());
            sysOprateLog.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
        }
        String className = joinPoint.getTarget().getClass().getName();
        String method = joinPoint.getSignature().getName();
        sysOprateLog.setMethod(className + "." + method + "()");
        sysOprateLog.setRequestMethod(ServletUtils.getRequest().getMethod());
        //获取对注解中的方法的描述信息
        getControllerAndArgs(joinPoint, log, sysOprateLog);

    }

    private void getControllerAndArgs(JoinPoint joinPoint, MyLog log, SysOprateLog sysOprateLog) {
        sysOprateLog.setBusinessType(log.operationAction().ordinal());
        sysOprateLog.setTitle(log.title());
        sysOprateLog.setOperatorType(log.operatorType().ordinal());
        if (log.isSaveRequestParam()) {
            //获取请求参数并插入数据库
            saveParamAndInsert(joinPoint, sysOprateLog);
        }

    }

    private void saveParamAndInsert(JoinPoint joinPoint, SysOprateLog sysOprateLog) {
        sysOprateLog.setOperParam(Arrays.toString(joinPoint.getArgs()));
        sysOprateLogMapper.insertSelective(sysOprateLog);
    }


    private MyLog getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        //获取请求的方法
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(MyLog.class);
        }
        return null;
    }
}

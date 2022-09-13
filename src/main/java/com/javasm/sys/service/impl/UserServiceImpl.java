package com.javasm.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.javasm.sys.config.RedisConfig;
import com.javasm.sys.constant.UserKey;
import com.javasm.sys.dao.UserDao;
import com.javasm.sys.entity.SysDepart;
import com.javasm.sys.entity.User;
import com.javasm.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: WangZhuang
 * @ClassName: UserServiceIm
 * @Description:
 * @Date: 2022/9/10 11:15
 * Version: 0.1
 * Since: JDK11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    private RedisConfig redisConfig;

    @Override
    public User getUserByAccount(User user) {
        String loginUser = redisConfig.getByKey(UserKey.LOGIN_KEY + user.getUserAccount());
        if (!StrUtil.isEmpty(loginUser)) {
            return JSON.parseObject(loginUser, User.class);
        }
        User userByAccount = userDao.getUserByAccount(user);
        if (userByAccount != null) {
            redisConfig.setex(UserKey.LOGIN_KEY+user.getUserAccount(),JSON.toJSONString(userByAccount),1, TimeUnit.HOURS);
        }else {
            redisConfig.setex(UserKey.LOGIN_KEY+user.getUserAccount(),UserKey.NOT_EXIST_USER,30,TimeUnit.SECONDS);
        }
        return userByAccount;
    }

    @Override
    public List<SysDepart> buildDeptTree() {

        //查询所有部门信息
        List<SysDepart> allDept = userDao.getAllDept();
        return buildDeptByPid(allDept, "-1");
    }

    //    按条件查询用户数据
    @Override
    public List<User> getUsers(User user) {
        List<User> users = userDao.getUsers(user);
        return users;
    }

    //根据pid构建tree树
    private List<SysDepart> buildDeptByPid(List<SysDepart> allDept, String pid) {
        List<SysDepart> r = new ArrayList<>();
        for (SysDepart dept : allDept) {
            if (pid.equals(dept.getPid())) {
                String id = dept.getDepartId();
                List<SysDepart> childs = buildDeptByPid(allDept, id);
                if (childs != null && childs.size() > 0) {
                    dept.setDepartList(childs);
                }
                r.add(dept);
            }
        }
        return r;
    }
}

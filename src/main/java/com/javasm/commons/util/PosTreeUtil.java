package com.javasm.commons.util;

import com.javasm.sys.entity.SysPos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author:Dai
 * @className:TreeUtil
 * @description:  岗位管理
 * @date:2022/9/12 22:34
 * @version: 1.0
 * @since: jdk11
 */
public class PosTreeUtil {
    public  static List<SysPos> buildTree(Collection<SysPos> list,Integer pid){
        List<SysPos> r=new ArrayList<>();
        for(SysPos sysPos:list){
            if(pid.equals(sysPos.getPid())){
                Integer id = sysPos.getPid();
                List<SysPos> childs=buildTree(list,id);
                if(childs!=null&&childs.size()>0){
                    sysPos.setChilds(childs);
                }
                r.add(sysPos);//岗位管理树形数据
            }
        }
        return r;
    }
}

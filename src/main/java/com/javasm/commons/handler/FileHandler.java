package com.javasm.commons.handler;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.CrmProperties;
import com.javasm.commons.enums.E;
import com.javasm.commons.exceptions.MvcException;
import com.javasm.commons.util.CurrentLogin;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileHandler implements InitializingBean {
    private String root;

    @Override
    public void afterPropertiesSet() throws Exception {
        root = CrmProperties.getRoot();
    }

    @PostMapping("upload")
    public AxiosResult doUploadFile(MultipartFile myfile) throws IOException {
        byte[] bytes = myfile.getBytes();//文件内容字节数组,小文件使用这个
//        InputStream inputStream = myfile.getInputStream();//文件内容数据流,大文件
        long size = myfile.getSize();//文件大小
        String originalFilename = myfile.getOriginalFilename();//文件名
        originalFilename = new String(originalFilename.getBytes(),"UTF-8");

        String dir= DateUtil.format(new Date(),"yyyyMMdd");

        File f= new File(root,dir);
        if(!f.exists())f.mkdirs();
        String path = dir+"/"+originalFilename;
        OutputStream out = new FileOutputStream(root+"/"+path);
        FileCopyUtils.copy(bytes,out);

        Map<String,Object> map = new HashMap<>();
        map.put("uploadUser", CurrentLogin.getLoginUserName());
        map.put("fileSize",size);
        map.put("uploadTime",System.currentTimeMillis()+"");
        map.put("realName",originalFilename);
        map.put("path",path);
        return AxiosResult.suc(map);
    }

    @GetMapping("show")
    public ResponseEntity showFile(String path) throws FileNotFoundException {

        File f= new File(root,path);
        if(!f.exists()) throw new MvcException(E.NOT_EXISTS);

        byte[] bytes = IoUtil.readBytes(new FileInputStream(f), true);
        return ResponseEntity.ok(bytes);
    }

    @GetMapping("download")
    public ResponseEntity download(String path,String realName) throws Exception {

        File f = new File(root,path);
        if(!f.exists()) throw new MvcException(E.NOT_EXISTS);

        byte[] bytes = IoUtil.readBytes(new FileInputStream(f), true);
        if(!StringUtils.hasLength(realName))realName=f.getName();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename="+ URLEncoder.encode(realName,"UTF-8"));
        return new ResponseEntity(bytes,headers, HttpStatus.OK);
    }


}

package com.javasm.sys.util;

import com.javasm.sys.constant.JwtConstant;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private JwtUtil() {
    }

    public static String createToken(String uid, String secretKey, Integer expireTime) {
        Date startTime = new Date();
        Date expireEndTime = new Date(startTime.getTime() + expireTime * 60 * 1000);
        Map<String, String> map = new HashMap<>();
        map.put("uid", uid);
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));

        String jws = Jwts.builder()
                .setClaims(map)//设置body签名信息:自定义签名Map
                .setIssuedAt(startTime)//设置body签名信息:标准签名setIssuedAt|setExpiration
                .setExpiration(expireEndTime)
                .signWith(key) //指定密钥
                .compact();
        return jws;
    }
    public static String parseToken(String token,String secretKey){
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        try{
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return jws.getBody().get("uid",String.class);
        }catch(SignatureException e){
            return JwtConstant.SIGNATURE_EXCEPTION;
        }catch(ExpiredJwtException e){
            //过期
            return JwtConstant.SIGNATURE_EXPIRED;
        }catch (Exception e){
            return null;
        }
    }
}

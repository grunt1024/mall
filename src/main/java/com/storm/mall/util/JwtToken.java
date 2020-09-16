package com.storm.mall.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Bean;

import java.security.AlgorithmConstraints;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : ZhangHua
 * @date : 2020/9/2 16:30
 * @description:
 * @version: V1.0.0
 */
public class JwtToken {

    public static String generateToken(Map<String,Object> claims){
        String token =   Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(new Date(System.currentTimeMillis() + 1000))
                    .signWith(SignatureAlgorithm.HS512,"ksfsafasfsadfsadsafsadey")
                    .compact();
        return token;
    }


    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("name","tom");
        map.put("age",20);


        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf(generateToken(map) + "\n");
        }
    }


}

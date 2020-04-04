package com.hrp.test;

import io.jsonwebtoken.*;
import org.junit.Test;

/**
 * @author hrp
 * 2020/3/21 15:52
 */
public class JWTTest {

    @Test
    public void test01(){
        String token = Jwts.builder()
                .claim("id","1")
                .claim("name", "阿部多瑞")
                .signWith(SignatureAlgorithm.HS256,"HRP".getBytes())
                .compact();
        System.out.println(token);


    }

    @Test
    public void test02(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEiLCJuYW1lIjoi6Zi_6YOo5aSa55GeIn0.FxG_XFCYMCJXVzTHwrTkLTNELjCJGB06_AzPT9cTmPY";
        Claims body = Jwts.parser().setSigningKey("HRP".getBytes()).parseClaimsJws(token).getBody();
        System.out.println(body.get("name"));
    }


}

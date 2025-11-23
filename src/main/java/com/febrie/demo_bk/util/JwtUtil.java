package com.febrie.demo_bk.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * JWT生成和解析
 */

public class JwtUtil {
    /**
     * 私钥 / 生成签名的时候使用的秘钥secret，一般可以从本地配置文件中读取，切记这个秘钥不能外露，只在服务端使用，在任何场景都不应该流露出去。
     * 一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
     * 应该大于等于 256位(长度32及以上的字符串)，并且是随机的字符串
     */
    private static final String SECRET_KEY = "zWpbuTUAmSvNusUJMVt6Wsbra2SRse6m";
    //密钥实例
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    //加密算法
    private static final SecureDigestAlgorithm<SecretKey,SecretKey> ALGORITHM = Jwts.SIG.HS256;

    //生成JWT
    public static String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(KEY,ALGORITHM)
                .compact();
    }

    /**
     * 解析token
     * @param token token
     * @return Jws<Claims>
     */
    public static Jws<Claims> parseToken(String token){
        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token);
    }

    //获取Payload
    public static Claims parsePayload(String token){
        return parseToken(token).getPayload();
    }

    //获取用户信息
    public  static String getUsernameFromToken(String token){
        return parsePayload(token).getSubject();
    }

    //判断token是否过期
    public static boolean isTokenExpired(String token) {
        return parsePayload(token).getExpiration().before(new Date());//比较过期时间
    }

}

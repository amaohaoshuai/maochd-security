package com.maochd.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类
 *
 * @author maochd
 */
public class JwtUtils {
    /**
     * token 过期时间, 单位: 秒. 这个值表示 30 天
     */
    private static final long TOKEN_EXPIRED_TIME = 30L * 24L * 60L * 60L * 1000L;

    public static final String jwtId = "tokenId";

    /**
     * jwt 加密解密密钥(可自行填写)
     */
    private static final String JWT_SECRET = "test";

    private static Key jwtKey;

    static {
        jwtKey = generateKey();
    }

    /**
     * 创建JWT
     *
     * @param claims
     * @param time
     * @return
     */
    public static String createJwt(Map<String, Object> claims, Long time) {
        Date now = new Date(System.currentTimeMillis());
        // 生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        // 下面就是在为payload添加各种标准声明和私有声明了
        // 这里其实就是new一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                // 设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setId(jwtId)
                // iat: jwt的签发时间
                .setIssuedAt(now)
                // 设置签名使用的签名算法和签名使用的秘钥
                .signWith(SignatureAlgorithm.HS512, jwtKey);
        if (time >= 0) {
            long expMillis = nowMillis + time;
            Date exp = new Date(expMillis);
            // 设置过期时间
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 验证jwt
     *
     * @param token
     * @return
     */
    public static Claims verifyJwt(String token) {
        Claims claims;
        try {
            //得到DefaultJwtParser
            claims = Jwts.parser().setSigningKey(jwtKey).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;

    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    private static Key generateKey() {
        String key = JWT_SECRET;
        Key signingKey = new SecretKeySpec(key.getBytes(), SignatureAlgorithm.HS512.getJcaName());
        return signingKey;
    }

    /**
     * 根据userId和openid生成token
     *
     * @param openId
     * @param userId
     * @return
     */
    public static String generateToken(String openId, String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("openId", openId);
        map.put("sub", openId);
        return createJwt(map, TOKEN_EXPIRED_TIME);
    }

    /**
     * 解析token
     *
     * @param token
     * @param salt
     * @return
     */
    public static String parseToken(String token, String salt) {
        String subject = null;
        Claims claims = verifyJwt(token);
        if (claims != null) {
            subject = claims.getSubject();
        }
        return subject;
    }

    /**
     * TODO
     * 后期可做成注册功能
     * 测试方法，用于生成用户密码存放到数据库，不然security密码对比会出错，保证加密方式相同
     *
     * @param args
     */
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode("wanghao");
        System.out.println(encodePassword);
    }
}

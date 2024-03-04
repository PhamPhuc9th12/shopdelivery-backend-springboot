package com.project.backendshopdelivery.token;

import com.project.backendshopdelivery.model.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
public class TokenHelper {
    private static final String SECRET_KEY = "keyskeyskeyskeyskeyskeyskeyskeyskeyskeyskeyskleykeyskehsahfsaduadhusadhasudhasduahdaudssda";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static String generateToken(UserEntity userEntity){
        Date now = new Date();
        Date experationdate = new Date(now.getTime()+EXPIRATION_TIME);
        return Jwts.builder()
                .claim("user_id",userEntity.getId())
                .claim("user_name",userEntity.getUserName())
                .setIssuedAt(now)
                .setExpiration(experationdate)
                .setSubject(userEntity.getUserName())
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .compact();
    }

    public static Long getUserIdFromToken(String token){
        token = token.substring(7); // Bearer.length = 7
        Claims claims = Jwts.parser()// tạo doi tuong parser de phan tich chuoi jwt
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.get("user_id", Long.class);
    }
}

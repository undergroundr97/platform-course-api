package com.courses.ocourses.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
//import java.sql.Date;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;


    private SecretKey getSigningKey(){
        byte[] keyInBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyInBytes);
    }

    public String generateToken(UserDetails userDetails){
        return  Jwts.builder()
                .header().and()
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusMillis(expiration)))
                .signWith(getSigningKey())
                .compact();

    }



}

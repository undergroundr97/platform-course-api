package com.courses.ocourses.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
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

    public String extractUsername(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

        //verifyWith > verifica a chave hash256 de secret
        //build -> build
        // passe o token recebido na web -> parseSignedClaim(token)
        //getPayload  - getSubject (retorna o sub, nesse caso user.email
    }

    public Date extractExpirationDate(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
    }

    private boolean isTokenExpired(String token){
        Instant datenow = Instant.now();
        if(datenow.isAfter(extractExpirationDate(token).toInstant())){
            return true;
        } else {
            return false;
        }
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        if(extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token)){
            return true;
        } else {
            return false;
        }
    }

}

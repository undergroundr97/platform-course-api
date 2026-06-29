package com.courses.ocourses.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;

import javax.crypto.SecretKey;

public class GenerateSecret {

    static void main(){
        SecretKey key = Jwts.SIG.HS256.key().build();

        System.out.println(Encoders.BASE64.encode(key.getEncoded()));
    }

}

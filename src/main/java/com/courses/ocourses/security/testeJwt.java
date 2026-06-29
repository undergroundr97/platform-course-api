package com.courses.ocourses.security;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class testeJwt {

    static  void main(){


        JwtService jwtService = new JwtService();
//        jwtService.secret = "PHJxdMqosDODXlPXcCM8hlsSG4xLx2W5SLpmOoIo/ww=";
//        jwtService.expiration = 3600000;

        UserTest user1 = new UserTest("vitor@gmail.com", "123456789");

        System.out.println(jwtService.generateToken(user1));
    }
}

class UserTest implements UserDetails {

    String email;
    String password;


    public UserTest(String nome, String password){
        this.email = nome;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}

package com.courses.ocourses.aaconfigteste;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
public class testeController {

    @GetMapping
    public ResponseEntity<String> me (Authentication authentication){
        return ResponseEntity.ok(authentication.getName());
    }
}

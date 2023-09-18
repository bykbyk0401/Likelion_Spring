package com.likelion.springstudy.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")//tomcat이 url mapping, endpoint 지정
public class HealthCheckController {

    @GetMapping(value = "/health", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> healthCheck() { //접근제어자 -> 제어자 순서로 , return type, 메소드 이름(파라미터), map은 dict와 유사
        Map<String, String> map = new HashMap<>();
        map.put("status", "OK");
        map.put("message", "Health Check is OK");
        return ResponseEntity.ok(map); //response entity 활용하자
    }
}

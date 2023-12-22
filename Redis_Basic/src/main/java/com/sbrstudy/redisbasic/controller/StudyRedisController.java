package com.sbrstudy.redisbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudyRedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    // /setFruit?name=궁금하면500원
    @GetMapping("/setFruit")
    public String setFruit(@RequestParam String name){
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        ops.set("fruit",name);
        return "save!!!";
    }

    // /getFruit
    @GetMapping("/getFruit")
    public String getFruit(){
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        String fruitName = ops.get("fruit");
        return fruitName;
    }

}

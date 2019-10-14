package com.mmh.tddtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class TddtestApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(TddtestApplication.class, args);
    }


}

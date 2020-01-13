package org.bigdatahealth.controller;

import org.bigdatahealth.domain.User;
import org.bigdatahealth.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public List<User> hello(){
        return helloService.getUserList();
    }

}

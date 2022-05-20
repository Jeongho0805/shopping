package com.jeongho.shopping.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class MyTestService {

    public void doSomething(){
        System.out.println("Service do Something");
    }
}

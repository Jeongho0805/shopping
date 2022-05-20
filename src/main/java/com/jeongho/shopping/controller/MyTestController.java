package com.jeongho.shopping.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jeongho.shopping.service.MyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test/")
public class MyTestController {

    @Autowired
    private MyTestService myTestService;

    @GetMapping("")
    public String showPage(){
        System.out.println("hello");
        return "/test/test";
    }

    @PostMapping("/btn2")
    @ResponseBody
    public String myPostTest(@RequestBody String objData){
        System.out.println("myPostTest");
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(objData);

        String data = element.getAsJsonObject().get("data").getAsString();
        System.out.println(data);

        myTestService.doSomething();

        return "true";
    }
}

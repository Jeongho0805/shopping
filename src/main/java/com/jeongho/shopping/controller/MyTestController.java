package com.jeongho.shopping.controller;

import com.google.gson.*;
import com.jeongho.shopping.entity.TestData;
import com.jeongho.shopping.service.MyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/test")
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

        // 받은 데이터
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(objData);
        // 받은 데이터 내용
//        data: {
//            input: g_input.value, // 임의로 입력한 내용
//            innerData: 'some Data',
//            innerData2: {
//                strData: 'some Data',
//                numData: 123,
//                boolData: true,
//                nullData: null,
//                arrData: [1,2,3],
//            }
//        }
        JsonObject data = element.getAsJsonObject().get("data").getAsJsonObject();
        System.out.println(data);

        System.out.println(data.get("innerData") + "\n"); // "some Data"

        JsonObject innerData2 = data.getAsJsonObject("innerData2");
        System.out.println(innerData2); // {strData: "some Data", numData: 123, ... }
        System.out.println(innerData2.getClass().getName() + "\n"); // com.google.gson.JsonObject

        System.out.println(innerData2.get("strData")); // "some Data"
        System.out.println(innerData2.get("strData").getClass().getName()); // com.google.gson.JsonPrimitive

        String strData = innerData2.get("strData").getAsString();
        System.out.println(strData); // some Data
        System.out.println(strData.getClass().getName() + "\n"); // java.lang.String


        // 배열
        System.out.println(innerData2.get("arrData")); // [1,2,3]
        System.out.println(innerData2.get("arrData").getClass().getName()); // com.google.gson.JsonArray
        JsonArray jsonArr = innerData2.get("arrData").getAsJsonArray();
        for(Object item: jsonArr){
            System.out.print(item + " "); // 1  2  3
        }
        System.out.print("\n" + jsonArr.get(0).getClass().getName()); // com.google.gson.JsonPrimitive
        System.out.println("\n");

        Gson gson = new Gson();
        ArrayList arrList = gson.fromJson(jsonArr, ArrayList.class);
        // <Integer>로 받으려고 하면 에러
        System.out.println(arrList); // [1.0, 2.0, 3.0]
        System.out.println(arrList.size()); // 3
        for(Object item: arrList){
            System.out.print(item + " "); // 1.0  2.0  3.0
        }
        System.out.println("\n" + arrList.get(0).getClass().getName()); // java.lang.Double
        System.out.println("\n");


        // null
        System.out.println(innerData2.get("nullData")); // null

        TestData retData = myTestService.doSomething();

//        Gson gson = new Gson(); // null인 값은 생략하고 생성
        gson = new GsonBuilder().serializeNulls().create(); // null인 값도 입력
        String jsonData = gson.toJson(retData);

        return jsonData;
    }
}

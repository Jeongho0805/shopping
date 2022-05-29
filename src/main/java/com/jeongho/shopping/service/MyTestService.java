package com.jeongho.shopping.service;

import com.jeongho.shopping.entity.TestData;
import com.jeongho.shopping.entity.TestInnerData;
import org.springframework.stereotype.Service;

@Service
public class MyTestService {

    public TestData doSomething() {
        // return some data;

        TestInnerData testInnerData = new TestInnerData();
        testInnerData.setBoolData(false);
        testInnerData.setIntData(123);
        testInnerData.setStrData("innerStrData");
        testInnerData.setArrIntData(null);

        TestData testData = new TestData();
        testData.setStrData("outerStrData");
        testData.setArrIntData(new int[]{1,2,3,4,5});
        testData.setObjData1(testInnerData);
        testData.setObjData2(null);

        System.out.println("Service do Something");
        return testData;
    }
}

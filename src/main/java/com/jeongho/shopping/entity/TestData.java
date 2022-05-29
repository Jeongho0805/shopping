package com.jeongho.shopping.entity;


//@Data // => 클래스에 set/get 선언 안해도 해당 동작 수행할 수 있게 해줌
        // ex) TestInnerData
public class TestData{
    private String strData;
    private int[] arrIntData;
    private TestInnerData objData1;
    private TestInnerData objData2;

    public void setStrData(String strData) {
        this.strData = strData;
    }
    public String getStrData(){
        return strData;
    }

    public void setArrIntData(int[] arrIntData) {
        this.arrIntData = arrIntData;
    }

    public int[] getArrIntData() {
        return arrIntData;
    }

    public void setObjData1(TestInnerData objData) {
        this.objData1 = objData;
    }

    public TestInnerData getObjData1() {
        return objData1;
    }

    public void setObjData2(TestInnerData objData2) {
        this.objData2 = objData2;
    }

    public TestInnerData getObjData2() {
        return objData2;
    }
}


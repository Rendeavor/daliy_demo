package com.jl.springbootdemo1.pojo;

public class DemoClass {

    private Integer num1;
    private Integer num2;

    public DemoClass() {
    }

    public DemoClass(Integer num1, Integer num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer add(){
        return num1 + num2;
    }

    public Integer minus(){
        return num1 - num2;
    }

    public Integer multi(){
        return num1 * num2;
    }

    public Integer div(){
        return num1 / num2;
    }
}

package com.jl.springbootdemo1.controller;

import com.jl.springbootdemo1.pojo.LogRecordType;
import com.jl.springbootdemo1.pojo.Order;
import com.mzt.logapi.context.LogRecordContext;
import com.mzt.logapi.starter.annotation.LogRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class DemoController {


    @LogRecord(
            success = "{{#map['orderNo'])}}下了一个订单,购买商品「{{#order.productName}}」,测试变量「{{#innerOrder.productName}}」,下单结果:{{#_ret}}",
            type = "1", bizNo = "{{#order.orderNo}}")
    @PostMapping("/demo1")
    public String demo1(@RequestBody Map<String,Object> map){

        System.out.println(map);

        return "success";
    }


    @PostMapping("/demo2")
    @LogRecord(
            success = "{{#order.purchaseName}}下了一个订单,购买商品「{{#order.productName}}」,测试变量「{{#innerOrder.productName}}」,下单结果:{{#_ret}}",
            type = LogRecordType.ORDER, bizNo = "{{#order.orderNo}}")
    public boolean createOrder(@RequestBody Order order) {
        log.info("【创建订单】orderNo={}", order.getOrderNo());
        // db insert order
        Order order1 = new Order();
        order1.setProductName("内部变量测试");
        LogRecordContext.putVariable("innerOrder", order1);
        return true;
    }


    @PostMapping("/demo3")
    @LogRecord(
            extra = "{{#order.toString()}}",
            success = "{{#order.purchaseName}}下了一个订单,购买商品「{{#order.productName}}」,测试变量「{{#innerOrder.productName}}」,下单结果:{{#_ret}}",
            type = LogRecordType.ORDER, bizNo = "{{#order.orderNo}}")
    public boolean createOrder3(@RequestBody Order order) {
        log.info("【创建订单】orderNo={}", order.getOrderNo());
        // db insert order
        Order order1 = new Order();
        order1.setProductName("内部变量测试");
        LogRecordContext.putVariable("innerOrder", order1);
        return true;
    }


    @PostMapping("/demo4")
    //使用了自定义函数，主要是在 {{#order.orderNo}} 的大括号中间加了 functionName
    @LogRecord(success = "更新了订单{ORDER{#order}},更新内容为...",
            type = LogRecordType.ORDER, bizNo = "{{#order.orderNo}}",
            extra = "{{#order.toString()}}")
    public boolean update(Long orderId,@RequestBody Order order) {
        return false;
    }





}

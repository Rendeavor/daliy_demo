package com.jl.springbootdemo1.controller;

import com.jl.springbootdemo1.pojo.Order;
import com.mzt.logapi.service.IParseFunction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
public class OrderParseFunction implements IParseFunction {

    @Override
    public boolean executeBefore() {
        return true;
    }

    @Override
    public String functionName() {
        return "ORDER";
    }

    @Override
    public String apply(Object value) {
        log.info("@@@@@@@@");
        if (StringUtils.isEmpty(value)) {
            return "";
        }
        log.info("###########,{}", value);
        Order order = new Order();
        order.setProductName("xxxx");
        return order.getProductName().concat("(").concat(value.toString()).concat(")");
    }
}

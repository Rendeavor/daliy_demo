package com.jl.springbootdemo1;

import com.jl.springbootdemo1.pojo.Order;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@SpringBootTest
class SpringbootDemo1ApplicationTests {

    @Test
    void contextLoads() {

        SpelExpressionParser parser = new SpelExpressionParser();

        String express = "#user.id";
        Expression expression = parser.parseExpression(express);

//        LogRecordCon


    }





}

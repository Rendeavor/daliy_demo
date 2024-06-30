package com.jl.springbootdemo1.aspect;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;

public class LogRecordOperationSource extends AbstractBeanFactoryPointcutAdvisor {


    @Override
    public Pointcut getPointcut() {
        return null;
    }
}

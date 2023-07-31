package com.cyl.learn.aspect;

import com.cyl.learn.utils.BeanUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Aspect
public class SetValueForFieldAspect {

    @Autowired
    BeanUtil beanUtil;

    @Around("@annotation(com.cyl.learn.annotation.SetNeedMethod)")
    public Object doSetValue(ProceedingJoinPoint pjp) throws Throwable {
        Object result = pjp.proceed();

        beanUtil.setValueForField((Collection)result);

        return result;
    }
}

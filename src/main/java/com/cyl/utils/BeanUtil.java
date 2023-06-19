package com.cyl.utils;

import com.cyl.annotation.SetNeedValue;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Objects;

@Component
public class BeanUtil implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void setValueForField(Collection col) throws Throwable {

        //获取入参的bean
        Class<?> clazz = col.iterator().next().getClass();

        //获取bean的所有字段
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            //获取字段的SetNeedValue注解
            SetNeedValue snv = field.getAnnotation(SetNeedValue.class);
            if (Objects.isNull(snv)) {
                continue;
            }
            //将含有字段的SetNeedValue注解设置为可见
            field.setAccessible(true);

            //获取SetNeedValue的bean
            Object bean = this.applicationContext.getBean(snv.beanClass());

            //通过方法名和入参类型获取方法
            Method method = snv.beanClass().getMethod(snv.method(), clazz.getDeclaredField(snv.param()).getType());

            //获取入参字段
            Field paramField = clazz.getDeclaredField(snv.param());

            //设置为可见
            paramField.setAccessible(true);

            for (Object o : col) {
                //获取入参字段的值
                Object paramValue = paramField.get(o);
                if (Objects.isNull(paramValue)) {
                    continue;
                }
                //调用方法获取对象
                Object value = method.invoke(bean, paramValue);
                //获取目标字段
                Field targetField = value.getClass().getDeclaredField(snv.targetField());
                //设置为可见
                targetField.setAccessible(true);
                //获取值
                value = targetField.get(value);
                //设置值
                field.set(o, value);
            }
        }
    }
}

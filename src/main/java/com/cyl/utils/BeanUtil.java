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
        Class<?> clazz = col.iterator().next().getClass();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            SetNeedValue snv = field.getAnnotation(SetNeedValue.class);
            if (Objects.isNull(snv)) {
                continue;
            }
            field.setAccessible(true);

            Object bean = this.applicationContext.getBean(snv.beanClass());

            Method method = snv.beanClass().getMethod(snv.method(), clazz.getDeclaredField(snv.param()).getType());

            Field paramField = clazz.getDeclaredField(snv.param());

            paramField.setAccessible(true);

            for (Object o : col) {
                Object paramValue = paramField.get(o);
                if (Objects.isNull(paramValue)) {
                    continue;
                }
                Object value = method.invoke(bean, paramValue);
                Field targetFieldOne = value.getClass().getDeclaredField(snv.targetField());
                targetFieldOne.setAccessible(true);
                value = targetFieldOne.get(value);
                field.set(o, value);
            }
        }
    }
}

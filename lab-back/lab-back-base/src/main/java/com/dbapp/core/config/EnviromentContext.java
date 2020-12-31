package com.dbapp.core.config;

import com.dbapp.core.exception.LabException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author dobb
 */
@Component
public class EnviromentContext implements EnvironmentAware, ApplicationContextAware, InitializingBean {

    private static Environment environment;

    private static ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(environment,"Spring环境注入失败");
    }

    @Override
    public void setEnvironment(Environment environment) {
        EnviromentContext.environment = environment;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        EnviromentContext.applicationContext = applicationContext;
    }

    public static <T> T getBean(String name){
        Object t = applicationContext.getBean(name);
        LabException.trueThrow(t == null, "不能获取{}的bean",name);
        return (T)t;
    }

    public static <T> T getBean(Class<T> clazzType){
        T t = applicationContext.getBean(clazzType);
        LabException.trueThrow(t == null, "不能获取{}的bean", clazzType.getSimpleName());
        return t;
    }
}

package com.github.carloscontrerasruiz.user_starter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextException;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class VerifyProperties implements BeanFactoryPostProcessor, PriorityOrdered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //Otro metodo de validacion de propiedades
        Environment environment = configurableListableBeanFactory.getBean(Environment.class);
        if(environment.getProperty("custom.user.info.spaceName") == null){
            throw new ApplicationContextException("Property spaceName cannot be null (BeanFactoryPostProcessor)");
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}

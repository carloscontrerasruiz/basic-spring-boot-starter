package com.github.carloscontrerasruiz.user_starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(UserInfo.class)
@EnableConfigurationProperties(UserInfoProperties.class)
public class UserInfoAutoConfiguration {

    @Autowired
    private UserInfoProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public UserInfoConfig userInfoConfig() {

        if (properties.getEnv() == null){
            //Usando este metodo la aplicacion no inicia pero el error se ve como una
            //simple exepcion el mensaje aparece
            throw new ApplicationContextException("Property env cannot be null");
        }

        UserInfoConfig config = new UserInfoConfig();

        config.setUserInfoProperties(properties);
        config.setSpaceUrl("the url");

        return config;
    }

    @Bean
    @ConditionalOnMissingBean
    public UserInfo userInfo(UserInfoConfig userInfoConfig) {
        return new UserInfo(userInfoConfig);
    }
}

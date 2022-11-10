package com.github.carloscontrerasruiz.user_starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "custom.user.info")
@Data
public class UserInfoProperties {
    private String env;
    private String spaceName;
}

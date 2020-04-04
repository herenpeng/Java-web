package com.hrp.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hrp
 * 2020/3/22 8:10
 */
@Data
@Component
@ConfigurationProperties(prefix = "my.properties")
public class Userproperties {
    private String name;
    private Integer age;
    private Set<String> hobby;
    private Map<String,String> family;
}

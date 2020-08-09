package com.hrp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 图片上传的Java配置类
 * @author hrp
 * 2020/2/23 17:35
 */
@Data
@Component
@ConfigurationProperties(prefix = "file.upload")
public class UploadProperties {

    private String path;
    private List<String> allowTypes;
}

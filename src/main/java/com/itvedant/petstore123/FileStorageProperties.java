package com.itvedant.petstore123;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix ="file")
public class FileStorageProperties {
    
    private String uploadDir;
}

package com.giftOrchids.giftOrchids.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@Getter
@Setter
public class VaultConfig {
    @Value("${AWS_ACCESS_KEY}")
    private String s3AccessKey;
    @Value("${AWS_SECRET_KEY}")
    private String s3SecretKey;
    @Value("${region}")
    private String region;
}

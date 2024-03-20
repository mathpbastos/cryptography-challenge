package com.practicing.cryptographychallenge.config;

import org.jasypt.util.text.AES256TextEncryptor;
import org.jasypt.util.text.TextEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"com.practicing.cryptographychallenge.models.payment"})
public class ProjectConfig {

    @Bean
    public AES256TextEncryptor aes256TextEncryptor() {
        AES256TextEncryptor encryptor = new AES256TextEncryptor();
        encryptor.setPassword("1U2d3T4q5C");

        return encryptor;
    }

}

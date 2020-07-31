package com.versusmind.demo.infrastructure.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Configuration
@ConfigurationProperties(prefix = "mail")
@PropertySource("classpath:mail.properties")
@Getter
@Setter
@Validated
public class MailConfiguration {
    @NotBlank
    private String hostname;
    @Min(400)
    @Max(800)
    private int port;
    @NotBlank
    private String from;
}

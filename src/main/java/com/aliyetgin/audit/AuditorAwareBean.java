package com.aliyetgin.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

//AuditorAware: The user who uses the system will log something
@Configuration
public class AuditorAwareBean {

    @Bean
    public AuditorAware<String> auditorAwareMethod(){
        return new AuditorAwareImpl();
    }
}
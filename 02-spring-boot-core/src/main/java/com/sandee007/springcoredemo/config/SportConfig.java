package com.sandee007.springcoredemo.config;

import com.sandee007.springcoredemo.common.Coach;
import com.sandee007.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    //    @Bean // used when using third-party services - eg: S3
    @Bean("aquatic") // set a custom bean id
    public Coach swimCoach() {
        return new SwimCoach();
    }
}

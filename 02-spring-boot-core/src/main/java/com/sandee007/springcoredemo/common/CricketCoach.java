package com.sandee007.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // @Component annotation marks the class as a spring bean - makes it available for dependency injection
@Primary // @Qualifier will overwrite @Primary if available
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice batting";
    }
}

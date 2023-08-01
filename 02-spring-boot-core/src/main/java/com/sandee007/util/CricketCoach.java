package com.sandee007.util;

import org.springframework.stereotype.Component;

@Component // @Component annotation marks the class as a spring bean - makes it available for dependency injection
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice batting";
    }
}

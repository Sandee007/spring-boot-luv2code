package com.sandee007.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // @Component annotation marks the class as a spring bean - makes it available for dependency injection
@Primary // @Qualifier will overwrite @Primary if available
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Init Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice batting";
    }
}

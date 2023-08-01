package com.sandee007.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // @Component annotation marks the class as a spring bean - makes it available for dependency injection
@Primary // @Qualifier will overwrite @Primary if available
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // SINGLETON is the default
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Init Constructor: " + getClass().getSimpleName());
    }

    //    on class init
    @PostConstruct
    public void doStuffOnInit() {
        System.out.println("Class Init:" + getClass().getSimpleName());
    }

    //    before class destroy
    @PreDestroy
    public void doStuffOnDestroy() {
        System.out.println("Class Destroy:" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice batting";
    }
}

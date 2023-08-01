package com.sandee007.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("Init Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "practice back hand volley";
    }
}

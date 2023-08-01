package com.sandee007.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    public FootballCoach() {
        System.out.println("Init Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "TIki taka";
    }
}

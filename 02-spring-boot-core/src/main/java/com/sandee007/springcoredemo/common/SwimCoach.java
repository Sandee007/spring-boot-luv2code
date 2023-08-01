package com.sandee007.springcoredemo.common;

// * isnot configured as a @Component, instead is used as a @Bean
public class SwimCoach implements Coach {
    public SwimCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim";
    }
}

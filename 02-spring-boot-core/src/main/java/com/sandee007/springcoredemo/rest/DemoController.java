package com.sandee007.springcoredemo.rest;

import com.sandee007.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;
    private Coach coach2;

    //    define a constructor for dependency injection
    @Autowired
    public DemoController(
            @Qualifier("aquatic") Coach c // calling the custom bean id here
    ) {
        System.out.println("Init Constructor: " + getClass().getSimpleName());
        coach = c;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}

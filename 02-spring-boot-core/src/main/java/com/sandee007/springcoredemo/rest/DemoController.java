package com.sandee007.springcoredemo.rest;

import com.sandee007.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;

    //    define a constructor for dependency injection
    @Autowired
    public DemoController(Coach c) {
        coach = c;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}

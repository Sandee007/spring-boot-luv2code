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
            @Qualifier("cricketCoach") Coach c,
            @Qualifier("cricketCoach") Coach c2
    ) {
        System.out.println("Init Constructor: " + getClass().getSimpleName());
        coach = c;
        coach2 = c2;
    }

//    //    setter injection
//    @Autowired
//    public void setCoach(Coach c) {
//        coach = c;
//    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

    @GetMapping("/check-bean-scope")
    public String check() {
        return "coach == coach2 :" + (coach == coach2);
    }
}

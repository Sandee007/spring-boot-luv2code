package com.sandee007.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
//		cuz we are using a package outside sping-initializr package
        scanBasePackages = {"com.sandee007.springcoredemo", "com.sandee007.util"})

public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }

}

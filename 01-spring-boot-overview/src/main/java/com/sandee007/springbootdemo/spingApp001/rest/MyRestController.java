package com.sandee007.springbootdemo.spingApp001.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    //    inject custom properties
    @Value("${driver.name}")
    private String driverName;
    @Value("${constructor.name}")
    private String constructorName;

    @GetMapping("/")
    public String sayHello() {
        return "yellow";
    }

    @GetMapping("/custom-properties")
    public String getCustomProperties() {
//        return String.format("Driver: %s, Constructor: %s", driverName, constructorName);
        return String.format("Driver: %1$s, Constructor: %2$s", driverName, constructorName);
    }
}

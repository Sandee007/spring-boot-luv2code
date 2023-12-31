package com.sandee007.mvcSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/leaders")
    public String leaders(){
        return "leaders";
    }

    @GetMapping("/systems")
    public String systems(){
        return "systems";
    }
}

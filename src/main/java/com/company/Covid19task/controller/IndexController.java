package com.company.Covid19task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String simulationIndex(){
        return "covid19simulation";
    }
}

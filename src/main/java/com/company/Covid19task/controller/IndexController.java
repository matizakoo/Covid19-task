package com.company.Covid19task.controller;

import com.company.Covid19task.service.SymulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private SymulationService symulationService;
    @GetMapping("/")
    public String symulationIndex(Model model){
        model.addAttribute("list", symulationService.findAll());
        return "createSymulation";
    }
}

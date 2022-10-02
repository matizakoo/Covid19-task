package com.company.Covid19task.controller;

import com.company.Covid19task.service.SymulationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecentSymulationsController {
    @Autowired
    private SymulationService symulationService;
    Logger logger = LoggerFactory.getLogger(RecentSymulationsController.class);

    @GetMapping("/showRecentSymulations")
    public String recentSymulations(Model model){
        model.addAttribute("list", symulationService.findAll());
        return "recentSymulations";
    }

    @PostMapping("/chooseSymulation")
    public String chosenSymulation(@RequestParam(name = "idsymulations") int idsymulation, Model model){
        logger.info("choosen symulation");
        model.addAttribute("list", symulationService.findAllPopulation(symulationService.findSymulation(idsymulation)));
        return "symulation";
    }
}

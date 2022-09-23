package com.company.Covid19task.controller;

import com.company.Covid19task.dto.SymulationsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SimulationController {
    Logger logger = LoggerFactory.getLogger(SimulationController.class);
    @PostMapping("/startSimulation")
    public String startSimulation(@RequestBody SymulationsDTO dto){
        logger.info("startSimulation");

        return "covid19simulation";
    }
}

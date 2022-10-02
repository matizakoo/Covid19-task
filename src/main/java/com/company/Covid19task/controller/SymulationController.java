package com.company.Covid19task.controller;

import com.company.Covid19task.dto.SymulationsDTO;
import com.company.Covid19task.entity.Symulations;
import com.company.Covid19task.service.SymulationService;
import com.company.Covid19task.service.SymulationsDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

@Controller
@Transactional
public class SymulationController {
    @Autowired
    private SymulationService symulationService;
    @Autowired
    private SymulationsDTOService symulationsDTOService;

    public SymulationController(SymulationsDTOService symulationsDTOService) {
        this.symulationsDTOService = symulationsDTOService;
    }

    Logger logger = LoggerFactory.getLogger(SymulationController.class);

    @PostMapping("/createSymulation")
    public String createSymulation(@RequestParam(name = "nameN") String nameN,
                                   @RequestParam(name = "sizeP") int sizeP,
                                   @RequestParam(name = "startI") int startI,
                                   @RequestParam(name = "indicatorR") int indicatorR,
                                   @RequestParam(name = "deathratioM") int deathratioM,
                                   @RequestParam(name = "recoverindexTi") int recoverindexTi,
                                   @RequestParam(name = "deathindexTm") int deathindexTm,
                                   @RequestParam(name = "daysindexTs") int daysindexTs){
        logger.info("create symulation");
        SymulationsDTO symulationsDTO = symulationsDTOService.createDTO(nameN,sizeP,startI,indicatorR,deathratioM,recoverindexTi,deathindexTm,daysindexTs);
        Symulations symulations = symulationService.dtoToEntity(symulationsDTO);
        symulationService.createSimulation(symulations.getIdsymulations());
        return "redirect:/showRecentSymulations";
    }
}

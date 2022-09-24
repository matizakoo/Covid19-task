package com.company.Covid19task.service;

import com.company.Covid19task.dto.SymulationsDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SymulationsDTOService {
    public SymulationsDTO createDTO(String nameN, int sizeP, int startI, int indicatorR, int deathratioM, int recoverindexTi, int deathindexTm, int daysindexTs){
        return new SymulationsDTO(nameN,sizeP,startI,indicatorR,deathratioM,recoverindexTi,deathindexTm,daysindexTs);
    }
}

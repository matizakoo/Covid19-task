package com.company.Covid19task.dto;


import lombok.Getter;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;

@Controller
@Getter
public class SymulationsDTO {
    private String nameN;
    private int sizeP;
    private int startI;
    private int indicatorR;
    private int deathratioM;
    private int recoveryindexTi;
    private int deathindexTm;
    private int daysindexTs;

    public SymulationsDTO() {
    }

    public SymulationsDTO(String nameN, int sizeP, int startI, int indicatorR, int deathratioM, int recoveryindexTi, int deathindexTm, int daysindexTs) {
        this.nameN = nameN;
        this.sizeP = sizeP;
        this.startI = startI;
        this.indicatorR = indicatorR;
        this.deathratioM = deathratioM;
        this.recoveryindexTi = recoveryindexTi;
        this.deathindexTm = deathindexTm;
        this.daysindexTs = daysindexTs;
    }
}

package com.company.Covid19task.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "symulations")
@Getter
public class Symulations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idsymulations")
    private int idsymulations;

    @Column(name = "name_n")
    private String nameN;

    @Column(name = "size_p")
    private int sizeP;

    @Column(name = "start_i")
    private int startI;

    @Column(name = "indicator_r")
    private int indicatorR;

    @Column(name = "deathratio_m")
    private int deathratioM;

    @Column(name = "recoverindex_ti")
    private int recoveryindexTi;

    @Column(name = "deathindex_tm")
    private int deathindexTm;

    @Column(name = "daysindex_ts")
    private int daysindexTs;

    public Symulations(String nameN, int sizeP, int startI, int indicatorR, int deathratioM, int recoveryindexTi, int deathindexTm, int daysindexTs) {
        this.nameN = nameN;
        this.sizeP = sizeP;
        this.startI = startI;
        this.indicatorR = indicatorR;
        this.deathratioM = deathratioM;
        this.recoveryindexTi = recoveryindexTi;
        this.deathindexTm = deathindexTm;
        this.daysindexTs = daysindexTs;
    }

    public Symulations() {

    }
}

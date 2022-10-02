package com.company.Covid19task.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "population")
@Getter
public class Population {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpopulation")
    private int idpopulation;

    @ManyToOne
    @JoinColumn(name = "symulations_idsymulations")
    private Symulations symulationsIdSymulations;

    @Column(name = "infected_pi")
    private int infectedPi;

    @Column(name = "healthyunprotected_pv")
    private int healthyunprotectedPv;

    @Column(name = "deaths_pm")
    private int deathsPm;

    @Column(name = "healthyprotected_pr")
    private int healthyprotectedPr;

    public Population(Symulations symulationsIdSymulations, int infectedPi, int healthyunprotectedPv, int deathsPm, int healthyprotectedPr) {
        this.symulationsIdSymulations = symulationsIdSymulations;
        this.infectedPi = infectedPi;
        this.healthyunprotectedPv = healthyunprotectedPv;
        this.deathsPm = deathsPm;
        this.healthyprotectedPr = healthyprotectedPr;
    }

    public Population() {
    }
}

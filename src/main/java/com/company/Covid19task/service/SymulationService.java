package com.company.Covid19task.service;

import com.company.Covid19task.dto.SymulationsDTO;
import com.company.Covid19task.entity.Population;
import com.company.Covid19task.entity.Symulations;
import com.company.Covid19task.repository.PopulationRepository;
import com.company.Covid19task.repository.SymulationsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Random;

@Service
public class SymulationService {
    @Autowired
    private final SymulationsRepository symulationsRepository;
    @Autowired
    private final PopulationRepository populationRepository;
    @Autowired
    private PopulationService populationService;
    private final Random random = new Random();
    int infected,hunprotected,hprotected,deaths;

    Logger logger = LoggerFactory.getLogger(SymulationService.class);
    private Symulations symulations;


    public SymulationService(SymulationsRepository symulationsRepository, PopulationRepository populationRepository) {
        this.symulationsRepository = symulationsRepository;
        this.populationRepository = populationRepository;
    }

    @Transactional
    public void save(Symulations symulations){
        symulationsRepository.save(symulations);
    }

    @Transactional
    public void save(Population population){
        populationRepository.save(population);
    }

    public Symulations dtoToEntity(SymulationsDTO dto){
        symulations = new Symulations(
                dto.getNameN(),
                dto.getSizeP(),
                dto.getStartI(),
                dto.getIndicatorR(),
                dto.getDeathratioM(),
                dto.getRecoveryindexTi(),
                dto.getDeathindexTm(),
                dto.getDaysindexTs());
        save(symulations);
        return symulations;
    }

    @Transactional
    public ArrayList<Symulations> findAll(){
        return (ArrayList<Symulations>) symulationsRepository.findAll();
    }

    @Transactional
    public ArrayList<Population> findAllPopulations(Symulations symulations){
        return (ArrayList<Population>) populationRepository.findBySymulationsIdSymulations(symulations);
    }

    @Transactional
    public Symulations findSymulation(int id){
        return symulationsRepository.getReferenceById(id);
    }

    @Transactional
    public void createSimulation(int id){
        logger.info("check symulation");
        String temp = String.valueOf(id);
        symulations = symulationsRepository.getReferenceById(Integer.valueOf(temp));
        ArrayList<Population> populations = new ArrayList<>();
        populations.add(new Population(symulations, symulations.getStartI(), 0,0,0));
        for(int i=0, n=0;i<symulations.getDaysindexTs()-1;i++, n++){
            if(i>symulations.getRecoveryindexTi() && n < symulations.getDeathindexTm()){
                populations.add(updaterLessThanTs(populations,
                        symulations, i));
            }else if(i>symulations.getRecoveryindexTi() && n >= symulations.getDeathindexTm()){
                populations.add(updaterMoreThanTs(populations,
                        symulations,i, n));
            }else{
                populations.add(new Population(
                        symulations,
                        infection(populations.get(i)),
                        0,0,0));
            }
        }
        int i = 1;
        for(Population e: populations){
            System.out.println(i++ +". " + "Infected: " + e.getInfectedPi() + ", unprotected: " + e.getHealthyunprotectedPv() +
                    ", deaths: " + e.getDeathsPm() + ", protected: " + e.getHealthyprotectedPr());
            save(e);
        }
    }

    private int infection(Population populations){
        return (populations.getInfectedPi() +
                        (populations.getInfectedPi() *
                                random.nextInt(symulations.getIndicatorR()))+1);
    }

    private Population updaterLessThanTs(ArrayList<Population> populations, Symulations symulations, int i){
        hunprotected = (int) (populations.get(i).getInfectedPi() * 0.3);
        hprotected = (int) (populations.get(i).getInfectedPi() * 0.7);
        infected = infection(populations.get(i)) - hunprotected - hprotected;

        return new Population(symulations, infected, hunprotected, 0, hprotected);
    }

    private Population updaterMoreThanTs(ArrayList<Population> populations, Symulations symulations, int i, int n){
        hunprotected = (int) (populations.get(i-symulations.getRecoveryindexTi()).getInfectedPi() * 0.3);
        hprotected = (int) (populations.get(i-symulations.getRecoveryindexTi()).getInfectedPi() * 0.7);
        deaths = (int) (populations.get(i-symulations.getDeathratioM()).getInfectedPi() * 0.1);
        infected = infection(populations.get(i)) - hunprotected - hprotected - deaths;

        return new Population(symulations, infected <= 0 ? 1 : infected, hunprotected, deaths, hprotected);
    }
}

package com.company.Covid19task.service;

import com.company.Covid19task.dto.SymulationsDTO;
import com.company.Covid19task.entity.Symulations;
import com.company.Covid19task.repository.SymulationsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class SymulationService {
    @Autowired
    private final SymulationsRepository symulationsRepository;
    Logger logger = LoggerFactory.getLogger(SymulationService.class);
    private Symulations symulations;

    public SymulationService(SymulationsRepository symulationsRepository) {
        this.symulationsRepository = symulationsRepository;
    }

    @Transactional
    public void save(Symulations symulations){
        symulationsRepository.save(symulations);
    }

    public void createSymulation(SymulationsDTO dto){
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
    }

    @Transactional
    public ArrayList<Symulations> findAll(){
        return (ArrayList<Symulations>) symulationsRepository.findAll();
    }

    @Transactional
    public void checkSymulation(int id){
        logger.info("check symulation");
        String temp = String.valueOf(id);
        symulations = symulationsRepository.getReferenceById(Integer.valueOf(temp));
        logger.info(symulations.getNameN());
    }
}

package com.company.Covid19task.service;

import com.company.Covid19task.entity.Population;
import com.company.Covid19task.repository.PopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PopulationService {
    @Autowired
    private PopulationRepository populationRepository;
    @Transactional
    public void save(Population population){
        populationRepository.save(population);
    }

    @Transactional
    public Population getPopulationEntity(int id){
        return populationRepository.getReferenceById((long) id);
    }
}

package com.company.Covid19task.repository;

import com.company.Covid19task.entity.Population;
import com.company.Covid19task.entity.Symulations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopulationRepository extends JpaRepository<Population, Long> {
    List<Population> findBySymulationsIdSymulations(Symulations symulations);
}

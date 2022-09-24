package com.company.Covid19task.repository;

import com.company.Covid19task.entity.Symulations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymulationsRepository extends JpaRepository<Symulations, Integer> {
}

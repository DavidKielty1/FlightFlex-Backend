package com.example.FlightFlex.repository;

import com.example.FlightFlex.entity.Alternatives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlternativeDatesRepository extends JpaRepository<Alternatives, Integer> {
    
}

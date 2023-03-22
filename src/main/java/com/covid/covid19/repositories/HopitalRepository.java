package com.covid.covid19.repositories;

import com.covid.covid19.models.Hopital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopitalRepository extends JpaRepository<Hopital, Integer> {
    Hopital findById(int id);
}

package com.covid.covid19.repositories;

import com.covid.covid19.models.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinRepository extends JpaRepository<Vaccin, Integer> {
    Vaccin findById(int id);
}

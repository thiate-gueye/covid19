package com.covid.covid19.repositories;

import com.covid.covid19.models.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Integer> {
    RendezVous findByIdRv(int id);
}

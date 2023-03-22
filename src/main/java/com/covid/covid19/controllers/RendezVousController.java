package com.covid.covid19.controllers;

import com.covid.covid19.models.RendezVous;
import com.covid.covid19.repositories.RendezVousRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rv")
public class RendezVousController {
    private final RendezVousRepository rendezVousRepository;

    public RendezVousController(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    @GetMapping("/")
    public List<RendezVous> accueil(){
        return rendezVousRepository.findAll();
    }

    @GetMapping("/{id}")
    public RendezVous findOne(@PathVariable int id){
        return rendezVousRepository.findByIdRv(id);
    }

    @PostMapping("/ajout")
    public RendezVous ajout(@RequestBody RendezVous rendezVous){
        return rendezVousRepository.save(rendezVous);
    }

    @GetMapping("/modifier/{id}")
    public RendezVous modifier(@RequestBody RendezVous rendezVous, @PathVariable int id){
        rendezVous.setIdRv(id);
        return rendezVousRepository.save(rendezVous);
    }

    @GetMapping("/supprimer/{id}")
    public void supprimer(@PathVariable int id){
        rendezVousRepository.deleteById(id);
    }
}

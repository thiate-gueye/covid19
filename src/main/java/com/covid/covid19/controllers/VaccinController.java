package com.covid.covid19.controllers;

import com.covid.covid19.models.Vaccin;
import com.covid.covid19.repositories.VaccinRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccin")
public class VaccinController {
    private final VaccinRepository vaccinRepository;

    public VaccinController(VaccinRepository vaccinRepository) {
        this.vaccinRepository = vaccinRepository;
    }

    @GetMapping("/")
    public List<Vaccin> accueil(){
        return vaccinRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vaccin findOne(@PathVariable int id){
        return vaccinRepository.findById(id);
    }

    @PostMapping("/ajout")
    public Vaccin ajout(@RequestBody Vaccin vaccin){
        return vaccinRepository.save(vaccin);
    }

    @GetMapping("/modifier/{id}")
    public Vaccin modifier(@RequestBody Vaccin vaccin, @PathVariable int id){
        vaccin.setId(id);
        return vaccinRepository.save(vaccin);
    }

    @GetMapping("/supprimer/{id}")
    public void supprimer(@PathVariable int id){
        vaccinRepository.deleteById(id);
    }
}

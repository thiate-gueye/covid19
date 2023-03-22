package com.covid.covid19.controllers;

import com.covid.covid19.models.Hopital;
import com.covid.covid19.repositories.HopitalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/hopital")
@RestController
public class HopitalController {

    private final HopitalRepository hopitalRepository;

    public HopitalController(HopitalRepository hopitalRepository) {
        this.hopitalRepository = hopitalRepository;
    }

    @GetMapping("/")
    public List<Hopital> accueil(){
        return hopitalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Hopital findOne(@PathVariable int id){
        return hopitalRepository.findById(id);
    }

    @PostMapping("/ajout")
    public Hopital ajout(@RequestBody Hopital hopital){
        return hopitalRepository.save(hopital);
    }

    @GetMapping("/modifier/{id}")
    public Hopital modifier(@RequestBody Hopital hopital, @PathVariable int id){
        hopital.setId(id);
        return hopitalRepository.save(hopital);
    }

    @GetMapping("/supprimer/{id}")
    public void supprimer(@PathVariable int id){
        hopitalRepository.deleteById(id);
    }
}

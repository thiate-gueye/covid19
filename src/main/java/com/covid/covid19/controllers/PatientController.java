package com.covid.covid19.controllers;

import com.covid.covid19.models.Patient;
import com.covid.covid19.repositories.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/")
    public List<Patient> accueil(){
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient findOne(@PathVariable int id){
        return patientRepository.findByIdPatient(id);
    }

    @PostMapping("/ajout")
    public Patient ajout(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @GetMapping("/modifier/{id}")
    public Patient modifier(@RequestBody Patient patient, @PathVariable int id){
        patient.setIdPatient(id);
        return patientRepository.save(patient);
    }

    @GetMapping("/supprimer/{id}")
    public void supprimer(@PathVariable int id){
        patientRepository.deleteById(id);
    }
}

package com.covid.covid19.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRv;
    private String date;
    private int heure;
    private String type;
    @ManyToOne
    private Hopital hopital;
    @ManyToOne
    private Patient patient;
}

package com.covid.covid19.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Vaccin{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String vaccin;
    private int nbVaccin;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    @JoinColumn(name = "hopital")
    private Hopital hopital;

}

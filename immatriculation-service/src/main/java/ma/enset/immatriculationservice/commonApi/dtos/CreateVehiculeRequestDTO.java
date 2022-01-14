package ma.enset.immatriculationservice.commonApi.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.immatriculationservice.query.entities.Proprietaire;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data @AllArgsConstructor @NoArgsConstructor
public class CreateVehiculeRequestDTO {

    private String matricule;
    private String marque;
    private int puissance;
    private String model;
    private Proprietaire proprietaire;

}

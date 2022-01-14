package ma.enset.redarservice.query.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Radar {
    @Id
    private String id;
    private double vitesseMax;
    private String longitude;
    private String latitude;

}

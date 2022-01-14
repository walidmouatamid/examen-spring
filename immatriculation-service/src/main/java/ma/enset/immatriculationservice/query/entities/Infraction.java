package ma.enset.immatriculationservice.query.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



//not to use here
@Data @AllArgsConstructor @NoArgsConstructor
public class Infraction {
    private long id;
    private Date date;
    private double vitesseVehicule;
}

package ma.enset.immatriculationservice.commonApi.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.immatriculationservice.query.entities.Vehicule;

import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class CreateProprietaireRequestDTO {
    private String name;
    private Date dateNaissance;
    private String email;
    private List<Vehicule> vehiculeList;
}

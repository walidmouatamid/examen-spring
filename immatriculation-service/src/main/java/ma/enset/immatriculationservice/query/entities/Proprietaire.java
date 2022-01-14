package ma.enset.immatriculationservice.query.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Proprietaire {
    @Id
    private String id;
    private String name;
    private Date dateNaissance;
    private String email;
    @OneToMany(mappedBy = "proprietaire",fetch = FetchType.EAGER)
    private List<Vehicule> vehiculeList;
}

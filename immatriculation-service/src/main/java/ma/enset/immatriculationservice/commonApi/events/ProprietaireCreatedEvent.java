package ma.enset.immatriculationservice.commonApi.events;

import lombok.Getter;
import ma.enset.immatriculationservice.query.entities.Proprietaire;
import ma.enset.immatriculationservice.query.entities.Vehicule;

import java.util.Date;
import java.util.List;

public class ProprietaireCreatedEvent extends BaseEvent<String> {
    @Getter private String name;
    @Getter private Date dateNaissance;
    @Getter private String email;
    @Getter private List<Vehicule> vehiculeList;

    public ProprietaireCreatedEvent(String id, String name, Date dateNaissance, String email, List<Vehicule> vehiculeList) {
        super(id);
        this.name = name;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.vehiculeList = vehiculeList;
    }

}

package ma.enset.immatriculationservice.commonApi.commands;

import lombok.Getter;
import ma.enset.immatriculationservice.query.entities.Proprietaire;
import ma.enset.immatriculationservice.query.entities.Vehicule;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class CreateProprietaireCommand extends BaseCommand<String> {

    @Getter private String name;
    @Getter private Date dateNaissance;
    @Getter private String email;
    @Getter private List<Vehicule> vehiculeList;


    public CreateProprietaireCommand(String id, String name, Date dateNaissance, String email, List<Vehicule> vehiculeList) {
        super(id);
        this.name = name;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.vehiculeList = vehiculeList;
    }
}

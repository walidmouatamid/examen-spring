package ma.enset.immatriculationservice.commonApi.events;

import lombok.Getter;
import ma.enset.immatriculationservice.query.entities.Proprietaire;

public class VehiculeCreatedEvent extends BaseEvent<String> {
    @Getter private String matricule;
    @Getter private String marque;
    @Getter private int puissance;
    @Getter private String model;
    @Getter private Proprietaire proprietaire;

    public VehiculeCreatedEvent(String id, String matricule, String marque, int puissance, String model, Proprietaire proprietaire) {
        super(id);
        this.matricule = matricule;
        this.marque = marque;
        this.puissance = puissance;
        this.model = model;
        this.proprietaire = proprietaire;
    }
}

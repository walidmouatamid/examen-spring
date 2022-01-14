package ma.enset.immatriculationservice.command.aggregates;


import ma.enset.immatriculationservice.commonApi.commands.CreateProprietaireCommand;
import ma.enset.immatriculationservice.commonApi.commands.CreateVehiculeCommand;
import ma.enset.immatriculationservice.commonApi.events.ProprietaireCreatedEvent;
import ma.enset.immatriculationservice.commonApi.events.VehiculeCreatedEvent;
import ma.enset.immatriculationservice.query.entities.Vehicule;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;


@Aggregate
public class ProprietaireAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private Date dateNaissance;
    private String email;
    private List<Vehicule> vehiculeList;

    public ProprietaireAggregate() {
        //obligatoir pour axon
    }

    @CommandHandler
    public ProprietaireAggregate(CreateProprietaireCommand createProprietaireCommand) {
        AggregateLifecycle.apply(new ProprietaireCreatedEvent(
                createProprietaireCommand.getId(),
                createProprietaireCommand.getName(),
                createProprietaireCommand.getDateNaissance(),
                createProprietaireCommand.getEmail(),
                createProprietaireCommand.getVehiculeList()
        ));
    }

    @EventSourcingHandler
    public void on(ProprietaireCreatedEvent event){

       this.id=event.getId();
      this.name=event.getName();
      this.dateNaissance=event.getDateNaissance();
      this.email=event.getEmail();
      this.vehiculeList=event.getVehiculeList();
    }
}

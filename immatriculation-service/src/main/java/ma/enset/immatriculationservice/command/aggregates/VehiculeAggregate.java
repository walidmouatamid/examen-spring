package ma.enset.immatriculationservice.command.aggregates;


import ma.enset.immatriculationservice.commonApi.commands.CreateVehiculeCommand;
import ma.enset.immatriculationservice.commonApi.events.VehiculeCreatedEvent;
import ma.enset.immatriculationservice.query.entities.Proprietaire;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.ManyToOne;


@Aggregate
public class VehiculeAggregate {
    @AggregateIdentifier
    private String id;
    private String matricule;
    private String marque;
    private int puissance;
    private String model;
    private Proprietaire proprietaire;

    public VehiculeAggregate() {
        //obligatoir pour axon
    }

    @CommandHandler
    public VehiculeAggregate(CreateVehiculeCommand createVehiculeCommand) {
        AggregateLifecycle.apply(new VehiculeCreatedEvent(
                createVehiculeCommand.getId(),
                createVehiculeCommand.getMatricule(),
                createVehiculeCommand.getMarque(),
                createVehiculeCommand.getPuissance(),
                createVehiculeCommand.getModel(),
                createVehiculeCommand.getProprietaire()
        ));
    }

    @EventSourcingHandler
    public void on(VehiculeCreatedEvent event){

       this.id=event.getId();
       this.matricule=event.getMatricule();
        this.marque=event.getMarque();
        this.puissance=event.getPuissance();
        this.model=event.getModel();
        this.proprietaire=event.getProprietaire();
    }
}

package ma.enset.redarservice.command.aggregates;


import ma.enset.redarservice.commonApi.commands.CreateRadarCommand;
import ma.enset.redarservice.commonApi.events.RadarCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;


@Aggregate
public class RadarAggregate {
    @AggregateIdentifier
    private String id;
    private double vitesseMax;
    private String longitude;
    private String latitude;

    public RadarAggregate() {
        //obligatoir pour axon
    }

    @CommandHandler
    public RadarAggregate(CreateRadarCommand createRadarCommand) {
        AggregateLifecycle.apply(new RadarCreatedEvent(
                createRadarCommand.getId(),
                createRadarCommand.getVitesseMax(),
                createRadarCommand.getLongitude(),
                createRadarCommand.getLongitude()
        ));
    }

    @EventSourcingHandler
    public void on(RadarCreatedEvent event){

       this.id=event.getId();
       this.vitesseMax=event.getVitesseMax();
       this.longitude=event.getLongitude();
       this.latitude=event.getLatitude();
    }
}

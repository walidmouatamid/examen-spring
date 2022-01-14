package ma.enset.immatriculationservice.query.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.immatriculationservice.commonApi.events.VehiculeCreatedEvent;
import ma.enset.immatriculationservice.commonApi.queries.GetAllVehiculeQuery;
import ma.enset.immatriculationservice.commonApi.queries.GetVehiculeByIdQuery;
import ma.enset.immatriculationservice.query.entities.Vehicule;
import ma.enset.immatriculationservice.query.repositories.VehiculeRepositoty;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class VehiculeServiceHandler {
    private VehiculeRepositoty vehiculeRepositoty;


    @EventHandler
    public void on(VehiculeCreatedEvent event){
        log.info("************************");
        log.info("RadarCreatedEvent received");

        Vehicule vehicule=new Vehicule();
        vehicule.setId(event.getId());
        vehicule.setMarque(event.getMarque());
        vehicule.setMatricule(event.getMatricule());
        vehicule.setPuissance(event.getPuissance());
        vehicule.setProprietaire(event.getProprietaire());
        vehiculeRepositoty.save(vehicule);
    }

    @QueryHandler
    public List<Vehicule> on(GetAllVehiculeQuery query){
        return vehiculeRepositoty.findAll();
    }
    @QueryHandler
    public Vehicule on(GetVehiculeByIdQuery query){
        return vehiculeRepositoty.findById(query.getId()).get();
    }
}

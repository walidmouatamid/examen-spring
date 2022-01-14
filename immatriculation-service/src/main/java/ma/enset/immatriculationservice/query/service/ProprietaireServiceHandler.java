package ma.enset.immatriculationservice.query.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.immatriculationservice.commonApi.events.ProprietaireCreatedEvent;
import ma.enset.immatriculationservice.commonApi.events.VehiculeCreatedEvent;
import ma.enset.immatriculationservice.commonApi.queries.GetAllVehiculeQuery;
import ma.enset.immatriculationservice.commonApi.queries.GetVehiculeByIdQuery;
import ma.enset.immatriculationservice.query.entities.Proprietaire;
import ma.enset.immatriculationservice.query.repositories.ProprietaireRepositoty;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ProprietaireServiceHandler {
    private ProprietaireRepositoty proprietaireRepositoty;


    @EventHandler
    public void on(ProprietaireCreatedEvent event){
        log.info("************************");
        log.info("RadarCreatedEvent received");

        Proprietaire proprietaire =new Proprietaire();
        proprietaire.setId(event.getId());
        proprietaire.setEmail(event.getEmail());
        proprietaire.setDateNaissance(event.getDateNaissance());
        proprietaire.setName(event.getName());
        proprietaire.setVehiculeList(null);
        proprietaireRepositoty.save(proprietaire);

    }

    @QueryHandler
    public List<Proprietaire> on(GetAllVehiculeQuery query){
        return proprietaireRepositoty.findAll();
    }
    @QueryHandler
    public Proprietaire on(GetVehiculeByIdQuery query){
        return proprietaireRepositoty.findById(query.getId()).get();
    }
}

package ma.enset.redarservice.query.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.redarservice.commonApi.events.RadarCreatedEvent;
import ma.enset.redarservice.commonApi.queries.GetAllRadarsQuery;
import ma.enset.redarservice.commonApi.queries.GetRadarByIdQuery;
import ma.enset.redarservice.query.entities.Radar;
import ma.enset.redarservice.query.repositories.RadarRepositoty;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class RadarServiceHandler {
    private RadarRepositoty radarRepositoty;


    @EventHandler
    public void on(RadarCreatedEvent event){
        log.info("************************");
        log.info("RadarCreatedEvent received");
       Radar radar=new Radar();
       radar.setId(event.getId());
       radar.setVitesseMax(event.getVitesseMax());
       radar.setLatitude(event.getLatitude());
       radar.setLongitude(event.getLongitude());
       radarRepositoty.save(radar);
    }

    @QueryHandler
    public List<Radar> on(GetAllRadarsQuery query){
        return radarRepositoty.findAll();
    }
    @QueryHandler
    public Radar on(GetRadarByIdQuery query){
        return radarRepositoty.findById(query.getId()).get();
    }
}

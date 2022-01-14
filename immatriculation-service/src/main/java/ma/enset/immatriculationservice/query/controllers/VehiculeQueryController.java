package ma.enset.immatriculationservice.query.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.immatriculationservice.commonApi.queries.GetAllRadarsQuery;
import ma.enset.immatriculationservice.commonApi.queries.GetAllVehiculeQuery;
import ma.enset.immatriculationservice.commonApi.queries.GetRadarByIdQuery;
import ma.enset.immatriculationservice.commonApi.queries.GetVehiculeByIdQuery;
import ma.enset.immatriculationservice.query.entities.Vehicule;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/vehicule")
@AllArgsConstructor
@Slf4j
public class VehiculeQueryController {
    private QueryGateway queryGateway;

    @GetMapping("ListVehicule")
    public List<Vehicule> getAllVehicule(){
        List<Vehicule> vehiculeList=queryGateway.query(new GetAllVehiculeQuery(), ResponseTypes.multipleInstancesOf(Vehicule.class)).join();
        return vehiculeList;
    }

    @GetMapping("ListVehicule/{id}")
    public Vehicule getAllVehicule(@PathVariable String id){
        Vehicule vehicule =queryGateway.query(new GetVehiculeByIdQuery(id), ResponseTypes.instanceOf(Vehicule.class)).join();
        return vehicule;
    }
}

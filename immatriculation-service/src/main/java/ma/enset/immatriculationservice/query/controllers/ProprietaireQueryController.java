package ma.enset.immatriculationservice.query.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.immatriculationservice.commonApi.queries.GetAllProprietaireQuery;
import ma.enset.immatriculationservice.commonApi.queries.GetProprietaireByIdQuery;
import ma.enset.immatriculationservice.query.entities.Proprietaire;
import ma.enset.immatriculationservice.query.entities.Vehicule;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/proprietaire")
@AllArgsConstructor
@Slf4j
public class ProprietaireQueryController {
    private QueryGateway queryGateway;

    @GetMapping("ListProprietaire")
    public List<Proprietaire> getAllProprietaire(){
        List<Proprietaire> proprietaireList=queryGateway.query(new GetAllProprietaireQuery(), ResponseTypes.multipleInstancesOf(Proprietaire.class)).join();
        return proprietaireList;
    }

    @GetMapping("ListProprietaire/{id}")
    public Proprietaire getAllProprietaire(@PathVariable String id){
        Proprietaire proprietaire =queryGateway.query(new GetProprietaireByIdQuery(id), ResponseTypes.instanceOf(Proprietaire.class)).join();
        return proprietaire;
    }
}

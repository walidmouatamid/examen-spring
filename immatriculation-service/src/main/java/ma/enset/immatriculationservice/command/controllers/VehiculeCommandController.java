package ma.enset.immatriculationservice.command.controllers;


import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.commonApi.commands.CreateVehiculeCommand;
import ma.enset.immatriculationservice.commonApi.dtos.CreateRadarRequestDTO;
import ma.enset.immatriculationservice.commonApi.dtos.CreateVehiculeRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/commands/vehicule/")
public class VehiculeCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping(path = "create")
    public CompletableFuture<String> createVehicule(@RequestBody CreateVehiculeRequestDTO request){
        CompletableFuture<String> response =commandGateway.send(new CreateVehiculeCommand( UUID.randomUUID().toString(),request.getMatricule(),request.getMarque(),request.getPuissance(),request.getModel(),request.getProprietaire()));
    return response;
    }
}

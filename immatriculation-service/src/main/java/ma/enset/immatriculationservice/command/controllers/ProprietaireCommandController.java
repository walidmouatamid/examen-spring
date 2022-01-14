package ma.enset.immatriculationservice.command.controllers;


import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.commonApi.commands.CreateProprietaireCommand;
import ma.enset.immatriculationservice.commonApi.commands.CreateVehiculeCommand;
import ma.enset.immatriculationservice.commonApi.dtos.CreateProprietaireRequestDTO;
import ma.enset.immatriculationservice.commonApi.dtos.CreateVehiculeRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/commands/proprietaire/")
public class ProprietaireCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping(path = "create")
    public CompletableFuture<String> createProprietaire(@RequestBody CreateProprietaireRequestDTO request){
        CompletableFuture<String> response =commandGateway.send(new CreateProprietaireCommand(UUID.randomUUID().toString(),request.getName(),new Date(),request.getEmail(),request.getVehiculeList()));
    return response;
    }
}

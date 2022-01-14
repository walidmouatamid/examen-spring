package ma.enset.redarservice.command.controllers;


import lombok.AllArgsConstructor;
import ma.enset.redarservice.commonApi.commands.CreateRadarCommand;
import ma.enset.redarservice.commonApi.dtos.CreateRadarRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/commands/radar/")
public class RadarCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping(path = "create")
    public CompletableFuture<String> createRadar(@RequestBody CreateRadarRequestDTO request){
        CompletableFuture<String> response =commandGateway.send(new CreateRadarCommand( UUID.randomUUID().toString(),request.getVitesseMax(),request.getLongitude(), request.getLatitude()));
    return response;
    }
}

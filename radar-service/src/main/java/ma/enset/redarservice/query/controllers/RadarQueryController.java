package ma.enset.redarservice.query.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.redarservice.commonApi.queries.GetAllRadarsQuery;
import ma.enset.redarservice.commonApi.queries.GetRadarByIdQuery;
import ma.enset.redarservice.query.entities.Radar;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/radar")
@AllArgsConstructor
@Slf4j
public class RadarQueryController {
    private QueryGateway queryGateway;

    @GetMapping("Listradar")
    public List<Radar> getAllRadar(){
        List<Radar> radars=queryGateway.query(new GetAllRadarsQuery(), ResponseTypes.multipleInstancesOf(Radar.class)).join();
        return radars;
    }


    @GetMapping("Listradar/{id}")
    public Radar getAllRadar(@PathVariable String id){
        Radar radar=queryGateway.query(new GetRadarByIdQuery(id), ResponseTypes.instanceOf(Radar.class)).join();
        return radar;
    }
}

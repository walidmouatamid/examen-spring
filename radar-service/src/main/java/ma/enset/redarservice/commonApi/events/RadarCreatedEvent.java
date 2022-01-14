package ma.enset.redarservice.commonApi.events;

import lombok.Getter;

public class RadarCreatedEvent extends BaseEvent<String> {
    @Getter private double vitesseMax;
    @Getter private String longitude;
    @Getter private String latitude;

    public RadarCreatedEvent(String id, double vitesseMax, String longitude, String latitude) {
        super(id);
        this.vitesseMax = vitesseMax;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

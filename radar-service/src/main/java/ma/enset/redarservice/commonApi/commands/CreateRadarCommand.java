package ma.enset.redarservice.commonApi.commands;

import lombok.Getter;

public class CreateRadarCommand extends BaseCommand<String> {

    @Getter private double vitesseMax;
    @Getter private String longitude;
    @Getter private String latitude;

    public CreateRadarCommand(String id, double vitesseMax, String longitude, String latitude) {
        super(id);
        this.vitesseMax = vitesseMax;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

package ma.enset.redarservice.commonApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRadarRequestDTO {
    private double vitesseMax;
    private String longitude;
    private String latitude;
}

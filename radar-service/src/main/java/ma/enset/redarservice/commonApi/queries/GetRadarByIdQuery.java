package ma.enset.redarservice.commonApi.queries;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRadarByIdQuery {
    private String id;
}

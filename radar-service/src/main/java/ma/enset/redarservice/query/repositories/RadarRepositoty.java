package ma.enset.redarservice.query.repositories;

import ma.enset.redarservice.query.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepositoty extends JpaRepository<Radar,String> {
}

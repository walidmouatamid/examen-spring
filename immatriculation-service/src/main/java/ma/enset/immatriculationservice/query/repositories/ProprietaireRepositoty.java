package ma.enset.immatriculationservice.query.repositories;

import ma.enset.immatriculationservice.query.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietaireRepositoty extends JpaRepository<Proprietaire,String> {
}

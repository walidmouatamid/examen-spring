package ma.enset.immatriculationservice.query.repositories;


import ma.enset.immatriculationservice.query.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepositoty extends JpaRepository<Vehicule,String> {
}

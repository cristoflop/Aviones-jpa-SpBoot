package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Mechanic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MechanicRepository extends CrudRepository<Mechanic, String> {

    List<Mechanic> findAllByName(String name);

    List<Mechanic> findAllBySurname(String surname);

}

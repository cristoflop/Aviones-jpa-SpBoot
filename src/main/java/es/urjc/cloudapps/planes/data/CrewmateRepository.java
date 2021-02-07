package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Crewmate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrewmateRepository extends CrudRepository<Crewmate, String> {

    List<Crewmate> findAllByName(String name);

    List<Crewmate> findAllBySurname(String surname);

}

package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {

    Airport findByName(String name);

}
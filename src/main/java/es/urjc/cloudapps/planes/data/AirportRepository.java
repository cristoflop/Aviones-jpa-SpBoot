package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Airport;
import es.urjc.cloudapps.planes.domain.Iata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Iata> {

    Airport findByName(String name);

}

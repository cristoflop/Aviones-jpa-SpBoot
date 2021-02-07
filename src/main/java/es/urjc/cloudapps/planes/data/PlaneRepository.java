package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Plane;
import org.springframework.data.repository.CrudRepository;

public interface PlaneRepository extends CrudRepository<Plane, String> {
}

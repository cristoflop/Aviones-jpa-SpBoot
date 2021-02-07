package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Plane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlyRepository extends CrudRepository<Plane, String> {
}

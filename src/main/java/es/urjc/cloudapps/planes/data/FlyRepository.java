package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Fly;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlyRepository extends CrudRepository<Fly, String> {
}

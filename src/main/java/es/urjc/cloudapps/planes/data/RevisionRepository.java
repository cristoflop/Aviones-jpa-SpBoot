package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Plane;
import es.urjc.cloudapps.planes.domain.Revision;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevisionRepository extends CrudRepository<Revision, Long> {

    List<Revision> findAllByPlane(Plane plane);

}

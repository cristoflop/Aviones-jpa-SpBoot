package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Revision;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisionRepository extends CrudRepository<Revision, Long> {
}

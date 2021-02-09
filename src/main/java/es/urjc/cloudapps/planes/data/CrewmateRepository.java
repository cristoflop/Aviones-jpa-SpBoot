package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Crewmate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrewmateRepository extends CrudRepository<Crewmate, String> {

    List<Crewmate> findAllByNameContaining(String name);

    @Query("select new es.urjc.cloudapps.planes.data.CrewmateTotalsProjection(cr.name, cr.surname, count(f.id), sum(f.duration)) from " +
            "Fly f join f.crewmates cr " +
            "group by cr.id")
    List<CrewmateTotalsProjection> findAllCrewmateTotals();

}

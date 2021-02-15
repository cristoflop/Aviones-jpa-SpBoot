package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Crewmate;
import es.urjc.cloudapps.planes.dto.CrewmateTotalsDto;
import es.urjc.cloudapps.planes.dto.CrewmateTotalsJsonDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrewmateRepository extends CrudRepository<Crewmate, String> {

    @Query("select new es.urjc.cloudapps.planes.dto.CrewmateTotalsDto(cr.name, cr.surname, count(f.id), sum(f.duration)) from " +
            "Fly f join f.crewmates cr " +
            "group by cr.id")
    List<CrewmateTotalsDto> findAllCrewmateTotals();

    @Query(value = "SELECT cr.id, cr.name, cr.surname, COUNT(*) AS totalFlies, COALESCE(SUM(f.duration),0) AS flyingHours " +
            "FROM flies f, JSON_TABLE(f.data, '$.crewmate_ids[*]' COLUMNS ( " +
            "    id VARCHAR(255) PATH '$' " +
            "    )) crewmates_ids " +
            "                  JOIN crewmates cr ON cr.id = crewmates_ids.id " +
            "GROUP BY cr.id " +
            "UNION " +
            "SELECT cr.id, cr.name, cr.surname, 0 AS totalFlies, 0 AS flyingHours " +
            "FROM crewmates cr WHERE cr.id NOT IN ( " +
            "    " +
            "SELECT crewmates_ids.id FROM flies f, JSON_TABLE(f.data, '$.crewmate_ids[*]' COLUMNS ( " +
            "        id VARCHAR(255) PATH '$' " +
            "        )) crewmates_ids " +
            ")", nativeQuery = true)
    List<CrewmateTotalsJsonDto> findAllCrewmateTotalsJson();

}

package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Plane;
import es.urjc.cloudapps.planes.dto.PlaneRevisionDto;
import es.urjc.cloudapps.planes.dto.PlaneRevisionJsonDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaneRepository extends CrudRepository<Plane, String> {

    @Query("select new es.urjc.cloudapps.planes.dto.PlaneRevisionDto(p.plate, r.id, r.mechanicInCharge.name, r.mechanicInCharge.surname)" +
            "from Plane p join Revision r on p = r.plane")
    List<PlaneRevisionDto> findAllWithRevisionMechanics();

    @Query(value = "SELECT p.plate AS flyId, GROUP_CONCAT(DISTINCT m.name, ' ', m.surname SEPARATOR ', ') AS mechanics " +
            "FROM planes p, JSON_TABLE(p.data, '$.revisions[*]' COLUMNS ( " +
            "         id VARCHAR(255) PATH '$.mechanic_in_charge_id' " +
            "         )) mechanics_ids\n" +
            "LEFT JOIN mechanics m ON m.id = mechanics_ids.id " +
            "GROUP BY p.plate", nativeQuery = true)
    List<PlaneRevisionJsonDto> findAllWithRevisionJson();

}

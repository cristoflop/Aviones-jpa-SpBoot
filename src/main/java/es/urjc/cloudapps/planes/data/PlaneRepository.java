package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Plane;
import es.urjc.cloudapps.planes.dto.PlaneRevisionDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaneRepository extends CrudRepository<Plane, String> {

    @Query("select new es.urjc.cloudapps.planes.dto.PlaneRevisionDto(p.plate, r.id, r.mechanicInCharge.name, r.mechanicInCharge.surname)" +
            "from Plane p join Revision r on p = r.plane")
    List<PlaneRevisionDto> findAllWithRevisionMechanics();

}

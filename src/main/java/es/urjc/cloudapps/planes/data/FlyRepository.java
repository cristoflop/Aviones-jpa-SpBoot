package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Fly;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface FlyRepository extends CrudRepository<Fly, String> {

    @Query("from Fly fly where fly.destination.city = ?1 and fly.startDate = ?2 order by fly.startTime")
    List<Fly> findAllByDestinationCityAfterDate(@Param("city") String city,
                                                @Param("date") Date date);

}

package es.urjc.cloudapps.planes.data;

import es.urjc.cloudapps.planes.domain.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    Company findByName(String name);

}

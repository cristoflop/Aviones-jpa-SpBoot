package es.urjc.cloudapps.planes;

import es.urjc.cloudapps.planes.data.AirportRepository;
import es.urjc.cloudapps.planes.data.CompanyRepository;
import es.urjc.cloudapps.planes.domain.Airport;
import es.urjc.cloudapps.planes.domain.Company;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoader {

    private final AirportRepository airportRepository;
    private final CompanyRepository companyRepository;

    public DataLoader(AirportRepository airportRepository,
                      CompanyRepository companyRepository) {
        this.airportRepository = airportRepository;
        this.companyRepository = companyRepository;
    }

    @PostConstruct
    public void init() {
        this.initAirports();
        this.initCompanies();
    }

    private void initAirports() {
        this.airportRepository.save(new Airport("MAD", "Barajas", "Madrid", "Spain"));
        this.airportRepository.save(new Airport("BCN", "El Prat", "Barcelona", "Spain"));
        this.airportRepository.save(new Airport("LCY", "London City Airport", "London", "England"));
    }

    private void initCompanies() {
        this.companyRepository.save(new Company("Iberia"));
        this.companyRepository.save(new Company("Fly Emirates"));
        this.companyRepository.save(new Company("American Airlines"));

    }

}

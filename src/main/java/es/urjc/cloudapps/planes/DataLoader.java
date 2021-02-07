package es.urjc.cloudapps.planes;

import es.urjc.cloudapps.planes.data.AirportRepository;
import es.urjc.cloudapps.planes.data.CompanyRepository;
import es.urjc.cloudapps.planes.data.CrewmateRepository;
import es.urjc.cloudapps.planes.data.MechanicRepository;
import es.urjc.cloudapps.planes.domain.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoader {

    private final AirportRepository airportRepository;
    private final CompanyRepository companyRepository;
    private final CrewmateRepository crewmateRepository;
    private final MechanicRepository mechanicRepository;

    public DataLoader(AirportRepository airportRepository,
                      CompanyRepository companyRepository,
                      CrewmateRepository crewmateRepository,
                      MechanicRepository mechanicRepository) {
        this.airportRepository = airportRepository;
        this.companyRepository = companyRepository;
        this.crewmateRepository = crewmateRepository;
        this.mechanicRepository = mechanicRepository;
    }

    @PostConstruct
    public void init() {
        this.initAirports();
        this.initCompanies();
        this.initCrewMates();
        this.initMechanics();
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
        this.companyRepository.save(new Company("Mechanics Top"));
        this.companyRepository.save(new Company("Airbus Getafe"));
        this.companyRepository.save(new Company("Airbus Illescas"));

    }

    private void initCrewMates() {
        this.crewmateRepository.save(new Crewmate("0001", "Cristofer", "Lopez", this.companyRepository.findByName("Iberia"), PositionValue.COPILOT));
        this.crewmateRepository.save(new Crewmate("0002", "Juan", "Avila", this.companyRepository.findByName("Fly Emirates"), PositionValue.COMMANDER));
        this.crewmateRepository.save(new Crewmate("0003", "Francisco", "Calero", this.companyRepository.findByName("Iberia"), PositionValue.COMMANDER));
        this.crewmateRepository.save(new Crewmate("0004", "Sergio", "Manzanaro", this.companyRepository.findByName("Fly Emirates"), PositionValue.PURSER));
    }

    private void initMechanics() {
        this.mechanicRepository.save(new Mechanic(
                "0001", "Ernesto", "Vivar", this.companyRepository.findByName("Mechanics Top"), 2020, TrainingValue.CAREER));
        this.mechanicRepository.save(new Mechanic(
                "0002", "David", "Salido", this.companyRepository.findByName("Mechanics Top"), 2020, TrainingValue.CAREER));
        this.mechanicRepository.save(new Mechanic(
                "0003", "Luis", "Fernandez", this.companyRepository.findByName("Airbus Getafe"), 2020, TrainingValue.CAREER));
        this.mechanicRepository.save(new Mechanic(
                "0004", "Micael", "Gallego", this.companyRepository.findByName("Airbus Illescas"), 2020, TrainingValue.CAREER));
    }

}

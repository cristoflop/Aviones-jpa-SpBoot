package es.urjc.cloudapps.planes;

import es.urjc.cloudapps.planes.data.*;
import es.urjc.cloudapps.planes.domain.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DataLoader {

    private final AirportRepository airportRepository;
    private final CompanyRepository companyRepository;
    private final CrewmateRepository crewmateRepository;
    private final MechanicRepository mechanicRepository;
    private final PlaneRepository planeRepository;
    private final FlyRepository flyRepository;

    public DataLoader(AirportRepository airportRepository,
                      CompanyRepository companyRepository,
                      CrewmateRepository crewmateRepository,
                      MechanicRepository mechanicRepository,
                      PlaneRepository planeRepository,
                      FlyRepository flyRepository) {
        this.airportRepository = airportRepository;
        this.companyRepository = companyRepository;
        this.crewmateRepository = crewmateRepository;
        this.mechanicRepository = mechanicRepository;
        this.planeRepository = planeRepository;
        this.flyRepository = flyRepository;
    }

    @PostConstruct
    public void init() {
        this.initAirports();
        this.initCompanies();
        this.initCrewMates();
        this.initMechanics();
        this.initPlanes();
        this.initFlies();
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

    private void initPlanes() {
        this.planeRepository.save(new Plane("0001", "Airbus", "A320", 5000));
        this.planeRepository.save(new Plane("0002", "British Airways", "Boeing 747", 5000));
        this.planeRepository.save(new Plane("0003", "EEUU", "F-18", 5000));
        this.planeRepository.save(new Plane("0004", "Heinkel", "He 280", 2000));
        this.planeRepository.save(new Plane("0005", "Arado", "Ar 430", 2000));
    }

    private void initFlies() {
        this.flyRepository.save(new Fly(
                this.companyRepository.findByName("Iberia"),
                this.planeRepository.findById("0001").get(),
                this.airportRepository.findById(new Iata("MAD")).get(),
                this.airportRepository.findById(new Iata("BCN")).get(),
                Date.valueOf(LocalDate.parse("2020-05-10 09:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                1.2,
                this.crewmateRepository.findAllByNameContaining("o")));

        this.flyRepository.save(new Fly(
                this.companyRepository.findByName("Iberia"),
                this.planeRepository.findById("0002").get(),
                this.airportRepository.findById(new Iata("MAD")).get(),
                this.airportRepository.findById(new Iata("LCY")).get(),
                Date.valueOf(LocalDate.parse("2020-05-27 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                2.43,
                this.crewmateRepository.findAllByNameContaining("a")));
    }

}

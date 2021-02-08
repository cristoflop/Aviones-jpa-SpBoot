package es.urjc.cloudapps.planes;

import es.urjc.cloudapps.planes.data.*;
import es.urjc.cloudapps.planes.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class DataLoader implements CommandLineRunner {

    private final AirportRepository airportRepository;
    private final CompanyRepository companyRepository;
    private final CrewmateRepository crewmateRepository;
    private final MechanicRepository mechanicRepository;
    private final PlaneRepository planeRepository;
    private final FlyRepository flyRepository;
    private final RevisionRepository revisionRepository;

    public DataLoader(AirportRepository airportRepository,
                      CompanyRepository companyRepository,
                      CrewmateRepository crewmateRepository,
                      MechanicRepository mechanicRepository,
                      PlaneRepository planeRepository,
                      FlyRepository flyRepository,
                      RevisionRepository revisionRepository) {
        this.airportRepository = airportRepository;
        this.companyRepository = companyRepository;
        this.crewmateRepository = crewmateRepository;
        this.mechanicRepository = mechanicRepository;
        this.planeRepository = planeRepository;
        this.flyRepository = flyRepository;
        this.revisionRepository = revisionRepository;
    }

    @Override
    public void run(String... args) {
        this.initAirports();
        this.initCompanies();
        this.initCrewMates();
        this.initMechanics();
        this.initPlanes();
        this.initFlies();
        this.initRevisions();

        // queries
        System.out.println("----------------------------------------");
        System.out.println("Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de\n" +
                "sus revisiones.");

        System.out.println("----------------------------------------");
        System.out.println("Dado el nombre de una ciudad y una fecha, listado de los vuelos que han aterrizado\n" +
                "(destino) en los aeropuertos de esa ciudad en esa fecha, ordenados por hora.");

        System.out.println("----------------------------------------");
        System.out.println("Dado el código de empleado de un tripulante, mostrar su nombre y apellidos y las\n" +
                "ciudades desde las que ha despegado junto con la fecha en que despegó.");

        System.out.println("----------------------------------------");
        System.out.println("Para cada tripulante, mostrar su nombre y apellidos junto con su número total de\n" +
                "vuelos y la suma de horas de estos.");

        System.out.println("----------------------------------------");


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
        this.crewmateRepository.save(new Crewmate("0001", "Cristofer", "Lopez", this.companyRepository.findByName("Iberia"), Position.COPILOT));
        this.crewmateRepository.save(new Crewmate("0002", "Juan", "Avila", this.companyRepository.findByName("Fly Emirates"), Position.COMMANDER));
        this.crewmateRepository.save(new Crewmate("0003", "Francisco", "Calero", this.companyRepository.findByName("Iberia"), Position.COMMANDER));
        this.crewmateRepository.save(new Crewmate("0004", "Sergio", "Manzanaro", this.companyRepository.findByName("Fly Emirates"), Position.PURSER));
    }

    private void initMechanics() {
        this.mechanicRepository.save(new Mechanic(
                "0001", "Ernesto", "Vivar", this.companyRepository.findByName("Mechanics Top"), 2020, Training.CAREER));
        this.mechanicRepository.save(new Mechanic(
                "0002", "David", "Salido", this.companyRepository.findByName("Mechanics Top"), 2020, Training.CAREER));
        this.mechanicRepository.save(new Mechanic(
                "0003", "Luis", "Fernandez", this.companyRepository.findByName("Airbus Getafe"), 2020, Training.CAREER));
        this.mechanicRepository.save(new Mechanic(
                "0004", "Micael", "Gallego", this.companyRepository.findByName("Airbus Illescas"), 2020, Training.CAREER));
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

        this.flyRepository.save(new Fly(
                this.companyRepository.findByName("Fly Emirates"),
                this.planeRepository.findById("0001").get(),
                this.airportRepository.findById(new Iata("LCY")).get(),
                this.airportRepository.findById(new Iata("BCN")).get(),
                Date.valueOf(LocalDate.parse("2020-06-18 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                3.1,
                this.crewmateRepository.findAllByNameContaining("er")));
    }

    private void initRevisions() {
        this.revisionRepository.save(new Revision(
                this.planeRepository.findById("0001").get(),
                Date.valueOf(LocalDate.parse("2020-01-27 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                Date.valueOf(LocalDate.parse("2020-01-29 18:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                23,
                this.mechanicRepository.findById("0001").get(),
                RevisionType.PERIODIC,
                "Periodic revision of January",
                this.airportRepository.findById(new Iata("MAD")).get()
        ));

        this.revisionRepository.save(new Revision(
                this.planeRepository.findById("0001").get(),
                Date.valueOf(LocalDate.parse("2020-02-10 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                Date.valueOf(LocalDate.parse("2020-02-15 18:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))),
                40,
                this.mechanicRepository.findById("0001").get(),
                RevisionType.REPARATION,
                "Left wing reparation",
                this.airportRepository.findById(new Iata("MAD")).get()
        ));
    }

}

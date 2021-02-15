package es.urjc.cloudapps.planes;

import es.urjc.cloudapps.planes.data.*;
import es.urjc.cloudapps.planes.domain.Crewmate;
import es.urjc.cloudapps.planes.domain.Fly;
import es.urjc.cloudapps.planes.domain.provinces.Data;
import es.urjc.cloudapps.planes.dto.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.util.List;

@Controller
public class DataLoader implements CommandLineRunner {

    private final AirportRepository airportRepository;
    private final CompanyRepository companyRepository;
    private final CrewmateRepository crewmateRepository;
    private final MechanicRepository mechanicRepository;
    private final PlaneRepository planeRepository;
    private final FlyRepository flyRepository;
    private final RevisionRepository revisionRepository;
    private final ProvinceRepository provinceRepository;

    public DataLoader(AirportRepository airportRepository,
                      CompanyRepository companyRepository,
                      CrewmateRepository crewmateRepository,
                      MechanicRepository mechanicRepository,
                      PlaneRepository planeRepository,
                      FlyRepository flyRepository,
                      RevisionRepository revisionRepository,
                      ProvinceRepository provinceRepository) {
        this.airportRepository = airportRepository;
        this.companyRepository = companyRepository;
        this.crewmateRepository = crewmateRepository;
        this.mechanicRepository = mechanicRepository;
        this.planeRepository = planeRepository;
        this.flyRepository = flyRepository;
        this.revisionRepository = revisionRepository;
        this.provinceRepository = provinceRepository;
    }

    @Override
    public void run(String... args) {
        //show sample data
        System.out.println("--------------DATOS EN BBDD-------------");
        printAll(airportRepository);
        printAll(companyRepository);
        printAll(crewmateRepository);
        printAll(mechanicRepository);
        printAll(planeRepository);
        printAll(flyRepository);
        printAll(revisionRepository);

        System.out.println("----------------------------------------");
        // queries v1
        System.out.println("----------------------------------------");
        this.queryV1_1();
        System.out.println("----------------------------------------");
        this.queryV1_2();
        System.out.println("----------------------------------------");
        this.queryV1_3();
        System.out.println("----------------------------------------");
        this.queryV1_4();

        // queries v2
        System.out.println("----------------------------------------");
        this.queryV2_1();
        System.out.println("----------------------------------------");
        this.queryV2_2();
        System.out.println("----------------------------------------");
        this.queryV2_3();
        System.out.println("----------------------------------------");
        this.queryV2_3();
        System.out.println("----------------------------------------");
        this.queryV2_4();
        System.out.println("----------------------------------------");
    }

    private void printAll(CrudRepository<?, ?> repository) {
        repository.findAll().forEach(System.out::println);
    }

    private void queryV1_1() {
        System.out.println("Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de\n" +
                "sus revisiones.");
        List<PlaneRevisionDto> planes = this.planeRepository.findAllWithRevisionMechanics();
        planes.forEach(plane -> {
            System.out.println("--- Avion con matricula " + plane.getPlate());
            System.out.println("   --- Revision con id: " + plane.getRevisionId() + ", responsable: " +
                    plane.getMechanicName().concat(" ").concat(plane.getMechanicSurname()));
        });
    }

    private void queryV1_2() {
        String city = "Barcelona";
        Date date = Date.valueOf("2020-06-18"); // 18 de junio de 2020 aterrizan dos vuelos en Barcelona
        System.out.println("Dado el nombre de una ciudad y una fecha, listado de los vuelos que han aterrizado\n" +
                "(destino) en los aeropuertos de esa ciudad en esa fecha, ordenados por hora.");
        List<Fly> flies = this.flyRepository.findAllByDestinationCityAfterDate(city, date);
        System.out.println("--- Vuelos el dia " + date.toString() + ", " + flies.size());
        flies.forEach(fly -> {
            System.out.println("   --- Vuelo " + fly.getSource().getName() + " - " + fly.getDestination().getName());
            System.out.println("      --- Duracion " + fly.getDuration() + " horas");
            System.out.println("      --- Compañia " + fly.getCompany().getName());
        });
    }

    private void queryV1_3() {
        String crewmateId = "0001"; // Cristofer despega desde MAD y LCY
        System.out.println("Dado el código de empleado de un tripulante, mostrar su nombre y apellidos y las\n" +
                "ciudades desde las que ha despegado junto con la fecha en que despegó.");
        Crewmate crewmate = this.crewmateRepository.findById(crewmateId).get();
        List<Fly> flies = this.flyRepository.findAllByCrewmatesContaining(crewmate);
        System.out.println("--- "
                .concat(crewmate.getName())
                .concat(" ")
                .concat(crewmate.getSurname())
                .concat(", vuelos que ha realizado: " + flies.size()));
        flies.forEach(fly -> {
            System.out.println("   --- Desde " + fly.getSource().getName() + " el dia " + fly.getStartDate());
        });
    }

    private void queryV1_4() {
        System.out.println("Para cada tripulante, mostrar su nombre y apellidos junto con su número total de\n" +
                "vuelos y la suma de horas de estos.");
        for (CrewmateTotalsDto totals : this.crewmateRepository.findAllCrewmateTotals()) {
            System.out.println("--- "
                    .concat(totals.getName())
                    .concat(" ")
                    .concat(totals.getSurname())
                    .concat(", vuelos que ha realizado: " + totals.getTotalFlies())
                    .concat(", horas de vuelo: " + totals.getFlyingHours())
            );
        }
    }

    private void queryV2_1() {
        System.out.println("Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de\n" +
                "sus revisiones. (v2)");
        List<PlaneRevisionJsonDto> planes = this.planeRepository.findAllWithRevisionJson();
        planes.forEach(plane -> {
                System.out.println("--- Avion con matricula " + plane.getFlyId());
                System.out.println("   --- Mecánicos: "+ plane.getMechanics());
        });
    }

    private void queryV2_2() {
        System.out.println("Para cada tripulante, mostrar su nombre y apellidos junto con su número total de\n" +
                "vuelos y la suma de horas de estos. (v2)");
        for (CrewmateTotalsJsonDto totals : this.crewmateRepository.findAllCrewmateTotalsJson()) {
            System.out.println("--- "
                    .concat(totals.getName())
                    .concat(" ")
                    .concat(totals.getSurname())
                    .concat(", vuelos que ha realizado: " + totals.getTotalFlies())
                    .concat(", horas de vuelo: " + totals.getFlyingHours())
            );
        }
    }

    private void queryV2_3() {
        System.out.println("Listado de los datos de todas las provincias. (v2)");
        for (Data provinceData : this.provinceRepository.findAllProvincesData()) {
            System.out.println(
                    "--- "
                    .concat("(")
                    .concat(provinceData.getYear().toString())
                    .concat(") ")
                    .concat("Valor:")
                    .concat(" ")
                    .concat(provinceData.getValue().toString())
            );
        }
    }

    private void queryV2_4() {
        System.out.println("Listado mostrando, para cada comunidad autónoma, su número de provincias (v2)");
        for (ProvinceTotalsDto totals : this.provinceRepository.findAllProvincesTotals()) {
            System.out.println(
                    "--- "
                    .concat(totals.getId())
                    .concat(", ")
                    .concat("Provincias:")
                    .concat(" ")
                    .concat(totals.getProvinces().toString())
            );
        }
    }

}

package es.urjc.cloudapps.planes.domain;

import javax.persistence.*;

@Entity
@Table(name = "Airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private Iata iata;

    private String name;

    private String city;

    private String country;

    public Airport(long id, Iata iata, String name, String city, String country) {
        this.id = id;
        this.iata = iata;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public Airport() {
    }

    public long getId() {
        return id;
    }

    public Iata getIata() {
        return iata;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}

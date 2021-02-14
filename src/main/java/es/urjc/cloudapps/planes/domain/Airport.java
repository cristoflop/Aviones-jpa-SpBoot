package es.urjc.cloudapps.planes.domain;

import javax.persistence.*;

@Entity
@Table(name = "Airports")
@Access(value = AccessType.FIELD)
public class Airport {

    @EmbeddedId
    private Iata iata;

    private String name;

    private String city;

    private String country;

    public Airport(String iata, String name, String city, String country) {
        this.iata = new Iata(iata);
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public Airport() {
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

    @Override
    public String toString() {
        return "Airport{" +
                "iata=" + iata +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

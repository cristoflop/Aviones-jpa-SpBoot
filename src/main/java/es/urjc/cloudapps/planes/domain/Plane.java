package es.urjc.cloudapps.planes.domain;

import javax.persistence.*;

@Entity
@Table(name = "Planes")
@Access(value = AccessType.FIELD)
public class Plane {

    @Id
    private String plate;

    private String maker;

    private String model;

    private int flightHours;

    // JSON
    private String data;

    public Plane(String plate, String maker, String model, int flightHours, String data) {
        this.plate = plate;
        this.maker = maker;
        this.model = model;
        this.flightHours = flightHours;
        this.data = data;
    }

    public Plane() {
    }

    public String getPlate() {
        return plate;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public int getFlightHours() {
        return flightHours;
    }

    public String getData() {
        return data;
    }

}

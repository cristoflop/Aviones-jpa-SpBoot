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

    public Plane(String plate, String maker, String model, int flightHours) {
        this.plate = plate;
        this.maker = maker;
        this.model = model;
        this.flightHours = flightHours;
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

}

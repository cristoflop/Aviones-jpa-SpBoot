package es.urjc.cloudapps.planes.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Mechanics")
public class Mechanic extends Employee {

    private int incorporationYear;

    @Embedded
    private Training training;

    public Mechanic(String id, String name, String surname, Company company, int incorporationYear, Training training) {
        super(id, name, surname, company);
        this.incorporationYear = incorporationYear;
        this.training = training;
    }

    public Mechanic() {
    }

    public int getIncorporationYear() {
        return incorporationYear;
    }

    public Training getTraining() {
        return training;
    }

}

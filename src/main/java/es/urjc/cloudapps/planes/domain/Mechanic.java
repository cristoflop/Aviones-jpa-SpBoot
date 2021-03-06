package es.urjc.cloudapps.planes.domain;

import javax.persistence.*;

@Entity
@Table(name = "Mechanics")
@Access(value = AccessType.FIELD)
public class Mechanic extends Employee {

    private int incorporationYear;

    @Enumerated(EnumType.STRING)
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

    @Override
    public String toString() {
        return "Mechanic{" +
                "incorporationYear=" + incorporationYear +
                ", training=" + training +
                '}';
    }
}

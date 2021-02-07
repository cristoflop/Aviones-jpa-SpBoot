package es.urjc.cloudapps.planes.domain;

import javax.persistence.*;

@Entity
@Table(name = "Crewmates")
@Access(value = AccessType.FIELD)
public class Crewmate extends Employee {

    @Enumerated(EnumType.STRING)
    private Position position;

    public Crewmate(String id, String name, String surname, Company company, Position position) {
        super(id, name, surname, company);
        this.position = position;
    }

    public Crewmate() {
    }

    public Position getPosition() {
        return position;
    }

}

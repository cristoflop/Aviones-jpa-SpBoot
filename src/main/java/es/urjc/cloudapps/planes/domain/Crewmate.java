package es.urjc.cloudapps.planes.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Crewmates")
public class Crewmate extends Employee {

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

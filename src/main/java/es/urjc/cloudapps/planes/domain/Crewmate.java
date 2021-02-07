package es.urjc.cloudapps.planes.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Crewmates")
@Access(value = AccessType.FIELD)
public class Crewmate extends Employee {

    private Position position;

    public Crewmate(String id, String name, String surname, Company company, PositionValue position) {
        super(id, name, surname, company);
        this.position = new Position(position);
    }

    public Crewmate() {
    }

    public Position getPosition() {
        return position;
    }

}

package es.urjc.cloudapps.planes.domain;

import javax.persistence.*;

@Entity
@Table(name = "Companies")
@Access(value = AccessType.FIELD)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

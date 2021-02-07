package es.urjc.cloudapps.planes.domain;

import javax.persistence.*;

@Entity
@Table(name = "Employees")
@Inheritance(strategy = InheritanceType.JOINED)
@Access(value = AccessType.FIELD)
public class Employee {

    @Id
    private String id;

    private String name;

    private String surname;

    @ManyToOne
    private Company company;

    public Employee(String id, String name, String surname, Company company) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.company = company;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Company getCompany() {
        return company;
    }

}

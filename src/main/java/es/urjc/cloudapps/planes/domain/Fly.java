package es.urjc.cloudapps.planes.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Flies")
@Access(value = AccessType.FIELD)
public class Fly {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Plane plane;

    @ManyToOne
    private Airport source;

    @ManyToOne
    private Airport destination;

    private Date startTime;

    private double duration;

    @ManyToMany
    private List<Crewmate> crewmates;

    public Fly(Company company,
               Plane plane,
               Airport source,
               Airport destination,
               Date startTime,
               double duration,
               List<Crewmate> crewmates) {
        this.company = company;
        this.plane = plane;
        this.source = source;
        this.destination = destination;
        this.startTime = startTime;
        this.duration = duration;
        this.crewmates = crewmates;
    }

    public Fly() {
    }

    public long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Plane getPlane() {
        return plane;
    }

    public Airport getSource() {
        return source;
    }

    public Airport getDestination() {
        return destination;
    }

    public Date getStartTime() {
        return startTime;
    }

    public double getDuration() {
        return duration;
    }

    public List<Crewmate> getCrewmates() {
        return crewmates;
    }

}

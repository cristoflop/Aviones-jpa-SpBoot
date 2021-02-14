package es.urjc.cloudapps.planes.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Revisions")
@Access(value = AccessType.FIELD)
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Plane plane;

    private Date initDate;

    private Date endDate;

    private int spentHours;

    @ManyToOne
    private Mechanic mechanicInCharge;

    @Enumerated(EnumType.STRING)
    private RevisionType revisionType;

    private String description;

    @ManyToOne
    private Airport airport;

    public Revision(Plane plane,
                    Date initDate,
                    Date endDate,
                    int spentHours,
                    Mechanic mechanicInCharge,
                    RevisionType revisionType,
                    String description,
                    Airport airport) {
        this.plane = plane;
        this.initDate = initDate;
        this.endDate = endDate;
        this.spentHours = spentHours;
        this.mechanicInCharge = mechanicInCharge;
        this.revisionType = revisionType;
        this.description = description;
        this.airport = airport;
    }

    public Revision() {
    }

    public long getId() {
        return id;
    }

    public Plane getPlane() {
        return plane;
    }

    public Date getInitDate() {
        return initDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getSpentHours() {
        return spentHours;
    }

    public Mechanic getMechanicInCharge() {
        return mechanicInCharge;
    }

    public RevisionType getRevisionType() {
        return revisionType;
    }

    public String getDescription() {
        return description;
    }

    public Airport getAirport() {
        return airport;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "id=" + id +
                ", plane=" + plane +
                ", initDate=" + initDate +
                ", endDate=" + endDate +
                ", spentHours=" + spentHours +
                ", mechanicInCharge=" + mechanicInCharge +
                ", revisionType=" + revisionType +
                ", description='" + description + '\'' +
                ", airport=" + airport +
                '}';
    }
}

package es.urjc.cloudapps.planes.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Position {

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    PositionValue positionValue;

    public Position(PositionValue positionValue) {
        this.positionValue = positionValue;
    }

    public Position() {
    }

    public PositionValue getPositionValue() {
        return positionValue;
    }

}

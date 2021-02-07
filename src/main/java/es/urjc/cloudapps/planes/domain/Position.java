package es.urjc.cloudapps.planes.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Position {

    @Column(name = "position")
    PositionValue positionValue;

    public Position(PositionValue positionValue){
        this.positionValue = positionValue;
    }

    public Position() {
    }

    public PositionValue getPositionValue() {
        return positionValue;
    }

}

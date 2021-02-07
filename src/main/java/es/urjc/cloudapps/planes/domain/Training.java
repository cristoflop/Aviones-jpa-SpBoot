package es.urjc.cloudapps.planes.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Training {

    @Column(name = "training")
    @Enumerated(EnumType.STRING)
    private TrainingValue trainingValue;

    public Training(TrainingValue trainingValue) {
        this.trainingValue = trainingValue;
    }

    public Training() {
    }

    public TrainingValue getTrainingValue() {
        return trainingValue;
    }
}

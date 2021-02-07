package es.urjc.cloudapps.planes.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Training {

    @Column(name = "training")
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

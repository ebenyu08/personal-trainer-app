package com.personal.trainer.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document("mesocycles")
public class Mesocycle {

    @Id
    private String id;

    private Integer ownerId;

    private Map<Integer, TrainingDay> mesocycleDays;

    public Mesocycle() {}

    public Mesocycle(Map<Integer, TrainingDay> mesocycleDays) {
        this.mesocycleDays = mesocycleDays;
    }

    public Mesocycle(Integer ownerId, Map<Integer, TrainingDay> mesocycleDays) {
        this.ownerId = ownerId;
        this.mesocycleDays = mesocycleDays;
    }

    public Map<Integer, TrainingDay> getMesocycleDays() {
        return mesocycleDays;
    }

    public void setMesocycleDays(Map<Integer, TrainingDay> mesocycleDays) {
        this.mesocycleDays = mesocycleDays;
    }
}

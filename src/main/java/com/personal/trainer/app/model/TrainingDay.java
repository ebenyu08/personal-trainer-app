package com.personal.trainer.app.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class TrainingDay {

    @Id
    private String id;

    private List<Exercise> exercises;

    public TrainingDay() {}

    public TrainingDay(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}

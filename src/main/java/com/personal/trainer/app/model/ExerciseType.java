package com.personal.trainer.app.model;

public enum ExerciseType {

    MAIN("main"),
    ACCESSORY("accessory"),
    STRETCH("stretch");

    private final String name;

    ExerciseType(String value) {
        this.name = value;
    }

    public String value() {
        return name;
    }
}

package com.personal.trainer.app.model;

public enum MovementType {
    SQUAT("squat"),
    HIP_HINGE("hip hinge"),
    PUSH("push"),
    PULL("pull");

    private final String name;

    MovementType(String value) {
        this.name = value;
    }

    public String value() {
        return name;
    }
}

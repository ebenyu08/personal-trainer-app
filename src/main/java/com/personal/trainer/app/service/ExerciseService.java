package com.personal.trainer.app.service;

import com.personal.trainer.app.model.Exercise;

import java.util.Collection;
import java.util.List;

public interface ExerciseService {

    List<Exercise> findAll();

    Exercise findByName(String name);

    void deleteExerciseById(String id);

    void deleteAllExercises();

    Collection<Exercise> saveExerciseCollection(Collection<Exercise> exercises);
}

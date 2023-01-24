package com.personal.trainer.app.service.impl;

import com.personal.trainer.app.model.Exercise;
import com.personal.trainer.app.repository.ExerciseRepository;
import com.personal.trainer.app.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise findByName(String name) {
        return exerciseRepository.findByName(name);
    }

    @Override
    public void deleteExerciseById(String id) {
        exerciseRepository.deleteById(id);
    }

    @Override
    public void deleteAllExercises() {
        exerciseRepository.deleteAll();
    }

    @Override
    public Collection<Exercise> saveExerciseCollection(Collection<Exercise> exercises) {
        return exerciseRepository.saveAll(exercises);
    }
}

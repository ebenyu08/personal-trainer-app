package com.personal.trainer.app.service.impl;

import com.personal.trainer.app.model.Exercise;
import com.personal.trainer.app.model.Mesocycle;
import com.personal.trainer.app.model.TrainingDay;
import com.personal.trainer.app.repository.ExerciseRepository;
import com.personal.trainer.app.repository.MesocycleRepository;
import com.personal.trainer.app.service.MesocycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MesocycleServiceImpl implements MesocycleService {

    public static final List<String> BASIC_PROGRAM_EXERCISE_NAMES = Arrays.asList("Squat", "Bench Press", "Deadlift", "Pull-up");

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private MesocycleRepository mesocycleRepository;

    @Override
    public Mesocycle getBasicStrengthProgram() {
        List<Exercise> exerciseEntities = exerciseRepository.findByNameIn(BASIC_PROGRAM_EXERCISE_NAMES);
        Map<Integer, TrainingDay> trainingDays = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            trainingDays.put(i, new TrainingDay(exerciseEntities));
        }

        return new Mesocycle(trainingDays);
    }
}

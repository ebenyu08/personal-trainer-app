package com.personal.trainer.app.controller;

import com.personal.trainer.app.model.Exercise;
import com.personal.trainer.app.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return ResponseEntity.ok(exerciseService.findAll());
    }

    @GetMapping("/{exerciseName}")
    public ResponseEntity<Exercise> getExerciseByName(@PathVariable("exerciseName") String exerciseName) {
        return ResponseEntity.ok(exerciseService.findByName(exerciseName));
    }

    @PostMapping
    public ResponseEntity<Collection<Exercise>> addExercises(@RequestBody Collection<Exercise> exercises) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseService.saveExerciseCollection(exercises));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllExercises() {
        exerciseService.deleteAllExercises();
        return ResponseEntity.ok().build();
    }

}

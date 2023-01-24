package com.personal.trainer.app.repository;

import com.personal.trainer.app.model.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExerciseRepository extends MongoRepository<Exercise, String> {

    Exercise findByName(String name);

    List<Exercise> findByNameIn(List<String> names);

}

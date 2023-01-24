package com.personal.trainer.app.repository;

import com.personal.trainer.app.model.Mesocycle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MesocycleRepository extends MongoRepository<Mesocycle, String> {

    Mesocycle findByOwnerId(Integer ownerId);


}

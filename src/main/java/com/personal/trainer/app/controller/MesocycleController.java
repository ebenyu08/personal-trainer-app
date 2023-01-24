package com.personal.trainer.app.controller;

import com.personal.trainer.app.model.Mesocycle;
import com.personal.trainer.app.service.MesocycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesos")
public class MesocycleController {

    @Autowired
    private MesocycleService mesocycleService;

    @GetMapping("/basicprogram")
    public ResponseEntity<Mesocycle> getBasicStrengthProgram() {
        return ResponseEntity.ok(mesocycleService.getBasicStrengthProgram());
    }
}

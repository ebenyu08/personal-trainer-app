package com.personal.trainer.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.trainer.app.model.Exercise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataMongo
@ActiveProfiles("test")
class MesocycleControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MesocycleController mesocycleController;

    @Test
    void getBasicStrengthProgram() throws Exception {

        mockMvc.perform(post("/exercises")
                .contentType("application/json").content(getTestData()))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    private String getTestData() {
        return "[{\"name\":\"Squat\",\"muscles\":[\"QuadricepsFemoris\",\"GluteusMaximus\"],\"movementType\":\"SQUAT\",\"exerciseType\":\"MAIN\"}," +
                "{\"name\":\"Deadlift\",\"muscles\":[\"Hamstrings\",\"GluteusMaximus\"],\"movementType\":\"HIP_HINGE\",\"exerciseType\":\"MAIN\"}," +
                "{\"name\":\"BenchPress\",\"muscles\":[\"PectoralisMajor\",\"Deltoideus\",\"TricepsBrachii\"],\"movementType\":\"PUSH\",\"exerciseType\":\"MAIN\"}," +
                "{\"name\":\"Pull-up\",\"muscles\":[\"LatissimusDorsi\",\"BicepsBrachii\"],\"movementType\":\"PULL\",\"exerciseType\":\"MAIN\"}]";
    }
}
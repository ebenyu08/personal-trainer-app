package com.personal.trainer.app.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.trainer.app.model.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataMongo
@ActiveProfiles("test")
class ExerciseControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ExerciseController exerciseController;

    @Test
    public void getAllExercisesTest() throws Exception {

        String testData = getTestData();
        List<Exercise> expectedResult = OBJECT_MAPPER.readValue(testData, new TypeReference<>(){});
        List<Exercise> actualResult = OBJECT_MAPPER.readValue(mockMvc.perform(post("/exercises")
                .contentType("application/json").content(testData))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(), new TypeReference<>(){});

        assertTrue(new ReflectionEquals(expectedResult, "id").matches(actualResult));

    }

    @Test
    public void deleteAllExercisesTest() throws Exception {
       mockMvc.perform(post("/exercises")
                    .contentType("application/json").content(getTestData()))
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();


        mockMvc.perform(delete("/exercises"))
                .andDo(print())
                .andExpect(status().isOk());

        assertEquals(
                OBJECT_MAPPER.readValue(
                        mockMvc.perform(get("/exercises"))
                                .andReturn()
                                .getResponse()
                                .getContentAsString(), List.class)
                        .size(), 0);
    }

    private String getTestData() {
        return "[{\"name\":\"Squat\",\"muscles\":[\"QuadricepsFemoris\",\"GluteusMaximus\"],\"movementType\":\"SQUAT\",\"exerciseType\":\"MAIN\"}," +
                "{\"name\":\"Deadlift\",\"muscles\":[\"Hamstrings\",\"GluteusMaximus\"],\"movementType\":\"HIP_HINGE\",\"exerciseType\":\"MAIN\"}," +
                "{\"name\":\"BenchPress\",\"muscles\":[\"PectoralisMajor\",\"Deltoideus\",\"TricepsBrachii\"],\"movementType\":\"PUSH\",\"exerciseType\":\"MAIN\"}," +
                "{\"name\":\"Pull-up\",\"muscles\":[\"LatissimusDorsi\",\"BicepsBrachii\"],\"movementType\":\"PULL\",\"exerciseType\":\"MAIN\"}]";
    }

}
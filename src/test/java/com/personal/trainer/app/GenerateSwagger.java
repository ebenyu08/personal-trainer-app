package com.personal.trainer.app;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class GenerateSwagger {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void generateSwagger() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
                .andDo((result) -> {
                    FileUtils.writeStringToFile(new File("swagger.json"), result.getResponse().getContentAsString());
                });
    }
}

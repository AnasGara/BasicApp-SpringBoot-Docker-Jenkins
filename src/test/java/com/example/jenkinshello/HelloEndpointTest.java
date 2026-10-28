package com.example.jenkinshello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloEndpointTest {
    @Autowired MockMvc mvc;

    @Test void servesHelloWithoutADatabase() throws Exception {
        mvc.perform(get("/test")).andExpect(status().isOk())
            .andExpect(content().string("Hello World"));
    }
}

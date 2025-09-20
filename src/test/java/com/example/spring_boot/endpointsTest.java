package com.example.spring_boot;

import com.example.spring_boot.controller.endpoints;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(endpoints.class)
public class endpointsTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testeEndpoint() throws Exception {
        mockMvc.perform(get("/teste"))
                .andExpect(status().isOk())
                .andExpect(content().string("Check no console!"));
    }
}

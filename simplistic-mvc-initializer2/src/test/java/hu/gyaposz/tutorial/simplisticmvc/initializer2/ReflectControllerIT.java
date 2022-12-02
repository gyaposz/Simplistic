package hu.gyaposz.tutorial.simplisticmvc.initializer2;

import hu.gyaposz.tutorial.simplisticmvc.initializer2.controller.ReflectController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReflectControllerIT {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ReflectController.class)
                .alwaysExpect(status().isOk())
                .alwaysExpect(content().contentType(MediaType.APPLICATION_JSON))
                .build();
    }

    @Test
    void runTest() throws Exception {
        mockMvc.perform(get("/{value}", 42).accept(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isOk(),
                        content().string("42")
                );
    }
}

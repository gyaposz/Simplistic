package hu.gyaposz.tutorial.simplistic.contexthierarchy;

import hu.gyaposz.tutorial.simplistic.contexthierarchy.application.ServiceContextConfig;
import hu.gyaposz.tutorial.simplistic.contexthierarchy.web.WebApplicationConfig;
import hu.gyaposz.tutorial.simplistic.contexthierarchy.web.util.ViewBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration Test to check Context Hierarchy.
 * <p>
 * Usually it is enough to use {@link SpringJUnitWebConfig} annotation and provide the configuration class(es).
 * {@link SpringJUnitWebConfig} is composed of other annotations: {@link WebAppConfiguration}, {@link ExtendWith} and
 * {@link ContextConfiguration}.
 * <p>
 * However in our case {@link ContextConfiguration} does not help much, since it handles all classes on the same level.
 * {@link ContextHierarchy} must be used where {@link ContextConfiguration} instances can be provided according to their
 * position in the hierarchy.
 */
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = {ServiceContextConfig.class}),
        @ContextConfiguration(classes = {WebApplicationConfig.class})
})
@SpringJUnitWebConfig
public class ContextHierarchyIT {

    public static final String AVAILABLE_RESPONSE = "ViewBean is visible";
    public static final String MISSING_RESPONSE = "ViewBean is not visible";

    @Autowired
    WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .alwaysExpect(status().isOk())
                .alwaysExpect(content().contentType(MediaType.APPLICATION_JSON))
                .build();
    }

    /**
     * This test case checks the endpoint that tries to use {@link ViewBean} through Application/root context level.
     * Since that bean is not visible there, hence the answer.
     *
     * @throws Exception if perform and expectations fail.
     */
    @Test
    void runTestAgainstApplication() throws Exception {
        mockMvc.perform(get("/application").accept(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isOk(),
                        content().string(MISSING_RESPONSE));
    }

    /**
     * This test case checks the endpoint that tries to use {@link ViewBean} through web context level.
     * Since that bean is created there, it is visible, hence the answer.
     *
     * @throws Exception if perform and expectations fail.
     */
    @Test
    void runTestAgainstWeb() throws Exception {
        mockMvc.perform(get("/web").accept(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isOk(),
                        content().string(AVAILABLE_RESPONSE));
    }

}

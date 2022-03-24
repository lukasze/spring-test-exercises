package workshop.springb.testing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import workshop.springb.testing.model.Response;
import workshop.springb.testing.service.GreetService;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

// Ask Spring to create only controller beans
@WebMvcTest
class GreetControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    // Spring won't create any service beans
    @MockBean
    private GreetService greetService;


    @Test
    @DisplayName("http://localhost/greet?name=X&isFormal=true -> 200, Hello, X!")
    public void greetEndpoint_nameXAndIsFormalTrue() throws Exception {

        // We use mockito to mock the service behavior
        Mockito.when(greetService.greet("X", true)).thenReturn(new Response("Hello, X!", LocalDateTime.now()));

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/greet")
                .contentType("application/json")
                .param("name", "X")
                .param("isFormal", "true"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        String jsonAsString = resultActions.andReturn().getResponse().getContentAsString();
        Response response = objectMapper.readValue(jsonAsString, Response.class);

        assertEquals("Hello, X!", response.getGreeting());
    }



}

/*

 _______________________________________________________________________________________________________________________
 TODO 1

 In the integration tests, we had the Spring Boot app running.
 It's time to test only one layer - the controller class (pls notice a different annotation on a class level)

 Since the controller uses a dependency - GreetService and service layer is not a controller layer,
 we need to mock the behavior of GreetService ( @MockBean, Mockito.when)

 TODO 2 make yourself familiar with the code and then implement the test
 _______________________________________________________________________________________________________________________
                                                         \
                                                          \
                                                            /  \~~~/  \
                                                           (    ..     )~~~~,
                                                            \__     __/      \
                                                              )|  /)         |\
                                                               | /\  /___\   / ^
                                                                "-|__|   |__|
 */
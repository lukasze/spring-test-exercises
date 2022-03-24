package workshop.springb.testing.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.fail;

/*
        TODO 1

        Below is a table with five scenarios to test /greet endpoint

        An example URL, scenario 1:

        /greet

        An example URL, scenario 2:

        /greet?name=Anna&isFormal=true


        +---------------+-------------+---------------------------+-----------------+
        | endpoint      | name param  | isFormal param            | returned status |
        +---------------+-------------+---------------------------+-----------------+
        |               |             |                           |                 |
     1  | /greet        | -           | -                         | 400             |
        |               |             |                           |                 |
     2  | /greet        | +           | +                         | 200             |
        |               |             |                           |                 |
     3  | /greet        | +           | -                         | 400             |
        |               |             |                           |                 |
     4  | /greet        | -           | +                         | 200             |
        |               |             |                           |                 |
     5  | /greet        | +           |present but not true/false | 400             |
        +---------------+-------------+---------------------------+-----------------+


    TODO 2 a reminder, how to use MockMvc / ObjectMapper ( the below example does not cover all the options ;) )



    mockMvc.perform(MockMvcRequestBuilders.get("/greet")                    | send a GET HTTP request to /greet
                .contentType("application/json")                            | set content type
                .param("isFormal", "true"))                                 | add isFormal param to the urls (/greet?isFormal=true)
                .andDo(print())                                             | add some logging
                .andExpect(MockMvcResultMatchers.status().isBadRequest());  | expect the returned HTTP status to be 400


                ...

                Check JSON in the response:

                .andExpect(MockMvcResultMatchers.jsonPath("$.greeting").value("Hello, World!"));

                ...

                Map JSON to Response:

                Response response = objectMapper.readValue(jsonAsString, Response.class);


 */
@SpringBootTest
@AutoConfigureMockMvc
class GreetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /*
        TODO 3 implement tests
     */
    @Test
    @DisplayName("http://localhost/greet -> 400")
    public void greet_missingNameAndMissingIsFormal_shouldReturn400() throws Exception {

        fail();
    }

    @Test
    @DisplayName("http://localhost/greet?name=X&isFormal=true -> 200")
    public void greet_nameXAndIsFormalTrue_shouldReturn200() throws Exception {

        fail();
    }

    @Test
    @DisplayName("http://localhost/greet?name=X -> 400")
    public void greet_nameXAndMissingIsFormal_shouldReturn400() throws Exception {

        fail();
    }

    @Test
    @DisplayName("http://localhost/greet?isFormal=true -> 200")
    public void greet_missingNameAndIsFormalTrue_shouldReturn200() throws Exception {

        fail();
    }

    @Test
    @DisplayName("http://localhost/greet?name=X&isFormal=X -> 400")
    public void greet_nameXAndIsFormalX_shouldReturn400() throws Exception {

        fail();
    }

    /*
        TODO 4 extra (no solution)
            a) use jsonPath to test the incoming JSON
            b) use objectMapper to map JSON to Java and test the returned object
     */
}
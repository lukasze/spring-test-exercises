package workshop.springb.testing.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import workshop.springb.testing.model.Response;
import workshop.springb.testing.repository.ResponseRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

/*
    TODO 2
     Notice a different annotation on a class level:
     @SpringBootTest is missing - GreetServiceTest is a unit test, no Spring Boot involved.
 */
@ExtendWith(MockitoExtension.class)
class GreetServiceTest {

    /*
        TODO 3
         lines: 31-34 & 42 are needed so that we can test GreetService in isolation.
         GreetService has a dependency GreetRepository - we need to take care of the dependency's behavior
         as the method under test uses GreetRepository.
         The below line of code uses the dependency:

         var savedResponse = repository.save(response);
     */
    @Mock
    private ResponseRepository responseRepository;
    @InjectMocks
    private GreetService greetService;

    /*
        TODO 4 Analyse the below test and the method under the test
     */
    @Test
    public void greet_XTrue_shouldReturnHELLOX() throws Exception {
        var name = "X";
        var isFormal = true;
        var greeting = String.format("Hello, %s!", name);
        Response stubbedResponse = new Response(greeting, LocalDateTime.now());
        // Tell ResponseRepository's mock to return stubbedResponse object
        when(responseRepository.save(argThat(response -> greeting.equals(response.getGreeting())))).thenReturn(stubbedResponse);
        Response returnedFromService = greetService.greet(name, isFormal);

        assertEquals(greeting.toUpperCase(), returnedFromService.getGreeting());
    }

    @Test
    public void greet_YFalse_shouldReturnHIY() throws Exception {
        var name = "Y";
        var isFormal = false;
        var greeting = String.format("Hi, %s!", name);
        Response stubbedResponse = new Response(greeting, LocalDateTime.now());

        when(responseRepository.save(argThat(response -> greeting.equals(response.getGreeting())))).thenReturn(stubbedResponse);
        Response returnedFromService = greetService.greet(name, isFormal);

        assertEquals(greeting.toUpperCase(), returnedFromService.getGreeting());
    }

}

/*
 _______________________________________________________________________________________________________________________
 TODO 1 READ todos 2,3,4 and write a test for "HI, Y"
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
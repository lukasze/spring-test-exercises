package workshop.springb.testing.service;

import org.springframework.stereotype.Service;
import workshop.springb.testing.model.Response;
import workshop.springb.testing.repository.ResponseRepository;

import java.time.LocalDateTime;

@Service
public class GreetService {

    private final ResponseRepository repository;

    public GreetService(ResponseRepository repository) {
        this.repository = repository;
    }
    /*
           We want to test if greet method generates a proper Response e.g. Hello vs Hi ( line 28)
           and if toUpperCase is working as well (line 31).

           Greet method uses GreetService dependency inside - ResponseRepository.save().
           @Mock, @InjectMocks, when.thenReturn (in GreetServiceTest) are 'only' for line 30 in the below method.

           ExtendWith(MockitoExtension.class) - Mockito is a library that helps us write some unit tests when the class under
           the test has some dependencies.

     */
    public Response greet(String name, boolean isFormal) {
        String greet = isFormal ? "Hello" : "Hi";
        var response = new Response(String.format("%s, %s!", greet, name), LocalDateTime.now());
        var savedResponse = repository.save(response);
        savedResponse.setGreeting(savedResponse.getGreeting().toUpperCase());
        return savedResponse;
    }

}
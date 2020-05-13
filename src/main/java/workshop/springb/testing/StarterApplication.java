package workshop.springb.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterApplication {

    public static void main(String[] args) {

        SpringApplication.run(StarterApplication.class, args);

    }

}

/*
    TODO 0 read the below article and use it to configure a Spring Boot test with containerized Postgres

      https://blog.codeleak.pl/2020/03/spring-boot-tests-with-testcontainers.html#postgresql-configuration

      Try to do it on your own. The solution - uncomment code in todos 1-5.
      !! You need to have Docker on your machine to make the tests run !!
 */
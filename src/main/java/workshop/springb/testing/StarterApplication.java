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
 _______________________________________________________________________________________________________________________
 TODO 1 README

         No tests to implement - get familiar with this simple Spring Boot app and its layers:
                      ______________________________________
                     |               The app                |
         client  <-> |controller <-> service <-> repository | <-> database
                     |______________________________________|

         We will test our app in the following steps (each exercise is in a separate git branch).
         You will practice different kinds of tests - unit, integration, etc.
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
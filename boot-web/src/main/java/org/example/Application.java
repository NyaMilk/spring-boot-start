package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
<<<<<<< HEAD
=======

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

<<<<<<< HEAD

>>>>>>> e345323... new commit 2 edit
=======
>>>>>>> 9c52f29... new commit
}
package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application  {
//public class Application extends SpringBootServletInitializer {

//    @Override
//    public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
//        return builder.sources(Application.class);
//    }

    public static void main(String[] args)throws Exception{
        SpringApplication.run(Application.class, args);
    }
}
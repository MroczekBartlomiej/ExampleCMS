package dev.bartmroczek.stackoferflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class StackoferflowApplication {

    @Autowired
    private static PostRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(StackoferflowApplication.class, args);


    }

}

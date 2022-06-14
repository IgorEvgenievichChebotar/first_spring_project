package org.example;

import org.springframework.stereotype.Component;

import java.util.Random;

/*@Component*/
public class ClassicalMusic implements Music{
    String[] songs = {
            "Hungarian rhapsody",
            "Swan Lake",
            "Symphony #4"
    };
    @Override
    public String getSong() {
        Random random = new Random();
        return songs[random.nextInt(3)];
    }
}

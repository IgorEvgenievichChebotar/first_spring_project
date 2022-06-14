package org.example;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class JazzMusic implements Music{
    String[] songs = {
            "Ne trogai mo jazz",
            "Everybody Loves Somebody",
            "Hit the Road Jack"
    };
    @Override
    public String getSong() {
        Random random = new Random();
        return songs[random.nextInt(3)];
    }
}

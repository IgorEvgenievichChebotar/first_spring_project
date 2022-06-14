package org.example;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RockMusic implements Music{
    String[] songs = {
            "Smells Like Teen Spirit",
            "We Will Rock You",
            "Highway to hell"
    };
    @Override
    public String getSong() {
        Random random = new Random();
        return songs[random.nextInt(3)];
    }
}

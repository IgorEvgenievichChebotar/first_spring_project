package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id = 0;
    private final MusicPlayer mp;

    @Autowired
    public Computer(MusicPlayer mp) {
        this.id += 1;
        this.mp = mp;
    }

    @Override
    public String toString() {
        return "Computer " + id + " have a music-player, which " + mp.playMusic();
    }
}

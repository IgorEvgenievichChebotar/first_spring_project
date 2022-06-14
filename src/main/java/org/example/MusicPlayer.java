package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*@Component*/
@Scope("prototype")
public class MusicPlayer{
    private List<Music> music_list;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

/*    @Autowired*/
    public MusicPlayer(@Qualifier("jazzMusic") Music jm,
                       @Qualifier("classicalMusic") Music cm,
                       @Qualifier("rockMusic") Music rm) {
        music_list = new ArrayList<>();
        music_list.add(jm);
        music_list.add(rm);
        music_list.add(cm);
    }

    public MusicPlayer(List<Music> music_list) {
        this.music_list = new ArrayList<>(music_list);
    }

    public MusicPlayer() {
        this.music_list = new ArrayList<>();
        this.music_list.add(new RockMusic());
        this.music_list.add(new ClassicalMusic());
        this.music_list.add(new JazzMusic());
    }

    public String playMusic(Genres genre){
        switch (genre){
            case JAZZ:
                return String.format("playing: %s", music_list.get(0).getSong());
            case ROCK:
                return String.format("playing: %s", music_list.get(1).getSong());
            case CLASSICAL:
                return String.format("playing: %s", music_list.get(2).getSong());
            default:
                return "no music";
        }
    }

    public String playMusic(){
        return String.format("playing: %s", music_list.get(new Random().nextInt(3)).getSong());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

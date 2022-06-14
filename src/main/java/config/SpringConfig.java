package config;

import org.example.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*@Component*/
@Configuration
@PropertySource("classpath:musicPlayer.properties")
/*@ComponentScan("org.example")*/
public class SpringConfig {
    @Bean
    public ClassicalMusic classicalMusic(){
        return new ClassicalMusic();
    }
    @Bean
    public JazzMusic jazzMusic(){
        return new JazzMusic();
    }
    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }

    @Bean
    public MusicPlayer musicPlayer(){
        return new MusicPlayer(musicList());
    }

    @Bean
    public List<Music> musicList(){
        List<Music> music_list = new ArrayList<>();

        music_list.add(jazzMusic());
        music_list.add(rockMusic());
        music_list.add(classicalMusic());

        return music_list;
    }

    @Bean
    public Computer computer(){
        return new Computer(musicPlayer());
    }

    @Bean
    public ConnectToDB connectToDB(){
        return ConnectToDB.getConnection();
    }
}

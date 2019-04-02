/*import sun.audio.*;
import java.io.*;

public class Sound {
  InputStream in;
  AudioStream as;
  
  Sound () {
    try {
      in = new FileInputStream("../assets/audio/theme.mp3");
      as = new AudioStream(in);
    } catch (IOException e) {
      System.out.println("IOException while playing file: " + e);
    }
  }
  
  public void play() {
    System.out.println("here my dude");
    AudioPlayer.player.start(as);
  }
  
  public void stop() {
    AudioPlayer.player.stop(as);
  }
}*/

import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import java.io.File;

public class Sound {
  Media media;
  MediaPlayer player;
  
  Sound() {
    media = new Media(new File("../assets/audio/theme.mp3").toURI().toString());
    player = new MediaPlayer(media);
  }
  
  public void play() {
    player.play();
  }
  
  public void pause() {
    player.pause();
  }
}

package SpaceInvaders;

import javax.sound.sampled.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Sound {
    Sound() {
        try {
            Clip bgm = AudioSystem.getClip();
            URL is = Sound.class.getResource("music.wav");
            ;
            AudioInputStream ais = AudioSystem.getAudioInputStream(is);
            bgm.open(ais);
            bgm.start();
            bgm.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

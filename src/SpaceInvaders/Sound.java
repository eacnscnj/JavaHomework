package SpaceInvaders;

import javax.sound.sampled.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

//播放音乐
public class Sound extends Thread{
    Sound() {
        //可能出现异常，使用try-catch
        try {
            synchronized (Sound.class) {
                Clip bgm = AudioSystem.getClip();
                URL is = Sound.class.getResource("music.wav");
                //打开文件
                AudioInputStream ais = AudioSystem.getAudioInputStream(is);
                bgm.open(ais);
                bgm.start();
                //循环
                bgm.loop(Clip.LOOP_CONTINUOUSLY);
            }

        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

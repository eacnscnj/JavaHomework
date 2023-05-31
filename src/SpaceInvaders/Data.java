package SpaceInvaders;

import javax.swing.*;
import java.net.URL;
import java.awt.*;

public class Data{
    public static URL AlienURL = Data.class.getResource("Alian.png");
    public static ImageIcon alien = new ImageIcon(AlienURL);//敌人
    public static URL GamerURL = Data.class.getResource("Gamer.png");
    public static URL BulletURL = Data.class.getResource("bullet.png");
    public static URL HeaderURL = Data.class.getResource("img.png");
    public static URL BackgroundURL = Data.class.getResource("background.png");
    public static ImageIcon gamer = new ImageIcon(GamerURL);//玩家
    public static ImageIcon header = new ImageIcon(HeaderURL);//点缀用横幅
    public static ImageIcon bullet = new ImageIcon(BulletURL);//子弹
    public static ImageIcon background = new ImageIcon(BackgroundURL);//背景

}

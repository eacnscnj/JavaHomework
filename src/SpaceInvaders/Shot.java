package SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Shot {
    public static URL BulletURL = Data.class.getResource("bullet.png");
    public static ImageIcon bullet = new ImageIcon(BulletURL);//子弹
    public int x;
    public int y;

    public Shot(){

    }

    public Shot(int x,int y){

        initShot(x,y);
    }


    public void setX(int x) {

        this.x = x;
    }

    public void setY(int y) {

        this.y = y;
    }
    private void initShot(int x,int y){

    }
}

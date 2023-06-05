package SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

//子弹发射和定义
public class Shot {
    public static URL BulletURL = Data.class.getResource("bullet.png");
    public static ImageIcon bullet = new ImageIcon(BulletURL);
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

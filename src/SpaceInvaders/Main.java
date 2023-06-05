package SpaceInvaders;

import javax.swing.*;
import java.awt.*;

public class Main {
    //start game
    public static void main(String[] args) throws Exception {
        //Lambda表达式实现事件分派线程
        EventQueue.invokeLater(() ->{
            //主界面
            JFrame frame = new JFrame("SpaceInvaders");
            frame.setBounds(10,10,1440,900);
            frame.setResizable(false);

            frame.add(new GamePanel());
            new downLoadFrame(frame);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        });
    }
}

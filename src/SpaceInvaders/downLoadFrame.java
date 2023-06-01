package SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class downLoadFrame extends JFrame {
    Button startButton;
    Button quitButton;
    JFrame jFrame;

    downLoadFrame(JFrame frame){
        init(frame);

    }
    void init(JFrame frame1){

        jFrame  = new JFrame("初始界面");
        jFrame.setSize(300,400);

        startButton = new Button("start");
        quitButton = new Button("quit");

        jFrame.add(startButton,BorderLayout.NORTH);
        jFrame.add(quitButton,BorderLayout.SOUTH);

        //Lambda表达式代替匿名内部类
        quitButton.addActionListener(e -> System.exit(0));
        startButton.addActionListener(e -> frame1.setVisible(true));
        startButton.addActionListener(e -> new Sound());
        jFrame.setVisible(true);
    }

}

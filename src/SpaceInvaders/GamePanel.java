package SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
* 1.定义数据
* 2.画上去
* 3.监听事件
*/
//游戏面板
public class GamePanel extends JPanel implements KeyListener , ActionListener {
    //默认不开始
    boolean isStar = false;
    boolean isFail = false;
    Thread thread;
    //玩家位置
    int gamerx;
    int gamery;
    int bulletx = 0;
    int bullety = 0;
    int score;
    int bulletSpeed;
    //判断胜利事件
    boolean []willWin = new boolean[6];
    boolean []scoerplus = new boolean[6];
    boolean win = false;
    //存储子弹对象
    Shot shot;
    int [] alienx = new int[6];
    int [] alieny = new int[6];
    String Direction;

    //构造函数初始化
    public GamePanel(){
        init();
        setSizeOfGame();
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    //初始化gamer和alian大小
    public void setSizeOfGame(){

        Data.alien.setImage(Data.alien.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        Shot.bullet.setImage(Shot.bullet.getImage().getScaledInstance(20,10,Image.SCALE_DEFAULT));
        Data.gamer.setImage(Data.gamer.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        Data.background.setImage(Data.background.getImage().getScaledInstance(1395,680,Image.SCALE_DEFAULT));
    }
    //初始化数值和位置
    public void init(){
        gamerx = 100;
        gamery = 230;
        thread = new Thread();
        bulletSpeed = 20;
        score = 0;

        for(int i=0;i<6;i++){
            alienx[i]=1395;
            alieny[i]=230 + i*100;
            willWin[i] = false;
            scoerplus[i] = false;
        }

        Direction = "R";
        shot=new Shot(gamerx,gamery);
        timer.start();
    }

    //annotation,注解，限定父类重写方法
    @Override
    //画笔
    protected void paintComponent(Graphics g){

        try {
            //清屏
            super.paintComponent(g);
            this.setBackground(Color.WHITE);

            Data.header.paintIcon(this,g,0,10);

            //操作界面大小和排版
            g.fillRect(25,180,1395,680);
            Data.background.paintIcon(this,g,25,180);

            g.setColor(Color.cyan);
            g.setFont(new Font("微软雅黑",Font.BOLD,30));
            g.drawString("积分： "+score,1250,50);
            g.setFont(new Font("微软雅黑",Font.BOLD,20));
            g.setColor(Color.green);
            g.drawString("你",5,300);
            g.drawString("的",5,400);
            g.drawString("家",5,500);
            g.drawString("园",5,600);

            Data.gamer.paintIcon(this,g,gamerx,gamery);
            Shot.bullet.paintIcon(this,g,bulletx,bullety);
            for(int i=0;i<6;i++){
                Data.alien.paintIcon(this,g,alienx[i],alieny[i]);
            }

            if(isStar == false){
                g.setColor(Color.white);
                g.setFont(new Font("微软雅黑",Font.BOLD,40));
                g.drawString("Press space to start",460,400);
            }

            if(isFail){
                g.setColor(Color.RED);
                g.setFont(new Font("微软雅黑",Font.BOLD,40));
                g.drawString("太空侵略者入侵了你的家园,",460,400);
                g.drawString("按空格键重新守护,",500,450);
            }

            if(win){
                g.setColor(Color.green);
                g.setFont(new Font("微软雅黑",Font.BOLD,40));
                g.drawString("你守护了你的家园,",460,400);
                g.drawString("按空格键重新守护,",500,450);
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    //键盘监听
    public void keyPressed(KeyEvent e) {
        try {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_SPACE) {
                if(isFail){
                    isFail = false;
                    init();
                }
                else if(win){
                    win = false;
                    init();
                }
                else{
                    isStar = !isStar;
                }
                repaint();

            }

            //绑定移动按钮
            if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP){
                Direction = "W";
            }else if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN){
                Direction = "S";
            }else if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT){
                Direction = "A";
            }else if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT){
                Direction = "D";
            }

            if(keyCode == KeyEvent.VK_J){
                bulletx = gamerx;
                bullety = gamery;
            }
        }
        catch (Exception ee){
            ee.printStackTrace();
        }
    }
    //定时器，决定帧率
    Timer timer = new Timer(100,this);

    //事件监听
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStar && !isFail){

            //击中判定
            for(int i=0;i<6;i++) {
                if (bulletx + 20 >= alienx[i] && bulletx - 20 <= alienx[i] && bullety + 20 >= alieny[i] && bullety - 20 <= alieny[i] && willWin[i] == false)
                    willWin[i] = true;
            }
            for(int i = 0;i<6;i++) {

                if(willWin[i] == false) {
                    alienx[i] = alienx[i] - 10;

                }
                else{
                    alienx[i] = alienx[i] + 25;
                }
            }

            //子弹发射位置判断
        if(Direction.equals("W")){
            bullety = bullety - 30;
            gamery = gamery - 25;

            //边界判断
            if(gamery < 180)
                gamery = 700;
        }else if(Direction.equals("S")){
            bullety = bullety + 30;
            gamery = gamery + 25;
            if(gamery > 860)
                gamery = 60;
        }else if(Direction.equals("A")){
            bulletx = bulletx - 30;
            gamerx = gamerx - 25;
            if(gamerx < 10){
                gamerx = 1370;
            }
        } else if (Direction.equals("D")) {
            bulletx = bulletx + 30;
            gamerx = gamerx + 25;
            if(gamerx > 1395){
                gamerx = 25;
            }
        }

        //TODO:成功判断
            int cnt = 0;
            for(int i=0;i<6;i++) {
                if (willWin[i]) {
                    cnt = cnt + 1;
                    if (scoerplus[i] == false) {
                        score = score + 20;
                        scoerplus[i] = true;
                    }
                }
            }
            if(cnt==6)
                win = true;
        //TODO：失败判断
            for(int i=0;i<6;i++)
                if(alienx[i] <= 0){
                    isFail = true;
        }
            repaint();
        }
        timer.start();
    }


    //没用
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}


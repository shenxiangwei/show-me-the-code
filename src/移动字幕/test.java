package 移动字幕;

import java.awt.event.*;

import javax.swing.*;
 
import java.awt.*;
 
public class test extends JFrame
 
{
 
    public static void main(String[] args)
 
    {
 
        JFrame frame=new JFrame("title");
 
        KeyboardPanel kp=new KeyboardPanel();
 
        frame.getContentPane().add(kp);
 
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
 
        frame.setSize(300,300);
 
        frame.setVisible(true);
 
        kp.requestFocus();//把焦点移到KeyboardPanel上
 
        //frame.addKeyListener(new KeyboardPanel());//这里去掉,把监听加到KeyboardPanel上
 
    }
 
}
 
class KeyboardPanel extends JPanel implements KeyListener
 
{
 
    private int x = 100;
 
    private int y = 100;
 
    private char keyChar='A';
 
    KeyboardPanel(){
 
     addKeyListener(this);//把监听加到KeyboardPanel上
 
    }
 
    public void keyRelessed(KeyEvent e){
 
    }
 
    public void keyPressed(KeyEvent e)
 
    {
 
        switch(e.getKeyCode())
 
        {
 
            case KeyEvent.VK_DOWN: y+=10;break;
 
            case KeyEvent.VK_UP: y-=10;break;
 
            case KeyEvent.VK_LEFT:x-=10;break;
 
            case KeyEvent.VK_RIGHT: x+=10;break;
 
            default:keyChar=e.getKeyChar();
 
        }
 
        repaint();//这里刷新KeyboardPanel
 
    }
 
    protected void paintComponent(Graphics g)
 
    {
 
        super.paintComponent(g);
 
        g.setFont(new Font("TimesRoman",Font.PLAIN,24));
 
        g.setColor(Color.black);
 
        g.drawString(String.valueOf(keyChar), x, y);
 
        System.out.println("x="+x+" y="+y);//输出测试一下
 
    }
 
    @Override
 
    public void keyReleased(KeyEvent arg0) {
 
    }
 
    @Override
 
    public void keyTyped(KeyEvent arg0) {
 
    }
 
}
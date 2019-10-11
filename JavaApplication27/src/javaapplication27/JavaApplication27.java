/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication27;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author slazur
 */
public class JavaApplication27 extends JComponent implements KeyListener{

    private Thread thread;
    private static Random random = new Random();
    private static final int DIR_STEP = 2;
    private boolean isLeft = false;
    private boolean isRight = false;
    private boolean isUp = false;
    private boolean isDown = false;
    private int x, y;
     
    public JavaApplication27(int width, int height, Color color) {
        setPreferredSize(new Dimension(width, height));
        //this.setSize(width, height);
        x = width/2;
        y = height/2;
        thread = new MoveThread(this);
        thread.start();
    }
     
    //Start point
     
    public static void main(String... string) {
        JFrame frame = new JFrame("Moving Circle");
        JPanel panel = new JPanel();
        final JavaApplication27 MovingCircleGreen = new JavaApplication27(500, 500, Color.MAGENTA);
         panel.add(MovingCircleGreen);
         panel.setBackground(Color.black);
        frame.getContentPane().add(panel);
        frame.addKeyListener(MovingCircleGreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 550);
        frame.setVisible(true);
    }
     
    //Listener
     
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT) isLeft = true;
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) isRight = true;
        if (e.getKeyCode()==KeyEvent.VK_UP) isUp = true;
        if (e.getKeyCode()==KeyEvent.VK_DOWN) isDown = true;
    }
 
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT) isLeft = false;
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) isRight = false;
        if (e.getKeyCode()==KeyEvent.VK_UP) isUp = false;
        if (e.getKeyCode()==KeyEvent.VK_DOWN) isDown = false;
    }
 
    @Override
    public void keyTyped(KeyEvent arg0) {}
     
    //Graphics
     
    //@Override
    public void paintComponent(Graphics gr) {
        Graphics2D g2d = (Graphics2D) gr;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //g2d.setBackground(Color.black);
//        g2d.setColor(Color.white);
//        int width = 500;
//        int height = 500;
//        g2d.fillRect(0, 0, width, height);// fillin ground

//        int r = random.nextInt(256);
//        int g = random.nextInt(256);
//        int b = random.nextInt(256);
        g2d.setColor(Color.ORANGE);
        g2d.setStroke(new BasicStroke(4f));
        //g2d.drawOval(x - 25, y - 25, 50, 50);
        Ellipse2D el = new Ellipse2D.Double(x, y, 10, 10);
        g2d.fill(el);
    }
     
    public void animate() {
        if (isLeft) x-=DIR_STEP;
        if (isRight) x+=DIR_STEP;
        if (isUp) y-=DIR_STEP;
        if (isDown) y+=DIR_STEP;
        this.repaint();
    }
     
    //Engine thread
     
    private class MoveThread extends Thread{
        JavaApplication27 runKeyboard;
         
        public MoveThread(JavaApplication27 runKeyboard) {
            super("MoveThread");
            this.runKeyboard = runKeyboard;
        }
         
        public void run(){
            while(true) {
                runKeyboard.animate();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

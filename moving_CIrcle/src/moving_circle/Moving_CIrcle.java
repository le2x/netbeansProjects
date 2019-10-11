/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving_circle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
 
@SuppressWarnings("serial")

/**
 *
 * @author slazur
 */
public class Moving_CIrcle extends JComponent implements KeyListener {
    private double scale;
    private Color color;
    public double x = 0;
    public double y = 0;
    private int counter;
    public static boolean pulsing = false;
    private static final int DIR_STEP = 2;

    private boolean isLeft = false;
    private boolean isRight = false;
    private boolean isUp = false;
    private boolean isDown = false;
 
  public Moving_CIrcle(Color color, int delay) {
    scale = 1.0;
    this.color = color;
    setPreferredSize(new Dimension(500, 500));
  }
 
  public void dropXY(){
      x = 0;
      y = 0;
  }
 
  public void animate() {
      System.out.println(isLeft + "" + isRight + "" + isUp + "" + isDown);
        if (isLeft) x-=DIR_STEP;
        if (isRight) x+=DIR_STEP;
        if (isUp) y-=DIR_STEP;
        if (isDown) y+=DIR_STEP;
        this.repaint();
    }
  
//  @Override
//  public void actionPerformed(ActionEvent arg0) { 
//    System.out.println(isLeft + "" + isRight + "" + isUp + "" + isDown);
//      if(isLeft){ x--; }
//    if(isRight){ x++; }
//    if(isUp){ y++; }
//    if(isDown){ y--; }
//    repaint();
//    //System.out.println("time do it again !!!" + counter++);
//  }
  
  @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT && pulsing == true) isLeft = true;
        if (e.getKeyCode()==KeyEvent.VK_RIGHT && pulsing == true) isRight = true;
        if (e.getKeyCode()==KeyEvent.VK_UP && pulsing == true) isUp = true;
        if (e.getKeyCode()==KeyEvent.VK_DOWN && pulsing == true) isDown = true;
    }
 
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT && pulsing == true) isLeft = false;
        if (e.getKeyCode()==KeyEvent.VK_RIGHT && pulsing == true) isRight = false;
        if (e.getKeyCode()==KeyEvent.VK_UP && pulsing == true) isUp = false;
        if (e.getKeyCode()==KeyEvent.VK_DOWN && pulsing == true) isDown = false;
    }
    
    @Override
    public void keyTyped(KeyEvent arg0) {}
 
  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.white);
    int width = 500;
    int height = 500;
    g.fillRect(0, 0, width, height);// fillin ground
    
    g2d.setColor(Color.black);
    g2d.drawRect(0, 0, width - 1, height - 1);	// рисуем черную рамку
    
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setColor(color);	
    //g2d.scale(scale, scale);	
//    x++;
//    y++;
    if ( x == 490 || y == 490){
        System.out.println("I in th borderline!" );
    }
    Ellipse2D el = new Ellipse2D.Double(x, y, 10, 10);
    g2d.fill(el);
  }
 
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Moving Circle");
        JPanel panel = new JPanel();
        final Moving_CIrcle MovingCircleGreen = new Moving_CIrcle(Color.MAGENTA, 10);
        panel.add(MovingCircleGreen);    
        frame.getContentPane().add(panel);
        final JButton button = new JButton("Start");
        this.addKeyListener(this);
        button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (pulsing) {
              pulsing = false;    
              button.setText("Start");
            } else {
              pulsing = true;
              MovingCircleGreen.dropXY();  
              button.setText("Stop");
            }
          }
        });
        panel.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 550);
        frame.setVisible(true);
      }
    });
  }
  
      private class MoveThread extends Thread{
        Moving_CIrcle Moving_CIrcle;
         
        public MoveThread(Moving_CIrcle Moving_CIrcle) {
            super("MoveThread");
            this.Moving_CIrcle = Moving_CIrcle;
        }
         
        public void run(){
            while(true) {
                Moving_CIrcle.animate();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


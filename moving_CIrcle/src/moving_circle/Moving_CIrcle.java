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
public class Moving_CIrcle extends JComponent implements ActionListener {
  private double scale;
  private Color color;
  private Timer timer;
  public double x =10;
  public double y =10;
  private int counter;
 
  public Moving_CIrcle(Color color, int delay) {
    scale = 10.0;
    timer = new Timer(delay, this);
    this.color = color;
    setPreferredSize(new Dimension(500, 500));
  }
 
  public void start() {
    timer.start();
  }
 
  public void stop() {
    timer.stop();
  }
 
  @Override
  public void actionPerformed(ActionEvent arg0) {   
    repaint();
    System.out.println("time do it again !!!" + counter++);
  }
 
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
    g2d.scale(scale, scale);	
    x++;
    y++;
    Ellipse2D el = new Ellipse2D.Double(x, y, 20, 20);
    g2d.fill(el);
  }
 
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Moving Circle");
        JPanel panel = new JPanel();
        final Moving_CIrcle MovingCircleGreen = new Moving_CIrcle(Color.MAGENTA, 1020);
        panel.add(MovingCircleGreen);    
        frame.getContentPane().add(panel);
        final JButton button = new JButton("Start");
        button.addActionListener(new ActionListener() {
          private boolean pulsing = false;
          @Override
          public void actionPerformed(ActionEvent e) {
            if (pulsing) {
              pulsing = false;
              MovingCircleGreen.stop();     
              button.setText("Start");
            } else {
              pulsing = true;
              MovingCircleGreen.start();   
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
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacmanbegins;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author slazur
 * 
 * 
 * 
 */

class MyWin extends JFrame {
    // серийный номер класса
    private static final long serialVersionUID = 1L;
    public MyWin() {
        Container c = getContentPane(); // клиентская область окна
        c.setLayout(new BorderLayout()); // выбираем компоновщик
        // добавляем какие-нибудь дочерние элементы
        //MyComponent child = new MyComponent();
        JPanel jp = new JPanel();   
        c.add(jp);
        // -------------------------------------------
        // настройка окна
        setTitle("Example window"); // заголовок окна
        // желательные размеры окна
        setPreferredSize(new Dimension(640, 480));
        // завершить приложение при закрытии окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // устанавливаем желательные размеры
        setVisible(true); // отображаем окно
    }
}
    

//class TestGraphics extends JFrame{
//    
//    public Graphics g;
//    
//    TestGraphics() {
//        super("simpleApp");
//        setSize(1000, 1000);
//        setVisible(true);
//    }
//    
//    @Override
//    public void paint(Graphics g) {
//        this.g = g;
//        Graphics2D gr2d = (Graphics2D) g;
//        gr2d.setBackground(Color.green);
//        
//        gr2d.setPaint(Color.RED);
//                gr2d.drawLine(300, 50, -50, 300);
//                gr2d.setPaint(Color.BLUE);
//                gr2d.drawLine(500, 50, 300, 300);
//               // Рисуем многоугольник (треуголник или звезда
//               // частный случай многоугольника)
//               BasicStroke с = new BasicStroke(3); //толщина линии 3  многоугольника
//                gr2d.setStroke(с);
//
//                gr2d.setPaint(Color.MAGENTA);
//                Polygon j = new Polygon();
//                j.addPoint(270, 439);
//                j.addPoint(185, 400);
//                j.addPoint(100, 470);
//                j.addPoint(200, 550);
//                j.addPoint(240, 590);
//                j.addPoint(270, 539);
//                g.drawPolygon(j);
//                
//        
////        g.drawLine(100, 50, 360, 50);
////        Color oldColor = g.getColor();
////        Color newColor = new Color(0,0,255);
////        g.setColor(newColor);
////        g.drawLine(100, 60, 360, 60);
////        g.setColor(oldColor);
////        g.drawLine(100, 70, 360, 70);
////        
////        g.fillRoundRect(20, 70, 340, 30, 20, 15);
//    }
//    
//    public void repaintClass(){
//        System.out.println("hohoho");
//        paint(g);
//    }
//}


public class PacmanBegins {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        TestGraphics gr = new TestGraphics();
//        gr.repaint();
        MyWin ob1 = new MyWin();
    }
}
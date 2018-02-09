package eg.edu.alexu.csd.oop.draw.cs29.Controller;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

import eg.edu.alexu.csd.oop.draw.cs29.DrawingEngine;

public class Controller extends JFrame {
  //Factory
  //private MouseDraw factory;
  private EllipseFactory factory;
  private DrawingEngine drawEngine;
  private String strParam;
  
  public Controller() {
    //view str param
    //btnselected.getvalue
    //factory = new MainFactory().makeFactory(strParam);
    factory = new EllipseFactory();
    drawEngine = new DrawingEngine();
    
    //view
    setTitle("Drawer");
    setSize(700, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //controller
    addMouseListener(mouseHandler);
    addMouseMotionListener(mouseMotionHandler);
    //main
    setVisible(true);
  }

  
  private MouseListener mouseHandler = new MouseAdapter() {
    @Override
    public void mouseReleased(MouseEvent e) {
      
      factory.mouseReleasedFun(e, drawEngine);
      drawEngine.addShape(factory.Shape());
      repaint();
    }
    @Override
    public void mousePressed(MouseEvent e) {
      factory.mousePressedFun(e);
      repaint();
    }
  };

  public MouseMotionListener mouseMotionHandler = new MouseMotionAdapter() {
    @Override
    public void mouseDragged(MouseEvent e) {
      factory.mouseDraggedFun(e);
      repaint();      
      }
    };
  public void paint(Graphics gr) {
    super.paint(gr);
    factory.Shape().draw(gr);
    drawEngine.refresh(gr);
  }
  
  //main call
//  public static void main (String[] args){
//    Controller view = new Controller();
//    
//  }
}
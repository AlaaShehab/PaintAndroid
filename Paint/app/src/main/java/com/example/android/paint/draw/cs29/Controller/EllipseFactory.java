package eg.edu.alexu.csd.oop.draw.cs29.Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.*;


public class EllipseFactory implements MouseDraw {
  
  private Ellipse ellp = new Ellipse();

  public void mousePressedFun(MouseEvent e) {
    ellp = new Ellipse();
    ellp.setPosition(e.getPoint());
    ellp.setColor(Color.BLACK);
    ellp.setFillColor(Color.BLACK);
    ellp.getProperties().put("xDiameter", 0.0);
    ellp.getProperties().put("yDiameter", 0.0);
  }
  
  public void mouseReleasedFun(MouseEvent e, DrawingEngine drawEngine) {
    
    double yRadius = e.getPoint().distance(e.getX(), ellp.getPosition().getY());
    double xRadius = e.getPoint().distance(ellp.getPosition().getX(), e.getY());
    ellp.getProperties().put("xDiameter", xRadius);
    ellp.getProperties().put("yDiameter", yRadius);
    drawEngine.addShape(ellp);

  }
  
  public void mouseDraggedFun(MouseEvent e) {
    double yRadius = e.getPoint().distance(e.getX(), ellp.getPosition().getY());
    double xRadius = e.getPoint().distance(ellp.getPosition().getX(), e.getY());
    ellp.getProperties().put("xDiameter", xRadius);
    ellp.getProperties().put("yDiameter", yRadius);
    }

  public Shape Shape () {
    return ellp;
  }

}

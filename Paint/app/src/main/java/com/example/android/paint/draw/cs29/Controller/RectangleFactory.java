package eg.edu.alexu.csd.oop.draw.cs29.Controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.*;

public class RectangleFactory implements MouseDraw {
  
  private Rectangle rec = new Rectangle();

  @Override
  public void mousePressedFun(MouseEvent e) {
    rec = new Rectangle();
//    rec.setFillColor(Color.black);
//    rec.setColor(Color.black);
    rec.setPosition(e.getPoint());
    rec.getProperties().put("height", 0.0);
    rec.getProperties().put("width", 0.0);
  }

  @Override
  public void mouseReleasedFun(MouseEvent e, DrawingEngine drawEngine) {
    double height = Math.abs(e.getY() - rec.getPosition().getY());
    double width = Math.abs(e.getX() - rec.getPosition().getX());
    rec.getProperties().put("height", height);
    rec.getProperties().put("width", width);  
    drawEngine.addShape(rec);
  }

  @Override
  public void mouseDraggedFun(MouseEvent e) {
    double height = Math.abs(e.getY() - rec.getPosition().getY());
    double width = Math.abs(e.getX() - rec.getPosition().getX());
    rec.getProperties().put("height", height);
    rec.getProperties().put("width", width);    
  }

  public Shape Shape () {
    return rec;
  }
  
}

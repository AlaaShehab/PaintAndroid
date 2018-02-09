package eg.edu.alexu.csd.oop.draw.cs29.Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.*;

public class LineFactory implements MouseDraw{
  
  private LineSegment line = new LineSegment();

  @Override
  public void mousePressedFun(MouseEvent e) {
    line = new LineSegment();
    line.setPosition(e.getPoint());
    line.setColor(Color.black);
    line.setFillColor(Color.black);
    line.getProperties().put("pointx", (double) e.getX());
    line.getProperties().put("pointy", (double) e.getY());    
  }

  @Override
  public void mouseReleasedFun(MouseEvent e, DrawingEngine drawEngine) {
    line.getProperties().put("pointx", (double) e.getX());
    line.getProperties().put("pointy", (double) e.getY()); 
    drawEngine.addShape(line);
  }

  @Override
  public void mouseDraggedFun(MouseEvent e) {
    line.getProperties().put("pointx", (double) e.getX());
    line.getProperties().put("pointy", (double) e.getY());    
  }

  @Override
  public Shape Shape() {
    return line;
  }

}

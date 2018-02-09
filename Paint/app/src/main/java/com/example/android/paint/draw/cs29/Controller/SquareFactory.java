package eg.edu.alexu.csd.oop.draw.cs29.Controller;

import java.awt.event.MouseEvent;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.*;


public class SquareFactory implements MouseDraw{

  private Square sqr = new Square();

  @Override
  public void mousePressedFun(MouseEvent e) {
    sqr = new Square();
    sqr.setPosition(e.getPoint());
    sqr.getProperties().put("length", 0.0);    
  }

  @Override
  public void mouseReleasedFun(MouseEvent e, DrawingEngine drawEngine) {

    double length =Math.abs(e.getX()- sqr.getPosition().getX());
    sqr.getProperties().put("length", length);   
    drawEngine.addShape(sqr);
  }

  @Override
  public void mouseDraggedFun(MouseEvent e) {
    double length = Math.sqrt((Math.pow(e.getPoint().distance(sqr.getPosition()), 2.0 ) / 2));
    sqr.getProperties().put("length", length);    
  }

  public Shape Shape () {
    return sqr;
  }

}

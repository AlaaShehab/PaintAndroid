package eg.edu.alexu.csd.oop.draw.cs29.Controller;

import java.awt.Color;
import java.awt.Point;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.*;
import javafx.scene.input.MouseEvent;

public class CircleFactory implements MouseDraw {

  private Circle cicl = new Circle();

  public void mousePressedFun(MouseEvent e) {
    cicl = new Circle();
    cicl.setPosition(new Point((int) e.getX(), (int) e.getY())); // java fx 3D missing Z axe HA HA
                                                                 // HA 7anelbess!!!
    cicl.setColor(Color.BLACK);
    cicl.setFillColor(Color.BLACK);
    cicl.getProperties().put("Diameter", 50.0);
  }

  public void mouseReleasedFun(MouseEvent e, DrawingEngine drawEngine) {

    double radius = new Point(
        (int) e.getX(),
        (int) e.getY()).distance(cicl.getPosition());
    cicl.getProperties().put("Diameter", radius);
    drawEngine.addShape(cicl); // added by youmna

  }

  public void mouseDraggedFun(MouseEvent e) {
    double radius = new Point(
        (int) e.getX(),
        (int) e.getY()).distance(cicl.getPosition());
    cicl.getProperties().put("Diameter", radius);
  }
  /**
   * @return shape
   */
  public Shape shape() {
    return cicl;
  }

}

package eg.edu.alexu.csd.oop.draw.cs29.Controller;


import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;
import javafx.scene.input.MouseEvent;

public interface MouseDraw {
  public void mousePressedFun(MouseEvent e);
  
  public void mouseReleasedFun(MouseEvent e, DrawingEngine drawEngine);
  
  public void mouseDraggedFun(MouseEvent e);

  public Shape Shape();
}

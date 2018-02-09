package eg.edu.alexu.csd.oop.draw.cs29.Controller;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes.*;
import eg.edu.alexu.csd.oop.draw.cs29.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.cs29.Controller.MainFactory;
import eg.edu.alexu.csd.oop.draw.cs29.view.DrawGUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class MainController extends JFrame implements EventHandler<ActionEvent> {

  String selected = new String();
  MainFactory factory = new MainFactory();
  DrawingEngine drawEngine;
  DrawGUI GUI;
  private fgh graphicsD;

  

  public MainController(DrawGUI gui, DrawingEngine draw) {
    drawEngine = draw;
    GUI = gui;
    GraphicsContext gc = GUI.canvas.getGraphicsContext2D();
    GUI.canvas.setOnMouseClicked(e ->{MainController.this.mousePressed(e);});
    graphicsD = new fgh(gc);
    gui.btnCircle.setOnAction(this);
    gui.btnEllipse.setOnAction(this);
    gui.btnLine.setOnAction(this);
    gui.btnRectangle.setOnAction(this);
    gui.btnSquare.setOnAction(this);
    gui.btnTriangle90.setOnAction(this);
    gui.btnTriangleEqual.setOnAction(this);
    gui.btnDelete.setOnAction(this);
    gui.btnResize.setOnAction(this);
    gui.btnUndo.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        drawEngine.undo();
      }
    });
    gui.btnRedo.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        drawEngine.redo();
      }
    });
    gui.btnSave.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        drawEngine.save("/Saved.txt");
      }
    });
    gui.btnLoad.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        drawEngine.load("/Saved.txt");
      }
    });

  }

  private void mousePressed(MouseEvent e) {
    selected = "Circle";
    if (factory.makeFactory(selected) != null) {
      factory.makeFactory(selected).mousePressedFun(e);
      repaint();

    } else {
      
    }

  }

  @Override
  public void handle(ActionEvent event) {

    selected = event.getSource().getClass().getSimpleName();
    // CheckSelected();

  }

  private MouseListener mouseHandler = new MouseAdapter() {

    public void mouseClicked(MouseEvent e) {
       mousePressed(e);
      for (Shape element : drawEngine.listOfShapes) {

//        if (element.contains(new Point((int)e.getX(), (int)e.getY()))) {
//          drawEngine.removeShape(element);; // function shape contains point
//        }
      }

    }

    public void mouseReleased(MouseEvent e) {
      selected = "Circle";
      System.out.println("from mouseReleased");
      if (factory.makeFactory(selected) != null) {
        factory.makeFactory(selected).mouseReleasedFun(e, drawEngine);
        repaint();

      } else {
        
      }
    }

    public void mousePressed(MouseEvent e) {
      selected = "Circle";
      if (factory.makeFactory(selected) != null) {
        factory.makeFactory(selected).mousePressedFun(e);
        repaint();

      } else {
        
      }

    }
  };

  public MouseMotionListener mouseMotionHandler = new MouseMotionAdapter() {
    public void mouseDragged(MouseEvent e) {
      makeSelections(e);
    }

    private void makeSelections(MouseEvent e) {
      selected = "Circle";
      if (factory.makeFactory(selected) != null) {
        factory.makeFactory(selected).mouseDraggedFun(e);
        repaint();
        }
//      } else {
//        CheckDetailsEditing(e);
//      }
    }
    
  };

//  private void CheckDetailsEditingPress(MouseEvent e) {
//
//    if (e.getSource().getClass().getSimpleName().equals("Delete")) {
//
//      CheckShapesBoundries(e);
//
//    }
//
//  }
//
//  private void CheckShapesBoundries(MouseEvent e) {
//    String Name = e.getSource().getClass().getSimpleName();
//
//    for (Shape element : drawEngine.listOfShapes) {
//
//      if (element.contains( new Point((int)e.getX(), (int)e.getY()))) {
//        if (Name.equals("move")) {
//
//        }
//
//      }
//    }
//
//  }

//  public void move(MouseEvent e, Shape shape) {
//
//    Double dx = e.getX() - shape.getPosition().getX();
//    Double dy = e.getY() - shape.getPosition().getX();
//
//    shape.setPosition(new Point((int) (shape.getPosition().x + dx), (int) (shape.getPosition().getY() + dy)));
//
//  }

  public void paint(Graphics gr) {
    super.paint(gr);
    factory.makeFactory(selected).Shape().draw(gr);
    drawEngine.refresh(graphicsD);
  }

  

  
}



//
// private void CheckSelected() {
//
//
//
// }
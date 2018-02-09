package eg.edu.alexu.csd.oop.draw.cs29.Controller;

import eg.edu.alexu.csd.oop.draw.cs29.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.cs29.view.DrawGUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
  
public static void main (String[] args){
    
    launch(args);
    
  }

public void start(Stage window) {
  DrawGUI gui = new DrawGUI();
  MainController view = new MainController(gui, new DrawingEngine());
  window.setScene(gui.scene);
  window.show();
  
}
  
}

package com.example.android.paint.draw;

import android.graphics.Canvas;

public interface DrawingEngine {
  
  void addShape(Shape shape);
  void removeShape(Shape shape);
  void updateShape(Shape oldShape, Shape newShape);
  
  /* return the created shapes objects */
  Shape[] getShapes();

  /* limited to 20 steps. You consider these actions in
  * undo & redo: addShape, removeShape, updateShape */
  boolean undo();
  boolean redo();
  
  /* use the file extension to determine the type,
  * or throw runtime exception when unexpected extension */
  void save(String path);
  void load(String path);
}
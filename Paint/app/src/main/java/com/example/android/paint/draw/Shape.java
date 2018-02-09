package com.example.android.paint.draw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;

public interface Shape extends Cloneable {
  
  public void setPosition(Point position);
  
  public Point getPosition();
  
  /* update shape specific properties (e.g., radius) */
  public void setProperties(java.util.Map<String, Double> properties);
  public java.util.Map<String, Double> getProperties();
  
  public void setColor(Color color);
  public Color getColor();
  
  public void setFillColor(Color color);
  public Color getFillColor();
  
  /* redraw the shape on the canvas */
  public void draw(Canvas canvas);
  
  /* create a deep clone of the shape */
  public Object clone() throws CloneNotSupportedException;
}
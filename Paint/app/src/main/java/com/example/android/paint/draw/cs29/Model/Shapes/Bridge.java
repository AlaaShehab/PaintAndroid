package eg.edu.alexu.csd.oop.draw.cs29.Model.Shapes;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import javafx.scene.canvas.GraphicsContext;

public class Bridge  extends Graphics2D{
  
  GraphicsContext gc;
  public Bridge (GraphicsContext gh) {
    this.gc=gh;
    
  }
  
  @Override
  public void addRenderingHints(Map<?, ?> arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void clip(Shape arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void draw(Shape arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void drawGlyphVector(GlyphVector arg0, float arg1, float arg2) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean drawImage(Image arg0, AffineTransform arg1, ImageObserver arg2) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void drawImage(BufferedImage arg0, BufferedImageOp arg1, int arg2, int arg3) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void drawRenderableImage(RenderableImage arg0, AffineTransform arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void drawRenderedImage(RenderedImage arg0, AffineTransform arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void drawString(String arg0, int arg1, int arg2) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void drawString(String arg0, float arg1, float arg2) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void drawString(AttributedCharacterIterator arg0, int arg1, int arg2) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void drawString(AttributedCharacterIterator arg0, float arg1, float arg2) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void fill(Shape arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Color getBackground() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Composite getComposite() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GraphicsConfiguration getDeviceConfiguration() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public FontRenderContext getFontRenderContext() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Paint getPaint() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object getRenderingHint(Key arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RenderingHints getRenderingHints() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stroke getStroke() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AffineTransform getTransform() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hit(Rectangle arg0, Shape arg1, boolean arg2) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void rotate(double arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void rotate(double arg0, double arg1, double arg2) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void scale(double arg0, double arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setBackground(Color arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setComposite(Composite arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setPaint(Paint arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setRenderingHint(Key arg0, Object arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setRenderingHints(Map<?, ?> arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setStroke(Stroke arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setTransform(AffineTransform arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void shear(double arg0, double arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void transform(AffineTransform arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void translate(int arg0, int arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void translate(double arg0, double arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void clearRect(int arg0, int arg1, int arg2, int arg3) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void clipRect(int arg0, int arg1, int arg2, int arg3) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void copyArea(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Graphics create() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void drawArc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
    this.gc.strokeArc(arg0, arg1, arg2, arg3, arg4, arg5, null);
  }

  @Override
  public boolean drawImage(Image arg0, int arg1, int arg2, ImageObserver arg3) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean drawImage(Image arg0, int arg1, int arg2, Color arg3, ImageObserver arg4) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, ImageObserver arg5) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, Color arg5,
      ImageObserver arg6) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6,
      int arg7, int arg8, ImageObserver arg9) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean drawImage(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6,
      int arg7, int arg8, Color arg9, ImageObserver arg10) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void drawLine(int arg0, int arg1, int arg2, int arg3) {
    this.gc.strokeLine(arg0, arg1, arg2, arg3);
  }

  @Override
  public void drawOval(int arg0, int arg1, int arg2, int arg3) {
    this.gc.strokeOval(arg0, arg1, arg2, arg3);
  }

  @Override
  public void drawPolygon(int[] arg0, int[] arg1, int arg2) {
    double[] xPoints = new double[arg2];
    double[] yPoints = new double[arg2];
    
    for(int i = 0 ; i < arg2 ; i++)
    {
      xPoints[i] = arg0[i];
      yPoints[i] = arg1[i];
    }
    this.gc.strokePolygon(xPoints, yPoints, arg2);
  }

  @Override
  public void drawPolyline(int[] arg0, int[] arg1, int arg2) {
    double[] xPoints = new double[arg2];
    double[] yPoints = new double[arg2];
    
    for(int i = 0 ; i < arg2 ; i++)
    {
      xPoints[i] = arg0[i];
      yPoints[i] = arg1[i];
    }
    this.gc.strokePolygon(xPoints, yPoints, arg2);    
  }

  @Override
  public void drawRoundRect(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
    this.gc.strokeRoundRect(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  @Override
  public void fillArc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
    this.gc.arc(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  @Override
  public void fillOval(int arg0, int arg1, int arg2, int arg3) {
    this.gc.fillOval(arg0, arg1, arg2, arg3);
  }

  @Override
  public void fillPolygon(int[] arg0, int[] arg1, int arg2) {
    
    double[] xPoints = new double[arg2];
    double[] yPoints = new double[arg2];
    
    for(int i = 0 ; i < arg2 ; i++)
    {
      xPoints[i] = arg0[i];
      yPoints[i] = arg1[i];
    }
    
    this.gc.fillPolygon(xPoints, yPoints, arg2);
    
  }

  @Override
  public void fillRect(int arg0, int arg1, int arg2, int arg3) {
    this.gc.rect(arg0, arg1, arg2, arg3);
  }

  @Override
  public void fillRoundRect(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
      this.gc.fillRoundRect(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  @Override
  public Shape getClip() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Rectangle getClipBounds() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Color getColor() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Font getFont() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public FontMetrics getFontMetrics(Font arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setClip(Shape arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setClip(int arg0, int arg1, int arg2, int arg3) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setColor(Color arg0) {
    javafx.scene.paint.Color fxColor = javafx.scene.paint.Color.rgb(arg0.getRed(), arg0.getGreen(), arg0.getBlue(), arg0.getAlpha() / 255.0);
    gc.setFill(fxColor);
    gc.setStroke(fxColor);    
  }

  @Override
  public void setFont(Font arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setPaintMode() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setXORMode(Color arg0) {
    // TODO Auto-generated method stub
    
  }

}

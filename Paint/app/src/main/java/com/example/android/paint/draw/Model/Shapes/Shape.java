package com.example.android.paint.draw.Model.Shapes;

import android.graphics.Color;
import android.graphics.Point;

import java.util.Map;
/**
 * @author saraheldafrawy.
 */
public abstract class Shape implements com.example.android.paint.draw.Shape {
  /** static zero. */
	private static final double ZERODEFAULT = 0.0;
  /** Shape position usually set to center. */
  private Point pt;
  /** Shape constructor. */
  private Map<String, Double> map;
  /** Shape constructor. */
  private Color clrFill, clrBorder;

  /** Shape constructor. */
  public Shape() {
    pt = new Point();
  }

  /** @return static zero. */
  public final double getZerodefault() {
    return ZERODEFAULT;
  }


	 /** update shape position. */
	@Override
	public final void setPosition(final Point position) {
		this.pt = position;
	}
  /** @return shape position. */
	@Override
	public final Point getPosition() {
		return pt;
	}
	/** update shape specific properties (e.g., radius). */
	@Override
	public final void setProperties(final Map<String, Double> properties) {
		this.map = properties;
	}
  /** @return shape specific properties (e.g., radius). */
	@Override
	public final Map<String, Double> getProperties() {
		return this.map;
	}
	/** update shape color. */
	@Override
	public final void setColor(final Color color) {
		this.clrBorder = color;
	}
  /** @return shape specific color. */
	@Override
	public final Color getColor() {
		return this.clrBorder;
	}
  /** update shape fill color. */
	@Override
	public final void setFillColor(final Color color) {
		this.clrFill = color;
	}
  /** @return shape specific fill color. */
	@Override
	public final Color getFillColor() {
		return this.clrFill;
	}

	/** create a deep clone of the shape.
	 * @throws CloneNotSupportedException exception if clone fails
	 * @return cloned shape
	 */
	public abstract Object clone() throws CloneNotSupportedException;

}

package com.example.android.paint.draw.Model.Shapes;

import android.graphics.Canvas;

import java.util.HashMap;
import java.util.Map;
/**
 * @author saraheldafrawy.
 */
public class Triangle extends Shape {

  /** number of points. */
	private static final int NUMOFPOINTS = 3;
  /** array of x points. */
	private int[] xPoints;
  /** array of y points. */
	private int[] yPoints;

	/**
	 * constructor.
	 */
	public Triangle() {
	  Map map = new HashMap<>();
    this.setProperties(map);
    this.getProperties().put("point0x", this.getZerodefault());
		this.getProperties().put("point0y", this.getZerodefault());
		this.getProperties().put("point1x", this.getZerodefault());
		this.getProperties().put("point1y", this.getZerodefault());
		this.getProperties().put("point2x", this.getZerodefault());
		this.getProperties().put("point2y", this.getZerodefault());
		xPoints = new int[NUMOFPOINTS];
		yPoints = new int[NUMOFPOINTS];

	}
	/**
	 * draw function.
	 */
	@Override
	public final void draw(final Canvas canvas) {
		//TODO draw function
//		canvas.setColor(this.getFillColor());
//		for (int i = 0; i < xPoints.length; i++) {
//			xPoints[i] = this.getProperties()
//			    .get("point" + i + "x").intValue();
//		}
//		((Graphics2D) canvas).setColor(this.getFillColor());
//		for (int i = 0; i < yPoints.length; i++) {
//			yPoints[i] = this.getProperties()
//			    .get("point" + i + "y").intValue();
//		}
//		canvas.fillPolygon(xPoints, yPoints, NUMOFPOINTS);
//		((Graphics2D) canvas).setStroke(new java.awt.BasicStroke(2));
//    ((Graphics2D) canvas).setColor(this.getColor());
//    ((Graphics2D) canvas).drawPolygon(xPoints, yPoints, NUMOFPOINTS);
	}
	/**
	 * creates deep clone from shape.
	 */
	@Override
	public final Object clone() throws CloneNotSupportedException {
		//TODO check clone function if correct
		Shape clonedShape = new Triangle();
		clonedShape.setColor(this.getColor());
		clonedShape.setFillColor(this.getFillColor());
		clonedShape.setPosition(this.getPosition());
		Map<String, Double> newMap = new HashMap<>();
		for (Map.Entry<String, Double> element
		    : this.getProperties().entrySet()) {
			newMap.put(element.getKey(), element.getValue());
		}
		clonedShape.setProperties(newMap);
		return clonedShape;
	}
}

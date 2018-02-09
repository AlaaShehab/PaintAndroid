package com.example.android.paint.draw.cs29.Model.Shapes;

import android.graphics.Canvas;

import java.util.HashMap;
import java.util.Map;
/**
 * @author saraheldafrawy.
 */
public class Ellipse extends Shape {
/**
 * constructor.
 */
	public Ellipse() {
		super();
		Map map = new HashMap<>();
    this.setProperties(map);
    this.getProperties().put("xDiameter", this.getZerodefault());
		this.getProperties().put("yDiameter", this.getZerodefault());
	}

	/** pt is the Top left of the rectangle. */
	/** redraw the shape on the canvas. */
	@Override
	public final void draw(final Canvas canvas) {
		//TODO draw function
//		((Graphics2D) canvas).setColor(this.getFillColor());
//		((Graphics2D) canvas).fillRoundRect(
//		    (int) this.getPosition().getX()
//		    - (this.getProperties().get("xDiameter").intValue() / 2),
//		    (int) this.getPosition().getY()
//		    - (this.getProperties().get("yDiameter").intValue() / 2),
//		    this.getProperties().get("xDiameter").intValue(),
//		    this.getProperties().get("yDiameter").intValue(),
//		    this.getProperties().get("xDiameter").intValue(),
//		    this.getProperties().get("yDiameter").intValue());
//		((Graphics2D) canvas).setStroke(new java.awt.BasicStroke(2));
//		((Graphics2D) canvas).setColor(this.getColor());
//    ((Graphics2D) canvas).drawRoundRect(
//        (int) this.getPosition().getX()
//        - (this.getProperties().get("xDiameter").intValue() / 2),
//        (int) this.getPosition().getY()
//        - (this.getProperties().get("yDiameter").intValue() / 2),
//        this.getProperties().get("xDiameter").intValue(),
//        this.getProperties().get("yDiameter").intValue(),
//        this.getProperties().get("xDiameter").intValue(),
//        this.getProperties().get("yDiameter").intValue());
	}
	/**
	 * creates a deep clone of the shape.
	 */
	@Override
	public final Object clone() throws CloneNotSupportedException {
		//TODO check clone function if correct

		Shape clonedShape = new Ellipse();
		clonedShape.setPosition(this.getPosition());
		clonedShape.setColor(this.getColor());
		clonedShape.setFillColor(this.getFillColor());
		Map<String, Double> newMap = new HashMap<>();
		for (Map.Entry<String, Double> element
		    : this.getProperties().entrySet()) {
			newMap.put(element.getKey(), element.getValue());
		}
		clonedShape.setProperties(newMap);
		return clonedShape;
	}

}


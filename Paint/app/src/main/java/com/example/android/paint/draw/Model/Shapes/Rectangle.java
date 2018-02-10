package com.example.android.paint.draw.Model.Shapes;

import android.graphics.Canvas;

import java.util.HashMap;
import java.util.Map;
/**
 * @author saraheldafrawy.
 */
public class Rectangle extends Shape {
/** Constructor. */
	public Rectangle() {
		super();
		Map map = new HashMap<>();
    this.setProperties(map);
    this.getProperties().put("width", this.getZerodefault());
		this.getProperties().put("height", this.getZerodefault());
	}

	/** pt is the Top left of the rectangle. */
	@Override
	public final void draw(final Canvas canvas) {
		//TODO draw function
//		((Graphics2D) canvas).setColor(this.getFillColor());
//		((Graphics2D) canvas).fillRect(
//		    (int) this.getPosition().getX(),
//		    (int) this.getPosition().getY(),
//		    this.getProperties().get("width").intValue(),
//		    this.getProperties().get("height").intValue());
//		((Graphics2D) canvas).setStroke(new java.awt.BasicStroke(2));
//		((Graphics2D) canvas).setColor(this.getColor());
//    ((Graphics2D) canvas).drawRect(
//        (int) this.getPosition().getX(), (int) this.getPosition().getY(),
//        this.getProperties().get("width").intValue(),
//        this.getProperties().get("height").intValue());

	}
	/** creates deep clone from shape.*/
	@Override
	public final Object clone() throws CloneNotSupportedException {
		//TODO check clone function if correct
		Shape clonedShape = new Rectangle();
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
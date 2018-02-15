package com.example.android.paint.draw.Model.Shapes;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.HashMap;
import java.util.Map;
/**
 * @author saraheldafrawy.
 */
public class Square extends Shape {

  /** constructor. */
	 public Square() {
		super();
		Map map = new HashMap<>();
    this.setProperties(map);
    this.getProperties().put("length", this.getZerodefault());
	}
	/** pt is the Top left of the square. */
	@Override
	public final void draw(final Canvas canvas, Paint paint) {
		canvas.drawRect(this.getPosition().x,this.getPosition().y,
				this.getProperties().get("length").floatValue(),
				this.getProperties().get("length").floatValue(),paint);
	}
	/** creates a deep clone from shape.*/
	@Override
	public final Object clone() throws CloneNotSupportedException {
		//TODO check clone function if correct
		Shape clonedShape = new Square();
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

package com.example.android.paint.draw.Model.Shapes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;

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
    this.getProperties().put("xRadius", this.getZerodefault());
		this.getProperties().put("yRadius", this.getZerodefault());
	}

	/** pt is the Top left of the rectangle. */
	/** redraw the shape on the canvas. */
	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	@Override
	public final void draw(Canvas canvas, Paint paint) {
		canvas.drawOval(this.getPosition().x
						- (this.getProperties().get("xRadius").intValue()),
				(int) this.getPosition().y
						- (this.getProperties().get("yRadius").intValue()),
				this.getPosition().x
						+ (this.getProperties().get("xRadius").intValue()),
				(int) this.getPosition().y
						+ (this.getProperties().get("yRadius").intValue()), paint);

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


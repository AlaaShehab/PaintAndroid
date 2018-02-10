package com.example.android.paint.draw.Model.Shapes;

import android.graphics.Canvas;

import java.util.HashMap;
import java.util.Map;
/**
 * @author saraheldafrawy.
 */
public class Path extends Shape {

    /**
     * constructor.
     */
    public Path() {
        //TODO Path properties
        super();
        Map map = new HashMap<>();
        this.setProperties(map);
//        this.getProperties().put("Diameter", this.getZerodefault());
    }
    /* pt is the Top left of the rectangle */
	/* redraw the shape on the canvas */
    @Override
    public final void draw(final Canvas canvas) {
        //TODO draw function
//		int diameter = this.getProperties().get("Diameter").intValue();
//		((Graphics2D) canvas).setColor(this.getFillColor());
//		((Graphics2D) canvas).fillRoundRect(
//		    (int) this.getPosition().getX()
//		    - (this.getProperties().get("Diameter").intValue() / 2),
//		    (int) this.getPosition().getY()
//		    - (this.getProperties().get("Diameter").intValue() / 2),
//				diameter, diameter, diameter, diameter);
//		((Graphics2D) canvas).setStroke(new java.awt.BasicStroke(2));
//		((Graphics2D) canvas).setColor(this.getColor());
//    ((Graphics2D) canvas).drawRoundRect(
//        (int) this.getPosition().getX()
//        - (this.getProperties().get("Diameer").intValue() / 2),
//        (int) this.getPosition().getY()
//        - (this.getProperties().get("Diameter").intValue() / 2),
//        diameter, diameter, diameter, diameter);
    }
    /**
     * creates a deep clone from the shape.
     */
    @Override
    public final Object clone() throws CloneNotSupportedException {
        //TODO check clone function if correct
        //TODO check if it is correct for Path

        Shape clonedShape = new Path();
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

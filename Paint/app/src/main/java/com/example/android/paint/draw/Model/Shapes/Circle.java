package com.example.android.paint.draw.Model.Shapes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * @author saraheldafrawy.
 */
public class Circle extends Shape {

    /**
     * constructor.
     */
    public Circle() {
        super();
        Map map = new HashMap<>();
        this.setProperties(map);
        this.getProperties().put("Radius", this.getZerodefault());
    }

    /* pt is the Top left of the rectangle */
    /* redraw the shape on the canvas */
    @Override
    public final void draw(Canvas canvas, Paint paint) {
        canvas.drawCircle(
                this.getPosition().x, this.getPosition().y,
                getProperties().get("Radius").intValue(),
                paint);
    }

    /**
     * creates a deep clone from the shape.
     */
    @Override
    public final Object clone() throws CloneNotSupportedException {
        //TODO check clone function if correct
        Shape clonedShape = new Circle();
        clonedShape.setPosition(this.getPosition());
        clonedShape.setPaint(this.getPaint());
        Map<String, Double> newMap = new HashMap<>();
        for (Map.Entry<String, Double> element
                : this.getProperties().entrySet()) {
            newMap.put(element.getKey(), element.getValue());
        }
        clonedShape.setProperties(newMap);
        return clonedShape;
    }

}

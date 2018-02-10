package com.example.android.paint.draw.Model.Shapes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import java.util.HashMap;
import java.util.Map;
/**
 * @author saraheldafrawy.
 */
public class PathShape extends Shape {

    private Path path;
    /**
     * constructor.
     */
    public PathShape() {
        //TODO Path properties
        super();
        path = new Path();
        Map map = new HashMap<>();
        this.setProperties(map);
    }
    /* pt is the Top left of the rectangle */
	/* redraw the shape on the canvas */
    @Override
    public final void draw(final Canvas canvas, Paint paint) {
        //TODO draw function
        canvas.drawPath(this.path, paint);
    }
    /**
     * creates a deep clone from the shape.
     */
    @Override
    public final Object clone() throws CloneNotSupportedException {
        //TODO check clone function if correct
        //TODO check if it is correct for Path

        Shape clonedShape = new PathShape();
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

    //Path Function
    public Path getPath() {
        return this.path;
    }

}

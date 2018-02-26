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
        super();
        this.path = new Path();
        Map map = new HashMap<>();
        map.put("path",this.path);
        this.setProperties(map);
    }
    /* pt is the Top left of the rectangle */
	/* redraw the shape on the canvas */
    @Override
    public final void draw(final Canvas canvas, Paint paint) {
        canvas.drawPath(this.path, paint);
    }
    /**
     * creates a deep clone from the shape.
     */
    @Override
    public final Object clone() throws CloneNotSupportedException {
        PathShape clonedShape = new PathShape();
        clonedShape.setPath(this.path);
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

    public void setPath(Path path) {
        this.path = path;
    }
}

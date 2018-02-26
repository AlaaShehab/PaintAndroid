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
    }
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

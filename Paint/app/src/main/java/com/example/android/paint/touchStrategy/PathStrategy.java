package com.example.android.paint.touchStrategy;

import android.graphics.Path;
import android.graphics.Point;

import com.example.android.paint.draw.Model.Shapes.PathShape;
import com.example.android.paint.draw.Shape;

/**
 * Created by saraheldafrawy on 09/02/18.
 */

public class PathStrategy implements TouchStrategy {

    @Override
    public void actionDown(Shape shapeInUse, Point pt) {
        //TODO implement method
        Path path = ((PathShape)shapeInUse).getPath();
        path.moveTo(pt.x, pt.y);
    }

    @Override
    public void actionMove(Shape shapeInUse, Point pt) {
        //TODO implement method
        Path path = ((PathShape)shapeInUse).getPath();
        path.lineTo(pt.x, pt.y);
    }

    @Override
    public void actionUp(Shape shapeInUse, Point pt) {
        //TODO implement method
        Path path = ((PathShape)shapeInUse).getPath();
        path.lineTo(pt.x, pt.y);
    }
}

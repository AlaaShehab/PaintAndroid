package com.example.android.paint.touchStrategy;

import android.graphics.Point;

import com.example.android.paint.draw.Shape;

/**
 * Created by saraheldafrawy on 09/02/18.
 */

public interface TouchStrategy {

    void actionDown(Shape shapeInUse, Point pt);
    void actionMove(Shape shapeInUse, Point pt);
    void actionUp(Shape shapeInUse, Point pt);


}

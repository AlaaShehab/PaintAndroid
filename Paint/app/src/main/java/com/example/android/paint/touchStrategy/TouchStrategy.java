package com.example.android.paint.touchStrategy;

import com.example.android.paint.draw.Shape;

/**
 * Created by saraheldafrawy on 09/02/18.
 */

public interface TouchStrategy {

    void actionDown(Shape shapeInUse);
    void actionMove(Shape shapeInUse);
    void actionUp(Shape shapeInUse);


}

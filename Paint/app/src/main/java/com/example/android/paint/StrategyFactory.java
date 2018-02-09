package com.example.android.paint;

import com.example.android.paint.touchStrategy.CircleStrategy;
import com.example.android.paint.touchStrategy.EllipseStrategy;
import com.example.android.paint.touchStrategy.PathStrategy;
import com.example.android.paint.touchStrategy.RectangleStrategy;
import com.example.android.paint.touchStrategy.SquareStrategy;
import com.example.android.paint.touchStrategy.TouchStrategy;
import com.example.android.paint.touchStrategy.TriangleStrategy;

/**
 * Created by saraheldafrawy on 09/02/18.
 */

public class StrategyFactory {

    public static TouchStrategy getStrategy(String buttonSelected) {
        if (buttonSelected.equals("circle")) {
            return new CircleStrategy();
        } else if (buttonSelected.equals("square")) {
            return new SquareStrategy();
        } else if (buttonSelected.equals("triangle")) {
            return new TriangleStrategy();
        } else if (buttonSelected.equals("rectangle")) {
            return new RectangleStrategy();
        } else if (buttonSelected.equals("ellipse")) {
            return new EllipseStrategy();
        } else if (buttonSelected.equals("path")) {
            return new PathStrategy();
        } else {
            return null;
        }
    }
}

package com.example.android.paint;

import android.content.Context;

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

    public static TouchStrategy getStrategy(Context context, String buttonSelected) {
        if (buttonSelected.equals(context.getString(R.string.circle))) {
            return new CircleStrategy();
        } else if (buttonSelected.equals(context.getString(R.string.square))) {
            return new SquareStrategy();
        } else if (buttonSelected.equals(context.getString(R.string.triangle))) {
            return new TriangleStrategy();
        } else if (buttonSelected.equals(context.getString(R.string.rectangle))) {
            return new RectangleStrategy();
        } else if (buttonSelected.equals(context.getString(R.string.ellipse))) {
            return new EllipseStrategy();
        } else if (buttonSelected.equals(context.getString(R.string.path))) {
            return new PathStrategy();
        } else {
            return null;
        }
    }
}

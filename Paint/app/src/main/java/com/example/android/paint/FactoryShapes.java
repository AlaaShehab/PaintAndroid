package com.example.android.paint;

import android.content.Context;

import com.example.android.paint.draw.Shape;
import com.example.android.paint.draw.Model.Shapes.Circle;
import com.example.android.paint.draw.Model.Shapes.Ellipse;
import com.example.android.paint.draw.Model.Shapes.PathShape;
import com.example.android.paint.draw.Model.Shapes.Rectangle;
import com.example.android.paint.draw.Model.Shapes.Square;
import com.example.android.paint.draw.Model.Shapes.Triangle;

/**
 * Created by Personal on 2/8/2018.
 */

public class FactoryShapes {

    public static Shape getShape(Context context, String buttonSelected) {

        if (buttonSelected.equals(context.getString(R.string.circle))) {
            return new Circle();
        } else if (buttonSelected.equals(context.getString(R.string.square))) {
            return new Square();
        } else if (buttonSelected.equals(context.getString(R.string.triangle))) {
            return new Triangle();
        } else if (buttonSelected.equals(context.getString(R.string.rectangle))) {
            return new Rectangle();
        } else if (buttonSelected.equals(context.getString(R.string.ellipse))) {
            return new Ellipse();
        } else if (buttonSelected.equals(context.getString(R.string.path))) {
            return new PathShape();
        } else {
            return null;
        }

    }

}

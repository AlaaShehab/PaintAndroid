package com.example.android.paint;

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

    //TODO return new shape <Completed I think>;

    public static Shape getShape(String buttonSelected) {

        if (buttonSelected.equals("circle")) {
            return new Circle();
        } else if (buttonSelected.equals("square")) {
            return new Square();
        } else if (buttonSelected.equals("triangle")) {
            return new Triangle();
        } else if (buttonSelected.equals("rectangle")) {
            return new Rectangle();
        } else if (buttonSelected.equals("ellipse")) {
            return new Ellipse();
        } else if (buttonSelected.equals("path")) {
            return new PathShape();
        } else {
            return null;
        }

    }

}

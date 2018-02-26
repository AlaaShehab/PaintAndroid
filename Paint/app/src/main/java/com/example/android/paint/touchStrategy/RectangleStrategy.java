package com.example.android.paint.touchStrategy;

import android.graphics.Point;

import com.example.android.paint.draw.Shape;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by saraheldafrawy on 09/02/18.
 */

public class RectangleStrategy implements TouchStrategy {
    @Override
    public void actionDown(Shape shapeInUse, Point pt) {
        shapeInUse.setPosition(pt);
    }

    @Override
    public void actionMove(Shape shapeInUse, Point pt) {
        Map<String, Double> map = new HashMap<>();
        map.put("width",
                (double)pt.x);
        map.put("height",
                (double) pt.y);
        //TODO key maps in strings
        shapeInUse.setProperties(map);
    }

    @Override
    public void actionUp(Shape shapeInUse, Point pt) {
        Map<String, Double> map = new HashMap<>();
        map.put("width",
                (double)pt.x);
        map.put("height",
                (double)pt.y);
        shapeInUse.setProperties(map);
    }
}

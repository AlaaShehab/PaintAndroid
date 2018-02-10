package com.example.android.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.example.android.paint.draw.Shape;
import com.example.android.paint.touchStrategy.TouchStrategy;

/**
 * Created by Alaa on 2/8/2018.
 */

public class CanvasView extends View {
    private Bitmap bitmap;
    private Paint paint;
    private Canvas canvas;
    private Shape shapeInUse;

    public CanvasView(Context context) {
        super(context);
        setupView ();
        ((MainActivity)context).setDrawingCanvas(canvas);
    }

    public void setupView () {
//        TODO check other methods as paint.attributes
//        TODO check rest of the setups in link
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //TODO cache for canvas (bitmap)
        shapeInUse.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //TODO total imlplementaion <Completed I think>
        //TODO rest of touch events (resize, delete, select, etc)
        String buttonSelected = ((MainActivity)getContext()).getBtnSelected();
        shapeInUse = FactoryShapes.getShape(buttonSelected);
        TouchStrategy strategy = StrategyFactory.getStrategy(buttonSelected);
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                strategy.actionDown(shapeInUse);
                break;
            case MotionEvent.ACTION_MOVE:
                strategy.actionMove(shapeInUse);
                break;
            case MotionEvent.ACTION_UP:
                strategy.actionUp(shapeInUse);
                //TODO set cache bitmap
                //TODO add shape to DrawingEngine
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}


//TODOs
//TODO if shapeInUse null donc, 3amalna select
//TODO select btn set it by null after each event

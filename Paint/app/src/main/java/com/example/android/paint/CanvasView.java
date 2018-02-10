package com.example.android.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.android.paint.draw.Shape;
import com.example.android.paint.touchStrategy.TouchStrategy;

import java.util.List;

/**
 * Created by Alaa on 2/8/2018.
 */

public class CanvasView extends View {
    private Bitmap bitmap;
    private Paint paint;
    private Canvas canvas;
    private Shape shapeInUse;

    public CanvasView(Context context, AttributeSet sets) {
        super(context);
        setupView();
    }

    public void setupView() {
//        TODO check other methods as paint.attributes
//        TODO check rest of the setups in link
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);
        //////
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }
    public void setPaint (Paint paint) {
        this.paint = paint;
        //TODO implement it in MainActivity
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Log.e("OnSizeChange", "Hi");
        this.canvas = new Canvas(bitmap);
        canvas.save();
        ((MainActivity) getContext()).setDrawingCanvas(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (shapeInUse != null) {
            this.canvas.restore();
            shapeInUse.draw(this.canvas, paint);
            this.canvas.save();
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap,0,0,null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //TODO rest of touch events (resize, delete, select, etc)
        Point pt = new Point((int) event.getX(), (int)event.getY());
        String buttonSelected = ((MainActivity) getContext()).getBtnSelected();
        if (shapeInUse == null) {
            shapeInUse = FactoryShapes.getShape(buttonSelected);
        }
        TouchStrategy strategy = StrategyFactory.getStrategy(buttonSelected);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                strategy.actionDown(shapeInUse, pt);
                shapeInUse.setPaint(paint);
                break;
            case MotionEvent.ACTION_MOVE:
                strategy.actionMove(shapeInUse, pt);
                break;
            case MotionEvent.ACTION_UP:
                strategy.actionUp(shapeInUse, pt);
                try {
                    ((MainActivity) getContext()).addShape((Shape)shapeInUse.clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                    Log.e("CloneError", "CLONE!!!!");
                }
//                ((MainActivity) getContext()).getDrawingEngine().refresh(canvas);
                shapeInUse = null;
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }
    public void clearCanvas() {
        this.canvas.drawColor(Color.CYAN);
        invalidate();
    }
}


//TODOs
//TODO if shapeInUse null donc, 3amalna select
//TODO select btn set it by null after each event

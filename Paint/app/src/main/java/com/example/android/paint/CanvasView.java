package com.example.android.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.android.paint.draw.Shape;
import com.example.android.paint.touchStrategy.TouchStrategy;

import java.util.logging.Logger;

/**
 * Created by Alaa on 2/8/2018.
 */

public class CanvasView extends View {
    private Bitmap bitmap;
    private Paint paint;
    private Canvas canvas;
    private Shape shapeInUse;

    public CanvasView(Context context, AttributeSet sets) {
        super(context, sets);
        setupView();
    }

    public void setupView() {
//        TODO check other methods as paint.attributes
//        TODO check rest of the setups in link
        paint = new Paint();
        paint.setColor(Color.CYAN);
        paint.setStrokeWidth(4);
        //// valid only for pencil
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
        //TODO implement change in paint in MainActivity
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(bitmap);
        this.canvas.save();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0, 0, null);
        }
        if (shapeInUse != null) {
            shapeInUse.draw(canvas, paint);
        }
    }

//   todo use command pattern to perform delete or resize ...
//    and don't forget draw (two states draw and edit)
//    think chain of resposibility

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //TODO rest of touch events (resize, delete, select, etc)
        //TODO if shapeInUse null donc, 3amalna select
        //TODO select btn set it by null after each event
        Point pt = new Point((int) event.getX(), (int) event.getY());
        String buttonSelected = ((MainActivity) getContext()).getBtnSelected();
        if (shapeInUse == null) {
            shapeInUse = FactoryShapes.getShape(getContext(),buttonSelected);
        }
        TouchStrategy strategy = StrategyFactory.getStrategy(getContext(),buttonSelected);
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
                    if (shapeInUse != null) {
                        ((MainActivity) getContext()).addShape((Shape) shapeInUse.clone());
                    }
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
                shapeInUse.draw(this.canvas, paint);
                shapeInUse = null;
                break;
            default:
                return false;
        }
        invalidate();
        return true;
//        todo differentiate between drawing and editing
    }

//    @Override
//    public void setOnLongClickListener(@Nullable OnLongClickListener l) {
//        super.setOnLongClickListener(new OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                Log.e("long Click", "" + view.getPivotX());
//                Log.e("long Click", "" + view.getPivotY());
//                return true;
//            }
//        });
//    }

    public void refreshCanvas(Shape[] shapes) {
        //TODO undo not working correctly in path
        this.canvas.drawColor(Color.WHITE);
        for (int i = 0; i < shapes.length; i++) {
            //TODO shapes[i].draw(this.canvas, shape[i].getPaint);
            shapes[i].draw(this.canvas, paint);
        }
        invalidate();
    }

}

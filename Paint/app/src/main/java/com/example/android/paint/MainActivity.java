package com.example.android.paint;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.paint.draw.Model.DrawingEngine;
import com.example.android.paint.draw.Shape;

public class MainActivity extends AppCompatActivity {

    private String btnSelected;
    /**Suppose DrawingEngine a singleton**/
    private DrawingEngine drawingEngine;
    private CanvasView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawingEngine = new DrawingEngine();
        ((CanvasView)findViewById(R.id.canvas_layout)).clearCanvas();
    }

    public void setDrawingCanvas (Canvas canvas) {
//        Log.e("HI FROM SetCav", "  HI Again");
//        this.canvas = canvas;
    }

    public DrawingEngine getDrawingEngine () {
        return this.drawingEngine;
    }

    public void setBtnSelected(View view) {
//        this.btnSelected = ((Button)view).toString(); // check function
        this.btnSelected = "path";
        System.out.println(btnSelected); //for test
    }

    public void undoAction(View view) {
        Log.e("ana gowa","lessa da5el");
        drawingEngine.undo();
        Log.e("undo","3adeit undo");
//        Canvas canvas = ((CanvasView)findViewById(R.id.canvas)).getCanvas();
        //TODO undoAction
//        canvasView = (CanvasView)findViewById(R.id.canvas_layout);
          canvasView.clearCanvas();
//        canvasView.getCanvas().drawColor(Color.BLACK);
        Log.e("BLACK","BLACK to7fa");
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);
//       canvasView.getCanvas().drawCircle(200, 300, 500, paint);
        //drawingEngine.refresh(canvas);
        //Log.e("Refresh","refresh");
        //canvas.save();
        //Log.e("saved","canvas");

    }

    public void redoAction () {
        drawingEngine.redo();
        //TODO redoAction
        //clear canvas
//        drawingEngine.refresh(canvas);

    }

    public void saveAction () {
        //TODO saveAction
        //Alaa will save shapes
//        drawingEngine.save();

    }
    public void loadAction () {
        //TODO loadAction
        //clear canvas
        //Alaa will load shapes
//        drawingEngine.load();

    }

    //TODO open extra feature


    //TODO Copy, Move, Resize (Update methods in DrawingEngine)

    public String getBtnSelected() {
        return btnSelected;
    }

    public void addShape(Shape shape) {
        this.drawingEngine.addShape(shape);
    }
}

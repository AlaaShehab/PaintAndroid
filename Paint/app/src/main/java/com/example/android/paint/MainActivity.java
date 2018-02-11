package com.example.android.paint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.android.paint.draw.Model.DrawingEngine;
import com.example.android.paint.draw.Shape;

public class MainActivity extends AppCompatActivity {

    private String btnSelected;
    /**Suppose DrawingEngine a singleton**/
    private DrawingEngine drawingEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawingEngine = new DrawingEngine();
    }

    public void setBtnSelected(View view) {
//        this.btnSelected = view.getTag().toString();
        this.btnSelected = "circle";
//        this.btnSelected = "path";
        Log.e("btnSelected", btnSelected); //for test
    }

    public void undoAction(View view) {
        drawingEngine.undo();
        ((CanvasView)findViewById(R.id.canvas_layout)).refreshCanvas(drawingEngine.getShapes());
        //TODO delete refresh
    }

    public void redoAction (View view) {
        drawingEngine.redo();
        ((CanvasView)findViewById(R.id.canvas_layout)).refreshCanvas(drawingEngine.getShapes());
    }

    public void saveAction (View view) {
        //TODO saveAction
        //Alaa will save shapes
//        drawingEngine.save();

    }
    public void loadAction (View view) {
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

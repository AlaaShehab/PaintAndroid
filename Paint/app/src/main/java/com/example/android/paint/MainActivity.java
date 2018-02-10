package com.example.android.paint;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.paint.draw.Model.DrawingEngine;

public class MainActivity extends AppCompatActivity {

    private String btnSelected;
    /**Suppose DrawingEngine a singleton**/
    private DrawingEngine drawingEngine;
    private Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawingEngine = new DrawingEngine();
    }

    public void setDrawingCanvas (Canvas canvas) {
        this.canvas = canvas;
    }

    public DrawingEngine getDrawingEngine () {
        return this.drawingEngine;
    }

    public void setBtnSelected(View view) {
        this.btnSelected = ((Button)view).toString(); // check function
        System.out.println(btnSelected); //for test
    }

    public void undoAction () {
        drawingEngine.undo();
        //TODO undoAction
        //clear canvas
        drawingEngine.refresh(canvas);

    }

    public void redoAction () {
        drawingEngine.redo();
        //TODO redoAction
        //clear canvas
        drawingEngine.refresh(canvas);

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
}

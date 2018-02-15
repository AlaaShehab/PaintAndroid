package com.example.android.paint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

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

    public void removeToolbar(View view) {

        RelativeLayout mainLayout = (RelativeLayout)
                findViewById(R.id.activity_main_layout);

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        final View popupView = inflater.inflate(R.layout.popup_window, null);

        int width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        int height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height);

        popupWindow.showAtLocation(findViewById(R.id.activity_main_layout), Gravity.CENTER, 0, 0);
        popupWindow.setFocusable(true);

//       not sure of this line
        setBtnSelected(popupView);
        popupWindow.dismiss();
    }

}

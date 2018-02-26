package com.example.android.paint;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.android.paint.draw.Model.DrawingEngine;
import com.example.android.paint.draw.Shape;

import static com.example.android.paint.R.id.toolbarItems;

public class MainActivity extends AppCompatActivity {

    private String btnSelected;
    private String editBtnSelected;
    /**
     * Suppose DrawingEngine a singleton
     **/
    private DrawingEngine drawingEngine;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawingEngine = new DrawingEngine();
    }


    public void undoAction(View view) {
        if (!(drawingEngine.undo())) {
            Toast.makeText(this,"No More Steps to Undo",Toast.LENGTH_SHORT).show();
        }
        ((CanvasView) findViewById(R.id.canvas_layout)).refreshCanvas(drawingEngine.getShapes());
    }

    public void redoAction(View view) {
        if (!(drawingEngine.redo())) {
            Toast.makeText(this,"No More Steps to Redo",Toast.LENGTH_SHORT).show();
        }
        ((CanvasView) findViewById(R.id.canvas_layout)).refreshCanvas(drawingEngine.getShapes());
    }

    public void saveAction(View view) {
        //TODO saveAction
        //Alaa will save shapes
//        drawingEngine.save();

    }

    //TODO make a colorpicker using preferences

    //TODO add button for load or open (extra feature)
    public void loadAction(View view) {
        //TODO loadAction
        //clear canvas
        //Alaa will load shapes
//        drawingEngine.load();

    }

    public void shareAction(View view) {

    }

    //TODO Copy, Move, Resize (Update methods in DrawingEngine)

    public String getBtnSelected() {
        return btnSelected;
    }

    public void addShape(Shape shape) {
        this.drawingEngine.addShape(shape);
    }

    public void removeToolbar(View view) {
        LinearLayout toolbar = (LinearLayout) findViewById(toolbarItems);
        if (toolbar.getVisibility() == View.VISIBLE) {
            toolbar.setVisibility(View.INVISIBLE);
        } else {
            toolbar.setVisibility(View.VISIBLE);
        }
    }


    public void displayShapesPopupWindow(View view) {

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("InflateParams") final View popupView = inflater.inflate(R.layout.shapes_popup_window, null);

        int width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        int height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        popupWindow = new PopupWindow(popupView, width, height);
        popupWindow.showAtLocation(findViewById(R.id.activity_main_layout), Gravity.CENTER, 0, 0);
//
//        popupWindow.setOutsideTouchable(true);
//        popupWindow.setFocusable(true);

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    //TODO handle clikcing outside the popup window
    }

    public void setBtnSelected(View view) {
        this.btnSelected = view.getTag().toString();
        if (!(this.btnSelected.equals(getString(R.string.path)))) {
            popupWindow.dismiss();
        }
    }

    public String getEditBtnSelected() {
        return editBtnSelected;
    }

    public void setEditBtnSelected(View view) {
        this.editBtnSelected = view.getTag().toString();

    }
}

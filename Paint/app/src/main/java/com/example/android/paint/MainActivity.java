package com.example.android.paint;

import android.annotation.SuppressLint;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
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
    private PopupWindow shapesPopupWindow;
    private PopupWindow colorPopupWindow;
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

        int width = RelativeLayout.LayoutParams.MATCH_PARENT;
        int height = RelativeLayout.LayoutParams.MATCH_PARENT;
        shapesPopupWindow = new PopupWindow(popupView, width, height);
        shapesPopupWindow.showAtLocation(findViewById(R.id.activity_main_layout), Gravity.CENTER, 0, 0);

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                shapesPopupWindow.dismiss();
                return true;
            }
        });
    }

    public void setBtnSelected(View view) {
        this.btnSelected = view.getTag().toString();
        shapesPopupWindow.dismiss();
        //TODO commented l7ad ma nfhmha XD
//        if (!(this.btnSelected.equals(getString(R.string.path)))) {
//            shapesPopupWindow.dismiss();
//        }
    }

    public String getEditBtnSelected() {
        return editBtnSelected;
    }

    public void setEditBtnSelected(View view) {
        this.editBtnSelected = view.getTag().toString();
    }

    public void setColor (View view) {
        LinearGradient colors = new LinearGradient(0.f, 0.f, 300.f, 0.0f,
                new int[] { 0xFF000000, 0xFF0000FF, 0xFF00FF00, 0xFF00FFFF,
                        0xFFFF0000, 0xFFFF00FF, 0xFFFFFF00, 0xFFFFFFFF},
                null, Shader.TileMode.CLAMP);
        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setShader(colors);

        SeekBar seekBarFont = (SeekBar)findViewById(R.id.seekbar);
        seekBarFont.setProgressDrawable( (Drawable)shape );

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("InflateParams") final View paletteView = inflater.inflate(R.layout.color_palette_window, null);

        int width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        int height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        colorPopupWindow = new PopupWindow(paletteView, width, height);
        colorPopupWindow.showAtLocation(findViewById(R.id.activity_main_layout), Gravity.CENTER, 0, 0);

    }
}

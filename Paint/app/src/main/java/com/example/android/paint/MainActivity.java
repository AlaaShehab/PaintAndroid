package com.example.android.paint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private String btnSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void setBtnSelected() {
        //TODO set btn selected when pressed
    }

    public String getBtnSelected() {
        return btnSelected;
    }
}

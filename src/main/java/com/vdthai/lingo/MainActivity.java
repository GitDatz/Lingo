package com.vdthai.lingo;

import android.gesture.GestureLibrary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Presenter presenter;
    private GestureLibrary gestureLibrary;

    private static final int[] GUESS_BOARD = { R.id.guess_cell_1, R.id.guess_cell_2, R.id.guess_cell_3, R.id.guess_cell_4, R.id.guess_cell_5 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);
    }
}

package com.vdthai.lingo;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.GestureDetector;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GestureLibrary gestureLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
        if(!gestureLibrary.load()){
            Log.d("DEBUG", "could not load library");
            finish();
        }

        GestureOverlayView gestureView = findViewById(R.id.gestureLayout);
        gestureView.addOnGesturePerformedListener(handleGestureListener);
    }

    private GestureOverlayView.OnGesturePerformedListener handleGestureListener = new GestureOverlayView.OnGesturePerformedListener() {
        @Override
        public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
            ArrayList<Prediction> predictionsList = gestureLibrary.recognize(gesture);

            if(predictionsList.size() > 0){
                for (Prediction predict: predictionsList) {
                    Log.d("DEBUG", predict.name + " " + predict.score);
                }
                Prediction prediction = predictionsList.get(0);
                if(prediction.score > 5){
                    // Make action
                    EditText editText = findViewById(R.id.guess_cell_1);
                    editText.setText(prediction.name);
                }
            }
        }
    };
}

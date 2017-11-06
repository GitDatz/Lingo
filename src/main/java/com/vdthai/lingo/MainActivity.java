package com.vdthai.lingo;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private Presenter presenter;
    private static final int[] GAME_BOARD = { R.id.cell_11, R.id.cell_12, R.id.cell_13, R.id.cell_14, R.id.cell_15 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);
        EditText firstCell = findViewById(R.id.cell_11);
        firstCell.setText(presenter.initGame());

        Button enterGuessButton = findViewById(R.id.enterGuessButton);
        enterGuessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText guessCell = findViewById(R.id.guess_text);
                guessCell.requestFocus();
                guessCell.isFocusableInTouchMode();
                InputMethodManager mInputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mInputManager.showSoftInput(guessCell, InputMethodManager.SHOW_FORCED);
            }
        });

        Button sendGuessButton = findViewById(R.id.sendGuessButton);
        sendGuessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText guessText = findViewById(R.id.guess_text);
                final String guess = guessText.getText().toString();
                ArrayList<Integer> result = presenter.guessResult(guess);   // Display based on result
                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    private int count = 0;
                    @Override
                    public void run() {
                        if(count < 5) {
                            EditText boardCell = findViewById(GAME_BOARD[count]);
                            if (boardCell.getText().length() > 0) {
                                boardCell.setText("");
                            }
                            boardCell.setText(String.valueOf(guess.charAt(count)));
                            handler.postDelayed(this, 1000);
                        } else {
                            handler.removeCallbacks(this);
                        }
                        count++;
                    }
                });
            }
        });
    }
}

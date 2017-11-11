package com.vdthai.lingo;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private Presenter presenter;
    private static final int[][] GAME_BOARD = { { R.id.cell_11, R.id.cell_12, R.id.cell_13, R.id.cell_14, R.id.cell_15 },
                                                { R.id.cell_21, R.id.cell_22, R.id.cell_23, R.id.cell_24, R.id.cell_25 },
                                                { R.id.cell_31, R.id.cell_32, R.id.cell_33, R.id.cell_34, R.id.cell_35 },
                                                { R.id.cell_41, R.id.cell_42, R.id.cell_43, R.id.cell_44, R.id.cell_45 },
                                                { R.id.cell_51, R.id.cell_52, R.id.cell_53, R.id.cell_54, R.id.cell_55 } };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);
        TextView firstCell = findViewById(R.id.cell_11);
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
                final int round = presenter.getRound();
                final ArrayList<Integer> result = presenter.guessResult(guess);   // Display based on result
                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    private int count = 0;
                    @Override
                    public void run() {
                        if(count < 5) {
                            TextView boardCell = findViewById(GAME_BOARD[round-1][count]);
                            if(boardCell.getText().length() > 0) {
                                boardCell.setText("");
                            }
                            // Start animation
                            final Animation in = new AlphaAnimation(0.0f, 1.0f);
                            in.setDuration(1000);
                            boardCell.startAnimation(in);
                            if(result.get(count) == 0){
                                boardCell.setBackgroundResource(R.drawable.cell_circle);
                                boardCell.setText(String.valueOf(guess.charAt(count)));
                            } else if(result.get(count) == 1){
                                boardCell.setBackgroundResource(R.drawable.cell_correct);
                                boardCell.setText(String.valueOf(guess.charAt(count)));
                            } else {
                                boardCell.setText(String.valueOf(guess.charAt(count)));
                            }
                            handler.postDelayed(this, 1000);
                        } else {
                            TextView guessCell = findViewById(R.id.guess_text);
                            guessCell.setText("");
                            TextView boardCellNext = findViewById(GAME_BOARD[presenter.getRound()-1][0]);
                            boardCellNext.setText(presenter.getFirstLetter());
                            for(int i = 1; i < 5; i++){
                                if(result.get(i) == 1){
                                    TextView boardCell = findViewById(GAME_BOARD[presenter.getRound()-1][i]);
                                    boardCell.setText(String.valueOf(guess.charAt(i)));
                                }
                            }
                            handler.removeCallbacks(this);
                        }
                        count++;
                    }
                });
            }
        });
    }
}

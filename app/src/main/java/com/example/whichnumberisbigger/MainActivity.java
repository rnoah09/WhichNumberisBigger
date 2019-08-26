package com.example.whichnumberisbigger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;

public class MainActivity extends AppCompatActivity {

    private Button buttonLeft;
    private Button buttonright;
    private TextView textViewScore;
    private BiggerNumberGame game;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();

        game = new BiggerNumberGame(0,1000000);
        updateGameDisplay();
    }

    private void updateGameDisplay()
    {
        textViewScore.setText("Score:" + game.getScore());
        buttonLeft.setText(String.valueOf(game.getNumber1()));
        buttonright.setText(String.valueOf(game.getNumber2()));
        game.generateRandomNumbers();
    }

    private void setListeners() {
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, game.checkAnswer(game.getNumber1()), Toast.LENGTH_SHORT).show();
                if (game.getNumber1() > game.getNumber2())
                {
                    constraintLayout.setBackgroundColor(rgb(133,255,133));
                }
                else
                {
                    constraintLayout.setBackgroundColor(rgb(255,102,102));
                }
                updateGameDisplay();
            }
        });
        buttonright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, game.checkAnswer(game.getNumber2()), Toast.LENGTH_SHORT).show();
                if (game.getNumber2() > game.getNumber1())
                {
                    constraintLayout.setBackgroundColor(rgb(133,255,133));
                }
                else
                {
                    constraintLayout.setBackgroundColor(rgb(255,102,102));
                }
                updateGameDisplay();
            }
        });
    }

    private void wireWidgets() {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonright = findViewById(R.id.button_main_right);
        textViewScore = findViewById(R.id.textview_main_score);
        constraintLayout = findViewById(R.id.constraint_layout_main);

    }

}

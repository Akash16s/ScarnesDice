package com.akash.sky.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button roll,hold,reset;
    TextView yourscore,compscore;
    ImageView diceImg;
    int overUserScore=0,userScore,overCompScore=0,compScore;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll =(Button) findViewById(R.id.Roll);
        hold=(Button) findViewById(R.id.Hold);
        reset=(Button) findViewById(R.id.reset);
        yourscore=(TextView) findViewById(R.id.yourscore);
        compscore=(TextView) findViewById(R.id.compscore);
        diceImg=(ImageView) findViewById(R.id.Dice);
    }

    public void rollDice(View view){
        Integer ren = random.nextInt(6);
        switch (ren) {
            case 1: diceImg.setImageResource(R.drawable.dice1); break;
            case 2: diceImg.setImageResource(R.drawable.dice2); break;
            case 3: diceImg.setImageResource(R.drawable.dice3); break;
            case 4: diceImg.setImageResource(R.drawable.dice4); break;
            case 5: diceImg.setImageResource(R.drawable.dice5); break;
            case 6: diceImg.setImageResource(R.drawable.dice6); break;

        }

    }
}

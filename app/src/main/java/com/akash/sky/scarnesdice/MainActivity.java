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
    TextView yourscore,compscore,turn;
    ImageView diceImg;
    int overUserScore=0,userScore=0,overCompScore=0,compScore=0;
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
        turn=(TextView) findViewById(R.id.turn);
    }

    public void rollDice(View view){            //method for rolling of dice
        userTurn();

    }
    public void resetDice(View view){
                overUserScore=0;
                userScore=0;
                overCompScore=0;
                compScore=0;
                yourscore.setText("Your Score : 0");
                compscore.setText("Computer Score : 0");
                turn.setText("player turn");
                roll.setEnabled(true);
                hold.setEnabled(true);

    }
    public void userTurn(){                                    //the real user rolling will occur
        hold.setEnabled(true);
        Integer ren = random.nextInt(7);                  //randomly generates values
        turn.setText("player turn");
        diceImg.animate().rotation(180f*ren).setDuration(500);
        switch (ren) {
            case 1:
                diceImg.setImageResource(R.drawable.dice1);
                overUserScore=overUserScore-userScore;
                yourscore.setText("Your Score : "+overUserScore);
                userScore=0;
                computerTurn();
                break;
            case 2:
                diceImg.setImageResource(R.drawable.dice2);
                userScore = userScore + 2;
                overUserScore=overUserScore+2;
                yourscore.setText("Your Score : "+overUserScore);
                break;
            case 3:
                diceImg.setImageResource(R.drawable.dice3);
                userScore = userScore + 3;
                overUserScore=overUserScore+3;
                yourscore.setText("Your Score : "+overUserScore);
                break;
            case 4:
                diceImg.setImageResource(R.drawable.dice4);
                userScore = userScore + 4;
                overUserScore=overUserScore+4;
                yourscore.setText("Your Score : "+overUserScore);
                break;
            case 5:
                diceImg.setImageResource(R.drawable.dice5);
                userScore = userScore + 5;
                overUserScore=overUserScore+5;
                yourscore.setText("Your Score : "+overUserScore);
                break;
            case 6:
                diceImg.setImageResource(R.drawable.dice6);
                userScore = userScore + 6;
                overUserScore=overUserScore+6;
                yourscore.setText("Your Score : "+overUserScore);
                break;
        }
        checkWin();                                                    //checks if the user win

    }

    public void computerTurn(){                                     //computer turn will occour
        hold.setEnabled(false);
        roll.setEnabled(false);
        turn.setText("computer turn");
        Integer ren=0;
        Integer chance=random.nextInt(6);                         //randomly generates values between 1-5
        int i=0;
        while(i<chance && ren!=1) {
            ren = random.nextInt(7);
            diceImg.animate().rotation(180f*ren).setDuration(500);
            switch (ren) {
                case 1:
                    diceImg.setImageResource(R.drawable.dice1);
                    overCompScore = overCompScore - compScore;
                    compscore.setText("Computer Score : " + overCompScore);
                    compScore=0;
                    break;
                case 2:
                    diceImg.setImageResource(R.drawable.dice2);
                    compScore = compScore + 2;
                    overCompScore = overCompScore + 2;
                    compscore.setText("Computer Score : " + overCompScore);
                    break;
                case 3:
                    diceImg.setImageResource(R.drawable.dice3);
                    compScore = compScore + 3;
                    overCompScore = overCompScore + 3;
                    compscore.setText("Computer Score : " + overCompScore);
                    break;
                case 4:
                    diceImg.setImageResource(R.drawable.dice4);
                    compScore = compScore + 4;
                    overCompScore = overCompScore + 4;
                    compscore.setText("Computer Score : " + overCompScore);
                    break;
                case 5:
                    diceImg.setImageResource(R.drawable.dice5);
                    compScore = compScore + 5;
                    overCompScore = overCompScore + 5;
                    compscore.setText("Computer Score : " + overCompScore);
                    break;
                case 6:
                    diceImg.setImageResource(R.drawable.dice6);
                    compScore = compScore + 6;
                    overCompScore = overCompScore + 6;
                    compscore.setText("Computer Score : " + overCompScore);
                    break;
            }
            i++;

            checkWin();
        }
        compScore=0;
        turn.setText("player turn");
        hold.setEnabled(true);
        roll.setEnabled(true);
    }

    public void holdDice(View view){                                //passes the chance
        userScore=0;
        computerTurn();
        turn.setText("player turn");
        hold.setEnabled(false);

    }

    public void checkWin(){                                 //win checker
        if(overUserScore>100&& overCompScore<100){
             turn.setText("You win");
             roll.setEnabled(false);
             hold.setEnabled(false);
        }
        else{
            if(overUserScore<100&&overCompScore>100){
                turn.setText("Computer Win");
                roll.setEnabled(false);
                hold.setEnabled(false);
            }
        }
    }
}

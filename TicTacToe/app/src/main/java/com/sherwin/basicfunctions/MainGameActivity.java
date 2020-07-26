package com.sherwin.basicfunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainGameActivity extends AppCompatActivity implements View.OnClickListener{
    private final char CIRCLE = 1;
    private final char CROSS = 2;
    public static int buttonIds[] = {
            R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9,
    };
    private Button buttonList[] = new Button[9];
    private int moves[][] = {  {0, 0, 0},   // 0 is blank
                                {0, 0, 0},   // 1 is O circle
                                {0, 0, 0}}; // 2 is X cross
    private static int scores[] = {0, 0};
    private int buttonAccesses[] = new int [9];
    private static boolean inPlay = true;
    private char currentMove = 1; // 1 for O, 2 for X
    private TextView score1TextView;
    private TextView score2TextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        Intent intent = getIntent(); // gets the intend sent to this activity
        String player1Name = intent.getStringExtra(MainActivity.PLAYER_1); // access property of MainActivity that has EXTRA_MESSAGE contained in it
        String player2Name = intent.getStringExtra(MainActivity.PLAYER_2);

        TextView player1TextView = (TextView) findViewById(R.id.player1TextView);
        TextView player2TextView = (TextView) findViewById(R.id.player2TextView);
        player1TextView.setText(player1Name);
        player2TextView.setText(player2Name);
        score1TextView = (TextView) findViewById(R.id.score1TextView);
        score2TextView = (TextView) findViewById(R.id.score2TextView);
        score1TextView.setText(String.valueOf(scores[0]));
        score2TextView.setText(String.valueOf(scores[1]));
        initializeButtons();
    }

    /**
     * Changes the tile a user presses
     * @author Sherwin Chiu
     * @return Character representing a circle or a cross (O or X)
     */
    private char changeTile(){
        if (currentMove == CIRCLE){
            currentMove = CROSS;
            return CIRCLE;
        } else {
            currentMove = CIRCLE;
            return CROSS;
        }
    }

    /**
     * Initializes the 9 buttons used for the TicTacToe grid
     * @author Sherwin Chiu
     */
    private void initializeButtons(){
        for(int i = 0; i < buttonList.length; i++) {
            buttonList[i] = (Button) findViewById(buttonIds[i]);
            buttonList[i].setOnClickListener(this);
        }
    }

    /**
     * Resets the moves on the board
     * @author Sherwin Chiu
     */
    private void resetMoves(int player){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
               System.out.print(moves[i][j]);
               moves[i][j] = 0;
               scores[player]++;
               currentMove = CIRCLE;
            }
            System.out.println();
        }
        for(int i = 0; i < buttonList.length; i++){
            buttonList[i].setText("");
        }
    }
    private int checkWon(int player, int i, int j, int score){
        if(player == moves[i][j]){
            score++;
            if(score == 3){
                resetMoves(player);
                return 0;
            }
        }
        return score;
    }
    /**
     * Checks if game has been won by a player, or if their is a draw
     * @author Sherwin Chiu
     */
    private void gameWon(){
        int victoryScore = 0;
        for (int players = 1; players < 3; players++) {
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++) {
                // Check if won horizontal
                    victoryScore = checkWon(players, i, j, victoryScore);

                }
                victoryScore = 0;
                // Check if won vertical
                for(int j = 0; j < 3; j++){
                    if (players == moves[j][i]){
                        victoryScore++;
                        if (victoryScore == 3) {
                            victoryScore = 0;
                            resetMoves(players);
                        }
                    }
                }
                victoryScore = 0;
                // Check if won diagonal
                for(int j = 0; j < 3; j++){
                    if(players == moves[j][j]){
                        victoryScore++;
                        if(victoryScore == 3){
                            victoryScore = 0;
                            resetMoves(players);
                        }
                    }
                }
                victoryScore = 0;
                for(int j = 0; j < 3; j++){
                    if(players == moves[2-j][2-j]){
                        victoryScore++;
                        if(victoryScore == 3){
                            victoryScore = 0;
                            resetMoves(players);
                        }
                    }
                }
            }
        }



        // Check if draw
    }
    @Override
    public void onClick(View view){
        int buttonNum = view.getId();
        System.out.println("Somethings been clicked!");
        for(int i = 0; i < buttonIds.length; i++){
            if (buttonNum == buttonIds[i] && !("1".equals(buttonList[i].getText()) || "2".equals(buttonList[i].getText()))){
                int move = changeTile();
                moves[(int) (i / 3)][i % 3] = move;
                buttonList[i].setText(String.valueOf(move));
            }
        }

        gameWon();
    }

}
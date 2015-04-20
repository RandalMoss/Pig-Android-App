package edu.calstatela.toramoss.pairofdice;

import android.widget.Toast;

/**
 * Created by toramoss on 4/12/15.
 */
public class GameState {
    private static int player1Score = 0;
    private static int player2Score = 0;
    private static int points = 0;

    public static int getPlayer1Score(){
        return player1Score;
    }

    public static void setPlayer1Score(int in){
        player1Score = in;
    }

    public static int getPlayer2Score(){
        return player2Score;
    }

    public static void setPlayer2Score(int in){
        player2Score = in;
    }

    public static int getPoints(){
        return points;
    }

    public static void setPoints(int in){
        points = in;
    }

    public static void reset(){
        player1Score = 0;
        player2Score = 0;
        points = 0;
    }

}

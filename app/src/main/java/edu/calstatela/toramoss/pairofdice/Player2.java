package edu.calstatela.toramoss.pairofdice;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Player2 extends Activity {
    Button rollButton;
    Button holdButton;
    ImageView image1;
    ImageView image2;
    int score = 0;
    int points = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2);
        rollButton = (Button)findViewById(R.id.button);
        holdButton = (Button)findViewById(R.id.bank);
        image1 = (ImageView)findViewById(R.id.imageView);
        image2 = (ImageView)findViewById(R.id.imageView2);
        updatePointsToScore(GameState.getPlayer1Score(), GameState.getPlayer2Score());

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int r1 = r.nextInt(6) + 1;
                int r2 = r.nextInt(6) + 1;
                changeImages(r1, r2);
                addScore(r1, r2);
            }
        });

        holdButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                switchView();
            }
        });

    }

    public void switchView(){
        GameState.setPlayer2Score(GameState.getPlayer2Score() + points);
        updatePointsToScore(GameState.getPlayer1Score(), GameState.getPlayer2Score());
        Intent intent = new Intent(Player2.this, Main.class);
        startActivity(intent);
        Player2.this.finish();
    }

    public void updatePointsToScore(int score1, int score2){
        TextView player1Score = (TextView)findViewById(R.id.score1);
        player1Score.setText("Score: " + score1);
        TextView player2Score = (TextView)findViewById(R.id.score2);
        player2Score.setText("Score: " + score2);
        checkWinState();
    }

    public void checkWinState(){
        if(GameState.getPlayer2Score() >= 100){
            Toast.makeText(getApplicationContext(), "Player 2 wins!", Toast.LENGTH_LONG).show();
            GameState.reset();
        }
    }

    public void addScore(int r1, int r2){
        TextView pointsText = (TextView)findViewById(R.id.points);
        if(r1 == 1 || r2 == 1){
            points = 0;
            pointsText.setText("Points: " + points);
            switchView();
        }
        else{
            points = points + r1 + r2;
            pointsText.setText("Points: " + points);
        }
        GameState.setPoints(points);
    }

    public void changeImages(int r1, int r2){
        Drawable d1 = getResources().getDrawable(R.drawable.die_face_1);
        Drawable d2 = getResources().getDrawable(R.drawable.die_face_2);
        Drawable d3 = getResources().getDrawable(R.drawable.die_face_3);
        Drawable d4 = getResources().getDrawable(R.drawable.die_face_4);
        Drawable d5 = getResources().getDrawable(R.drawable.die_face_5);
        Drawable d6 = getResources().getDrawable(R.drawable.die_face_6);
        if(r1 == 1){
            image1.setImageDrawable(d1);
        }
        else if(r1 == 2){
            image1.setImageDrawable(d2);
        }
        else if(r1 == 3){
            image1.setImageDrawable(d3);
        }
        else if(r1 == 4){
            image1.setImageDrawable(d4);
        }
        else if(r1 == 5){
            image1.setImageDrawable(d5);
        }
        else if(r1 == 6){
            image1.setImageDrawable(d6);
        }

        if(r2 == 1){
            image2.setImageDrawable(d1);
        }
        else if(r2 == 2){
            image2.setImageDrawable(d2);
        }
        else if(r2 == 3){
            image2.setImageDrawable(d3);
        }
        else if(r2 == 4){
            image2.setImageDrawable(d4);
        }
        else if(r2 == 5){
            image2.setImageDrawable(d5);
        }
        else if(r2 == 6){
            image2.setImageDrawable(d6);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

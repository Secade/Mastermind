package com.example.mindmaster;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    TextView tvPersonalBest, tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        getSupportActionBar().hide();
        int score = getIntent().getExtras().getInt("score");
        SharedPreferences pref = getSharedPreferences("MyPref",0);
        int scoreSP = pref.getInt("scoreSP",9999);
        SharedPreferences.Editor editor = pref.edit();
        if(score < scoreSP){
            scoreSP = score;
            editor.putInt("scoreSP", scoreSP);
            editor.commit();
            Toast.makeText(getApplicationContext(), "Congratulations! You've beat your personal high score!", Toast.LENGTH_LONG).show();
        }
        tvPersonalBest = findViewById(R.id.tvPersonalBest);
        tvPersonalBest.setText(""+scoreSP);
        tvScore = findViewById(R.id.tvScore);
        tvScore.setText(""+score);
    }

    public void restart(View view){
        Intent intent = new Intent(GameOver.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view){
        finish();
    }
}


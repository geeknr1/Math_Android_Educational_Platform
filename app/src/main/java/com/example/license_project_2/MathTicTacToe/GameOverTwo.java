package com.example.license_project_2.MathTicTacToe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.license_project_2.Games;
import com.example.license_project_2.MathGeometry.GameOver;
import com.example.license_project_2.MathGeometry.GeometryMain;
import com.example.license_project_2.R;

import java.util.Objects;

public class GameOverTwo extends AppCompatActivity {
    TextView points, highestScore;
    SharedPreferences sharedPreferences;
    ImageView rewardCup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.game_over_two);

        points = findViewById(R.id.tvPoints);
        highestScore = findViewById(R.id.tvHighest);
        rewardCup = findViewById(R.id.ivNewHighest);

        int points_ = Objects.requireNonNull(getIntent().getExtras()).getInt("points");
        points.setText(" " + points_);
        sharedPreferences = getSharedPreferences("my_pref", 0);
        int highest = sharedPreferences.getInt("highest", 0);

        if(points_ > highest){
            rewardCup.setVisibility(View.VISIBLE);
            highest = points_;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("highest", highest);
            editor.apply();
        }
        highestScore.setText("" + highest);
    }

    public void restartGame(View view){
        startActivity(new Intent(GameOverTwo.this, TicTacToeMain.class));
        finish();
    }

    public void quitGame(View view){
        startActivity(new Intent(GameOverTwo.this, Games.class));
        finish();
    }
}

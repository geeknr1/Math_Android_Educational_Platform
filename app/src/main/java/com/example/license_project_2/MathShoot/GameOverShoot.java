package com.example.license_project_2.MathShoot;

import android.annotation.SuppressLint;
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
import com.example.license_project_2.R;

import java.util.Objects;

public class GameOverShoot extends AppCompatActivity {
    TextView tvPoints, tvHighest;
    SharedPreferences sharedPreferences;
    ImageView ivRewardGame;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.game_over_three);

        tvPoints = findViewById(R.id.tvPoints);
        tvHighest = findViewById(R.id.tvHighest);
        ivRewardGame = findViewById(R.id.ivNewHighest);

        int points = Objects.requireNonNull(getIntent().getExtras()).getInt("points");
        tvPoints.setText("" + points);
        sharedPreferences = getSharedPreferences("my_pref", 0);
        int highest = sharedPreferences.getInt("highest", 0);

        if(points > highest){
            ivRewardGame.setVisibility(View.VISIBLE);
            highest = points;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("highest", highest);
            editor.apply();
        }
        tvHighest.setText("" + highest);
    }

    public void restartGame(View view){
        startActivity(new Intent(GameOverShoot.this, ShootMain.class));
        finish();
    }

    public void quitGame(View view){
        startActivity(new Intent(GameOverShoot.this, Games.class));
    }
}

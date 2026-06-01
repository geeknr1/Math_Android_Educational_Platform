package com.example.license_project_2.MathShoot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.license_project_2.audio.BackgroundMusicHelper;

import com.example.license_project_2.R;

public class ShootMain extends AppCompatActivity {
    private Button startGame;
    private BackgroundMusicHelper backgroundMusicHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.shoot_main);

        backgroundMusicHelper = new BackgroundMusicHelper();

        startGame = findViewById(R.id.startGame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShootMain.this, GameActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        backgroundMusicHelper.start(this, R.raw.filefour);
    }

    @Override
    protected void onPause() {
        backgroundMusicHelper.pause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        backgroundMusicHelper.stop();
        super.onDestroy();
    }
}

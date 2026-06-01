package com.example.license_project_2.MathGeometry;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import com.example.license_project_2.audio.BackgroundMusicHelper;

import com.example.license_project_2.R;

public class GeometryMain extends AppCompatActivity {
    BackgroundMusicHelper backgroundMusicHelper;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_geometry);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        backgroundMusicHelper = new BackgroundMusicHelper();
    }

    public void startGame(View view){
        GameView gameView = new GameView(this);
        setContentView(gameView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        backgroundMusicHelper.start(this, R.raw.filethree);
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

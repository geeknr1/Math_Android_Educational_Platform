package com.example.license_project_2.MathGeometry;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.license_project_2.R;

public class GeometryMain extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_geometry);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public void startGame(View view){
        GameView gameView = new GameView(this);
        setContentView(gameView);
    }
}

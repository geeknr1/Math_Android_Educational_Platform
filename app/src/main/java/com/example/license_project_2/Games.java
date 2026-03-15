package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.license_project_2.MathRoulette.RouletteMain;

public class Games extends AppCompatActivity {
    private TextView gameOne;
    private TextView gameTwo;
    private TextView gameThree;
    private TextView gameFour;
    private TextView back;

    protected void onCreate(Bundle savedInstanceState){
//        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games);

        gameOne = findViewById(R.id.GameOne);
        gameTwo = findViewById(R.id.GameTwo);
        gameThree = findViewById(R.id.GameThree);
        gameFour = findViewById(R.id.GameFour);
        back = findViewById(R.id.Back);

        gameOne.setVisibility(VISIBLE);
        gameTwo.setVisibility(VISIBLE);
        gameThree.setVisibility(VISIBLE);
        gameFour.setVisibility(VISIBLE);
        back.setVisibility(VISIBLE);

        gameOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent gameOneIntent = new Intent(view.getContext(), RouletteMain.class);
                startActivity(new Intent(Games.this, RouletteMain.class));
//                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Games.this, MainActivity.class));
            }
        });
    }
}

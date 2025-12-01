package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Games extends AppCompatActivity {
    private Button gameOne;
    private Button gameTwo;
    private Button gameThree;
    private Button gameFour;
    private Button back;

    protected void onCreate(Bundle savedInstanceState){
        getSupportActionBar().hide();
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Games.this, MainActivity.class));
            }
        });
    }
}

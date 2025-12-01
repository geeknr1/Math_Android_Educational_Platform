package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView welcome;
    private Button tutorial;
    private Button games;
    private Button quit;
    protected void onCreate(Bundle savedInstanceState){
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = findViewById(R.id.welcomeMessage);
        tutorial = findViewById(R.id.Tutorial);
        games = findViewById(R.id.Games);
        quit = findViewById(R.id.Quit);

        welcome.setVisibility(VISIBLE);
        tutorial.setVisibility(VISIBLE);
        games.setVisibility(VISIBLE);
        quit.setVisibility(VISIBLE);

        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Tutorial.class));
            }
        });

        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Games.class));
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                System.exit(0);
            }
        });

    }
}


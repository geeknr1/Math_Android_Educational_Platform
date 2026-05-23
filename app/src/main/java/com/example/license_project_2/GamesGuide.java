package com.example.license_project_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GamesGuide extends AppCompatActivity {
    private TextView title;
    private Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive;
    private ImageButton back;
    private Animation bounceOne, bounceTwo, bounceThree, bounceFour, bounceFive, bounceSix;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.games_guide);

        title = findViewById(R.id.twentyfour);
        buttonOne = findViewById(R.id.spinrouletteguide);
        buttonTwo = findViewById(R.id.mathshootguide);
        buttonThree = findViewById(R.id.geododgeguide);
        buttonFour = findViewById(R.id.completemathguide);
        buttonFive = findViewById(R.id.tictactoemathguide);
        back = findViewById(R.id.backbutton);

        title.setVisibility(View.VISIBLE);
        buttonOne.setVisibility(View.VISIBLE);
        buttonTwo.setVisibility(View.VISIBLE);
        buttonThree.setVisibility(View.VISIBLE);
        buttonFour.setVisibility(View.VISIBLE);
        buttonFive.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);

        bounceOne = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceTwo = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceThree = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceFour = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceFive = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceSix = AnimationUtils.loadAnimation(this, R.anim.bounce);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonOne.startAnimation(bounceOne);
                startActivity(new Intent(GamesGuide.this, SpinRouletteGuide.class));
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonTwo.startAnimation(bounceTwo);
                startActivity(new Intent(GamesGuide.this, MathShootGuide.class));
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonThree.startAnimation(bounceThree);
                startActivity(new Intent(GamesGuide.this, GeoDodgeGuide.class));
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonFour.startAnimation(bounceFour);
                startActivity(new Intent(GamesGuide.this, CompleteMathGuide.class));
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonFive.startAnimation(bounceFive);
                startActivity(new Intent(GamesGuide.this, TicTacToeMathGuide.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.startAnimation(bounceSix);
                startActivity(new Intent(GamesGuide.this, AppGuide.class));
            }
        });
    }
}

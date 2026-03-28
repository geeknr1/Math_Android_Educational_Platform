package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.license_project_2.MathComplete.CompleteMain;
import com.example.license_project_2.MathRoulette.RouletteMain;

public class Games extends AppCompatActivity {
    private ImageButton gameOne, gameTwo, gameThree, gameFour, back;
    private Animation bounceAnimationOne, bounceAnimationTwo, bounceAnimationThree, bounceAnimationFour, bounceAnimationFive;

    protected void onCreate(Bundle savedInstanceState){
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

        bounceAnimationOne = AnimationUtils.loadAnimation(this, R.anim.bounce);
        gameOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameOne.startAnimation(bounceAnimationOne);
                startActivity(new Intent(Games.this, RouletteMain.class));
            }
        });

        bounceAnimationTwo = AnimationUtils.loadAnimation(this, R.anim.bounce);
        gameTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameTwo.startAnimation(bounceAnimationTwo);
            }
        });

        bounceAnimationThree = AnimationUtils.loadAnimation(this, R.anim.bounce);
        gameThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameThree.startAnimation(bounceAnimationThree);
            }
        });

        bounceAnimationFour = AnimationUtils.loadAnimation(this, R.anim.bounce);
        gameFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameFour.startAnimation(bounceAnimationFour);
                startActivity(new Intent(Games.this, CompleteMain.class));
            }
        });

        bounceAnimationFive = AnimationUtils.loadAnimation(this, R.anim.bounce);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.startAnimation(bounceAnimationFive);
                startActivity(new Intent(Games.this, MainActivity.class));
            }
        });
    }
}

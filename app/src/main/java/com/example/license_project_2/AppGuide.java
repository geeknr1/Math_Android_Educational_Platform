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

public class AppGuide extends AppCompatActivity {
    private TextView guide;
    private Button tutorialButton, gamesButton;
    private ImageButton back;
    private Animation bounceAnimationOne, bounceAnimationTwo, bounceAnimationThree;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.app_guide);

        guide = findViewById(R.id.twentyfour);
        tutorialButton = findViewById(R.id.tutorialguide);
        gamesButton = findViewById(R.id.gamesguide);
        back = findViewById(R.id.backbutton);

        guide.setVisibility(View.VISIBLE);
        tutorialButton.setVisibility(View.VISIBLE);
        gamesButton.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);

        bounceAnimationOne = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceAnimationTwo = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceAnimationThree = AnimationUtils.loadAnimation(this, R.anim.bounce);
        tutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tutorialButton.startAnimation(bounceAnimationOne);
                startActivity(new Intent(AppGuide.this, TutorialGuide.class));
            }
        });
        gamesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                gamesButton.startAnimation(bounceAnimationTwo);
                startActivity(new Intent(AppGuide.this, GamesGuide.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.startAnimation(bounceAnimationThree);
                startActivity(new Intent(AppGuide.this, MainActivity.class));
            }
        });
    }
}

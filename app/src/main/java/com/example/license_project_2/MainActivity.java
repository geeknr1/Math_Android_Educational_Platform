package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.license_project_2.MathRoulette.RouletteMain;

public class MainActivity extends AppCompatActivity {
    private Animation bounceAnimationOne, bounceAnimationTwo, bounceAnimationThree;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ImageView welcome = findViewById(R.id.welcomeMessage);
        ImageButton tutorial = findViewById(R.id.Tutorial);
        ImageButton games = findViewById(R.id.Games);
        ImageButton quit = findViewById(R.id.Quit);

        welcome.setVisibility(VISIBLE);
        tutorial.setVisibility(VISIBLE);
        games.setVisibility(VISIBLE);
        quit.setVisibility(VISIBLE);

        bounceAnimationOne = AnimationUtils.loadAnimation(this, R.anim.bounce);
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    tutorial.startAnimation(bounceAnimationOne);
                    startActivity(new Intent(MainActivity.this, Tutorial.class));
                }catch(Exception e){
                    Toast.makeText((Context) MainActivity.this, (CharSequence) e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        bounceAnimationTwo = AnimationUtils.loadAnimation(this, R.anim.bounce);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                games.startAnimation(bounceAnimationTwo);
                startActivity(new Intent(MainActivity.this, Games.class));
            }
        });

        bounceAnimationThree = AnimationUtils.loadAnimation(this, R.anim.bounce);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quit.startAnimation(bounceAnimationThree);
                finishAffinity();
                System.exit(0);
            }
        });

    }
}


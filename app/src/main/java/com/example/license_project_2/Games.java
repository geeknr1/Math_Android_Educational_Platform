package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.license_project_2.MathComplete.CompleteMain;
import com.example.license_project_2.MathGeometry.GeometryMain;
import com.example.license_project_2.MathRoulette.RouletteMain;
import com.example.license_project_2.MathShoot.ShootMain;
import com.example.license_project_2.MathTicTacToe.TicTacToeMain;
import com.example.license_project_2.notifications.NotificationBellHelper;

public class Games extends AppCompatActivity {
    private ImageButton gameOne, gameTwo, gameThree, gameFour, gameFive, left, right, back;
    private Animation bounceAnimationOne, bounceAnimationTwo, bounceAnimationThree, bounceAnimationFour,
            bounceAnimationFive, bounceAnimationSix, bounceAnimationSeven, bounceAnimationEight;
    private NotificationBellHelper notificationBellHelper;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.games);

        notificationBellHelper = NotificationBellHelper.attach(this);

        gameOne = findViewById(R.id.GameOne); gameTwo = findViewById(R.id.GameTwo);
        gameThree = findViewById(R.id.GameThree); gameFour = findViewById(R.id.GameFour);
        gameFive = findViewById(R.id.GameFive);
        left = findViewById(R.id.previous); right = findViewById(R.id.next); back = findViewById(R.id.Back);

        gameOne.setVisibility(View.VISIBLE); gameTwo.setVisibility(View.VISIBLE);
        gameThree.setVisibility(View.VISIBLE); gameFour.setVisibility(View.GONE);
        gameFive.setVisibility(View.GONE);
        left.setVisibility(View.VISIBLE); right.setVisibility(View.VISIBLE); back.setVisibility(View.VISIBLE);

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
                startActivity(new Intent(Games.this, ShootMain.class));
            }
        });

        bounceAnimationThree = AnimationUtils.loadAnimation(this, R.anim.bounce);
        gameThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameThree.startAnimation(bounceAnimationThree);
                startActivity(new Intent(Games.this, GeometryMain.class));
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

        bounceAnimationSix = AnimationUtils.loadAnimation(this, R.anim.bounce);
        gameFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameFive.startAnimation(bounceAnimationFive);
                startActivity(new Intent(Games.this, TicTacToeMain.class));
            }
        });

        bounceAnimationSeven = AnimationUtils.loadAnimation(this, R.anim.bounce);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left.startAnimation(bounceAnimationSeven);
                gameOne.setVisibility(View.VISIBLE); gameTwo.setVisibility(View.VISIBLE);
                gameThree.setVisibility(View.VISIBLE); gameFour.setVisibility(View.GONE);
                gameFive.setVisibility(View.GONE);
            }
        });

        bounceAnimationEight = AnimationUtils.loadAnimation(this, R.anim.bounce);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                right.startAnimation(bounceAnimationEight);
                gameOne.setVisibility(View.GONE); gameTwo.setVisibility(View.GONE);
                gameThree.setVisibility(View.GONE); gameFour.setVisibility(View.VISIBLE);
                gameFive.setVisibility(View.VISIBLE);
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

    @Override
    protected void onResume() {
        super.onResume();
        if (notificationBellHelper != null) {
            notificationBellHelper.onResume();
        }
    }
}

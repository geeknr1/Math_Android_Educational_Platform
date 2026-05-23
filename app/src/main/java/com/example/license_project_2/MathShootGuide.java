package com.example.license_project_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MathShootGuide extends AppCompatActivity {
    TextView title, theoryOne, theoryTwo, theoryThree;
    ImageView imageOne, imageTwo;
    ImageButton back;
    Animation bounceAnimation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.math_shoot_guide);

        title = findViewById(R.id.nineteen);
        theoryOne = findViewById(R.id.twentyone);
        theoryTwo = findViewById(R.id.twentytwo);
        theoryThree = findViewById(R.id.twentythree);
        imageOne = findViewById(R.id.numbers);
        imageTwo = findViewById(R.id.shoot);
        back = findViewById(R.id.backbutton);

        title.setVisibility(View.VISIBLE);
        theoryOne.setVisibility(View.VISIBLE);
        theoryTwo.setVisibility(View.VISIBLE);
        theoryThree.setVisibility(View.VISIBLE);
        imageOne.setVisibility(View.VISIBLE);
        imageTwo.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);

        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.startAnimation(bounceAnimation);
                startActivity(new Intent(MathShootGuide.this, GamesGuide.class));
            }
        });
    }
}

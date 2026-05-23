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

public class SpinRouletteGuide extends AppCompatActivity {
    private TextView title, textOne, textTwo, textThree, textFour, textFive;
    private ImageView imageOne, imageTwo, imageThree, imageFour;
    private ImageButton back;
    private Animation bounceAnimation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.spin_roulette_guide);

        title = findViewById(R.id.thirteen);
        textOne = findViewById(R.id.fourteen);
        textTwo = findViewById(R.id.fifteen);
        textThree = findViewById(R.id.sixteen);
        textFour = findViewById(R.id.seventeen);
        textFive = findViewById(R.id.eightteen);
        imageOne = findViewById(R.id.rouletteandspin);
        imageTwo = findViewById(R.id.problemimg);
        imageThree = findViewById(R.id.correctanswer);
        imageFour = findViewById(R.id.wronganswer);
        back = findViewById(R.id.backbutton);

        title.setVisibility(View.VISIBLE);
        textOne.setVisibility(View.VISIBLE);
        textTwo.setVisibility(View.VISIBLE);
        textThree.setVisibility(View.VISIBLE);
        textFour.setVisibility(View.VISIBLE);
        textFive.setVisibility(View.VISIBLE);
        imageOne.setVisibility(View.VISIBLE);
        imageTwo.setVisibility(View.VISIBLE);
        imageThree.setVisibility(View.VISIBLE);
        imageFour.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);

        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.startAnimation(bounceAnimation);
                startActivity(new Intent(SpinRouletteGuide.this, GamesGuide.class));
            }
        });

    }
}

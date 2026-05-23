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

public class GeoDodgeGuide extends AppCompatActivity {
    TextView title, theoryOne, theoryTwo, theoryThree;
    ImageView imageOne, imageTwo;
    ImageButton back;
    Animation bounceAnimation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.geo_dodge_guide);

        title = findViewById(R.id.twentyfour);
        theoryOne = findViewById(R.id.twentyfive);
        theoryTwo = findViewById(R.id.twentysix);
        theoryThree = findViewById(R.id.twentyseven);
        imageOne = findViewById(R.id.shapes);
        imageTwo = findViewById(R.id.dodge);
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
                startActivity(new Intent(GeoDodgeGuide.this, GamesGuide.class));
            }
        });
    }
}

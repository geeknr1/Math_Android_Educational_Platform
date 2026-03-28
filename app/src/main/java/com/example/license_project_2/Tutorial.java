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

public class Tutorial extends AppCompatActivity {

    private Animation bounceAnimationOne, bounceAnimationTwo, bounceAnimationThree;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);

        TextView takeYourPick = findViewById(R.id.PickSubject);
        ImageButton algebra = findViewById(R.id.Algebra);
        ImageButton geometry = findViewById(R.id.Geometry);
        ImageButton back = findViewById(R.id.Back);

        takeYourPick.setVisibility(VISIBLE);
        algebra.setVisibility(VISIBLE);
        geometry.setVisibility(VISIBLE);
        back.setVisibility(VISIBLE);

        bounceAnimationOne = AnimationUtils.loadAnimation(this, R.anim.bounce);
        algebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                algebra.startAnimation(bounceAnimationOne);
                startActivity(new Intent(Tutorial.this, Algebra.class));
            }
        });

        bounceAnimationTwo = AnimationUtils.loadAnimation(this, R.anim.bounce);
        geometry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                geometry.startAnimation(bounceAnimationTwo);
                startActivity(new Intent(Tutorial.this, Geometry.class));
            }
        });

        bounceAnimationThree = AnimationUtils.loadAnimation(this, R.anim.bounce);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.startAnimation(bounceAnimationThree);
                startActivity(new Intent(Tutorial.this, MainActivity.class));
            }
        });


    }
}

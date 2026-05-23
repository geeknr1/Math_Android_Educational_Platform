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

public class TutorialGuide extends AppCompatActivity {
    private TextView title, textOne, textTwo, textThree, textFour, textFive, textSix, textSeven, textEight;
    private ImageView imgOne, imgTwo, imgThree, imgFour, imgFive, imgSix, imgSeven;
    private ImageButton back;
    private Animation bounceAnimation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.tutorial_guide);


        title = findViewById(R.id.tutorialguide);
        textOne = findViewById(R.id.four);
        textTwo = findViewById(R.id.five);
        textThree = findViewById(R.id.six);
        textFour = findViewById(R.id.seven);
        textFive = findViewById(R.id.eight);
        textSix = findViewById(R.id.nine);
        textSeven = findViewById(R.id.ten);
        textEight = findViewById(R.id.eleven);
        imgOne = findViewById(R.id.imgone);
        imgTwo = findViewById(R.id.imgtwo);
        imgThree = findViewById(R.id.imgthree);
        imgFour = findViewById(R.id.defimg);
        imgFive = findViewById(R.id.propsimg);
        imgSix = findViewById(R.id.workedeximg);
        imgSeven = findViewById(R.id.quizimg);
        back = findViewById(R.id.backbutton);

        title.setVisibility(View.VISIBLE);
        textOne.setVisibility(View.VISIBLE);
        textTwo.setVisibility(View.VISIBLE);
        textThree.setVisibility(View.VISIBLE);
        textFour.setVisibility(View.VISIBLE);
        textFive.setVisibility(View.VISIBLE);
        textSix.setVisibility(View.VISIBLE);
        textSeven.setVisibility(View.VISIBLE);
        textEight.setVisibility(View.VISIBLE);
        imgOne.setVisibility(View.VISIBLE);
        imgTwo.setVisibility(View.VISIBLE);
        imgThree.setVisibility(View.VISIBLE);
        imgFour.setVisibility(View.VISIBLE);
        imgFive.setVisibility(View.VISIBLE);
        imgSix.setVisibility(View.VISIBLE);
        imgSeven.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);

        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.startAnimation(bounceAnimation);
                startActivity(new Intent(TutorialGuide.this, AppGuide.class));
            }
        });


    }

}


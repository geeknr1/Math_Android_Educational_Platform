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

public class TicTacToeMathGuide extends AppCompatActivity {
    private TextView title, textOne, textTwo, textThree, textFour, textFive, textSix, textSeven;
    private ImageView imgOne, imgTwo, imgThree, imgFour, imgFive, imgSix, imgSeven;
    private ImageButton back;
    private Animation bounceAnimation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.tic_tac_toe_math_guide);

        title = findViewById(R.id.thirty);
        textOne = findViewById(R.id.thirtyone);
        textTwo = findViewById(R.id.thirtytwo);
        textThree = findViewById(R.id.thirtythree);
        textFour = findViewById(R.id.thirtyfive);
        textFive = findViewById(R.id.thirtyeight);
        textSix = findViewById(R.id.thirtynine);
        textSeven = findViewById(R.id.forty);
        imgOne = findViewById(R.id.numbersimg);
        imgTwo = findViewById(R.id.gridimg);
        imgThree = findViewById(R.id.resultimg);
        imgFour = findViewById(R.id.placednumbers);
        imgFive = findViewById(R.id.selectednumbers);
        imgSix = findViewById(R.id.correctimg);
        imgSeven = findViewById(R.id.wrongimg);
        back = findViewById(R.id.backbutton);

        title.setVisibility(View.VISIBLE);
        textOne.setVisibility(View.VISIBLE);
        textTwo.setVisibility(View.VISIBLE);
        textThree.setVisibility(View.VISIBLE);
        textFour.setVisibility(View.VISIBLE);
        textFive.setVisibility(View.VISIBLE);
        textSix.setVisibility(View.VISIBLE);
        textSeven.setVisibility(View.VISIBLE);
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
                startActivity(new Intent(TicTacToeMathGuide.this, GamesGuide.class));
            }
        });
    }
}

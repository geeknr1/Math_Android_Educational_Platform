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

public class CompleteMathGuide extends AppCompatActivity {
    private TextView title, line;
    private ImageView problem;
    private ImageButton back;
    private Animation bounceAnimation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.complete_math_guide);

        title = findViewById(R.id.twentyeight);
        line = findViewById(R.id.twentynine);
        problem = findViewById(R.id.correctimg);
        back = findViewById(R.id.backbutton);

        title.setVisibility(View.VISIBLE);
        line.setVisibility(View.VISIBLE);
        problem.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);

        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.startAnimation(bounceAnimation);
                startActivity(new Intent(CompleteMathGuide.this, GamesGuide.class));
            }
        });

    }
}

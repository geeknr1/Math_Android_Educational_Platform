package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Tutorial extends AppCompatActivity {
    private TextView takeYourPick;
    private TextView algebra;
    private TextView geometry;
    private TextView back;

    protected void onCreate(Bundle savedInstanceState){
//        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);

        takeYourPick = findViewById(R.id.PickSubject);
        algebra = findViewById(R.id.Algebra);
        geometry = findViewById(R.id.Geometry);
        back = findViewById(R.id.Back);

        takeYourPick.setVisibility(VISIBLE);
        algebra.setVisibility(VISIBLE);
        geometry.setVisibility(VISIBLE);
        back.setVisibility(VISIBLE);

        algebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Tutorial.this, Algebra.class));
            }
        });

        geometry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Tutorial.this, Geometry.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Tutorial.this, MainActivity.class));
            }
        });


    }
}

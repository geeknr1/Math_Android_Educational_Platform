package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Tutorial extends AppCompatActivity {
    private Button roadMap;
    private Button algebra;
    private Button geometry;
    private Button back;

    protected void onCreate(Bundle savedInstanceState){
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);

        roadMap = findViewById(R.id.RoadMap);
        algebra = findViewById(R.id.Algebra);
        geometry = findViewById(R.id.Geometry);
        back = findViewById(R.id.Back);

        roadMap.setVisibility(VISIBLE);
        algebra.setVisibility(VISIBLE);
        geometry.setVisibility(VISIBLE);
        back.setVisibility(VISIBLE);

        algebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Tutorial.this, Algebra.class));
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

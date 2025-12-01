package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AlgebraSection extends AppCompatActivity {

    private RadioGroup algebraSubject;
    private RadioButton definition;
    private RadioButton properties;
    private RadioButton workedExamples;
    private RadioButton quiz;
    private TextView theory;
    private Button back;

    protected void onCreate(Bundle savedInstanceState){
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algebra_section);

        AlgebraSections sectionAlg = AlgebraSections.detachFrom(getIntent());
        bindText(sectionAlg);

        theory = findViewById(R.id.sectionTheory);
        back = findViewById(R.id.back);

        algebraSubject = findViewById(R.id.radioAlg);
        definition = findViewById(R.id.definition);
        properties = findViewById(R.id.properties);
        workedExamples = findViewById(R.id.workedExamples);
        quiz = findViewById(R.id.quiz);

        algebraSubject.setVisibility(VISIBLE);
        definition.setVisibility(VISIBLE);
        properties.setVisibility(VISIBLE);
        workedExamples.setVisibility(VISIBLE);
        quiz.setVisibility(VISIBLE);

        algebraSubject.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(definition.isChecked()){
                    theory.setVisibility(View.VISIBLE);
                }
                if(properties.isChecked()){
                    theory.setVisibility(View.VISIBLE);
                }
                if(workedExamples.isChecked()){
                    theory.setVisibility(View.GONE);
                }
                if(quiz.isChecked()){
                    theory.setVisibility(View.GONE);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlgebraSection.this, Algebra.class));
            }
        });


    }
    public void setText(int viewID, int res){
        TextView text = findViewById(viewID);
        text.setText(res);
    }
    public void bindText(AlgebraSections algSection){
        setText(R.id.sectionTheory, algSection.theory);
    }
}

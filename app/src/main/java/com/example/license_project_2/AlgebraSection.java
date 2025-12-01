package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    private TextView taskDoneOne;
    private TextView taskDoneTwo;
    private TextView taskDoneThree;
    private Button back;
    private CheckBox checkDefinition;
    private CheckBox checkProperties;
    private CheckBox checkExamples;
    private int scorePercentage=0;

    protected void onCreate(Bundle savedInstanceState){
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algebra_section);

        AlgebraSections sectionAlg = AlgebraSections.detachFrom(getIntent());
        bindText(sectionAlg);

        theory = findViewById(R.id.sectionTheory);
        taskDoneOne = findViewById(R.id.definitionPercentage);
        taskDoneTwo = findViewById(R.id.propertiesPercentage);
        taskDoneThree = findViewById(R.id.examplesPercentage);
        back = findViewById(R.id.back);

        algebraSubject = findViewById(R.id.radioAlg);
        definition = findViewById(R.id.definition);
        properties = findViewById(R.id.properties);
        workedExamples = findViewById(R.id.workedExamples);
        quiz = findViewById(R.id.quiz);

        checkDefinition = findViewById(R.id.checkDefinition);
        checkProperties = findViewById(R.id.checkProperties);
        checkExamples = findViewById(R.id.checkExamples);

        algebraSubject.setVisibility(VISIBLE);
        definition.setVisibility(VISIBLE);
        properties.setVisibility(VISIBLE);
        workedExamples.setVisibility(VISIBLE);
        quiz.setVisibility(VISIBLE);

        checkDefinition.setVisibility(View.GONE);
        checkProperties.setVisibility(View.GONE);
        checkExamples.setVisibility(View.GONE);

        taskDoneOne.setVisibility(View.GONE);
        taskDoneTwo.setVisibility(View.GONE);
        taskDoneThree.setVisibility(View.GONE);

        checkDefinition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scorePercentage += 10;
                taskDoneOne.setVisibility(View.VISIBLE);
                taskDoneTwo.setVisibility(View.GONE);
                taskDoneThree.setVisibility(View.GONE);

                if(checkDefinition.isChecked()){
                    taskDoneOne.setVisibility(VISIBLE);
//            scorePercentage += 10;
                }
                else{
                    taskDoneOne.setVisibility(View.GONE);
                }
            }
        });

        checkProperties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scorePercentage += 10;
                taskDoneOne.setVisibility(View.GONE);
                taskDoneTwo.setVisibility(View.VISIBLE);
                taskDoneThree.setVisibility(View.GONE);

                if(checkProperties.isChecked()){
                    taskDoneTwo.setVisibility(VISIBLE);
//            scorePercentage += 10;
                }
                else{
                    taskDoneTwo.setVisibility(View.GONE);
                }
            }
        });

        checkExamples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scorePercentage += 10;
                taskDoneOne.setVisibility(View.GONE);
                taskDoneTwo.setVisibility(View.GONE);
                taskDoneThree.setVisibility(View.VISIBLE);

                if(checkExamples.isChecked()){
                    taskDoneThree.setVisibility(VISIBLE);
//            scorePercentage += 10;
                }
                else{
                    taskDoneThree.setVisibility(View.GONE);
                }
            }
        });

        algebraSubject.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(definition.isChecked()){
                    theory.setVisibility(View.VISIBLE);
                    checkDefinition.setVisibility(View.VISIBLE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);
                }
                if(properties.isChecked()){
                    theory.setVisibility(View.VISIBLE);
                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.VISIBLE);
                    checkExamples.setVisibility(View.GONE);
                }
                if(workedExamples.isChecked()){
                    theory.setVisibility(View.GONE);
                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.VISIBLE);
                }
                if(quiz.isChecked()){
                    theory.setVisibility(View.GONE);
                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);
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

package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GeometrySection extends AppCompatActivity {

    private int sectionIndex = 0;
    private Button previous;
    private Button current;
    private Button next;
    private TextView theoryDefinition;
    private TextView theoryProperties;
    private TextView theoryWorkedExamples;
    private TextView quizPrime;
    private TextView taskDoneOne;
    private TextView taskDoneTwo;
    private TextView taskDoneThree;
    private Button back;
    private CheckBox checkDefinition;
    private CheckBox checkProperties;
    private CheckBox checkExamples;
    private int scorePercentage=0;
    private ProgressManager pm;
    private String currentLessonName;

    protected void onCreate(Bundle savedInstanceState){
//        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geometry_section);

        GeometrySections sectionGeo = GeometrySections.detachFrom(getIntent());
        bindText(sectionGeo);
        pm = new ProgressManager(this);
        currentLessonName = sectionGeo.name();

        previous = findViewById(R.id.previous);
        current = findViewById(R.id.current);
        next = findViewById(R.id.next);

        theoryDefinition = findViewById(R.id.sectionDefinition);
        theoryProperties = findViewById(R.id.sectionProperties);
        theoryWorkedExamples = findViewById(R.id.sectionWorkedExamples);
        quizPrime = findViewById(R.id.sectionQuiz);

        taskDoneOne = findViewById(R.id.definitionPercentage);
        taskDoneTwo = findViewById(R.id.propertiesPercentage);
        taskDoneThree = findViewById(R.id.examplesPercentage);
        back = findViewById(R.id.back);

        checkDefinition = findViewById(R.id.checkDefinition);
        checkProperties = findViewById(R.id.checkProperties);
        checkExamples = findViewById(R.id.checkExamples);

        theoryDefinition.setVisibility(View.GONE);
        theoryProperties.setVisibility(View.GONE);
        theoryWorkedExamples.setVisibility(View.GONE);
        quizPrime.setVisibility(View.GONE);

        taskDoneOne.setVisibility(View.GONE);
        taskDoneTwo.setVisibility(View.GONE);
        taskDoneThree.setVisibility(View.GONE);

        checkDefinition.setVisibility(View.GONE);
        checkProperties.setVisibility(View.GONE);
        checkExamples.setVisibility(View.GONE);

        checkDefinition.setChecked(pm.isTaskDone(currentLessonName, "definition"));
        checkProperties.setChecked(pm.isTaskDone(currentLessonName, "properties"));
        checkExamples.setChecked(pm.isTaskDone(currentLessonName, "examples"));

        checkDefinition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scorePercentage += 10;
                taskDoneOne.setVisibility(View.VISIBLE);
                taskDoneTwo.setVisibility(View.GONE);
                taskDoneThree.setVisibility(View.GONE);

                pm.setTaskDone(currentLessonName, "definition", checkDefinition.isChecked());
                if(checkDefinition.isChecked()){
                    taskDoneOne.setVisibility(VISIBLE);
                    scorePercentage -= 10;
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

                pm.setTaskDone(currentLessonName, "properties", checkProperties.isChecked());
                if(checkProperties.isChecked()){
                    taskDoneTwo.setVisibility(VISIBLE);
                    scorePercentage -= 10;
                }
                else{
                    taskDoneTwo.setVisibility(View.GONE);
                }
            }
        });

        checkExamples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scorePercentage += 20;
                taskDoneOne.setVisibility(View.GONE);
                taskDoneTwo.setVisibility(View.GONE);
                taskDoneThree.setVisibility(View.VISIBLE);

                pm.setTaskDone(currentLessonName, "examples", checkExamples.isChecked());
                if(checkExamples.isChecked()){
                    taskDoneThree.setVisibility(VISIBLE);
                    scorePercentage -= 20;
                }
                else{
                    taskDoneThree.setVisibility(View.GONE);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sectionIndex = sectionIndex + 1;
                if(sectionIndex == 1){
                    theoryDefinition.setVisibility(View.VISIBLE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.VISIBLE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);
                }
                if(sectionIndex == 2){
                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.VISIBLE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.VISIBLE);
                    checkExamples.setVisibility(View.GONE);
                }
                if(sectionIndex == 3){
                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.VISIBLE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.VISIBLE);
                }
                if(sectionIndex == 4){
                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.VISIBLE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);
                }
                if(sectionIndex > 4){
                    sectionIndex = sectionIndex-1;
                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.VISIBLE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sectionIndex = sectionIndex - 1;
                if(sectionIndex == 1){
                    theoryDefinition.setVisibility(View.VISIBLE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.VISIBLE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);
                }
                if(sectionIndex == 2){
                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.VISIBLE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.VISIBLE);
                    checkExamples.setVisibility(View.GONE);
                }
                if(sectionIndex == 3){
                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.VISIBLE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.VISIBLE);
                }
                if(sectionIndex == 4){
                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.VISIBLE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);
                }
                if(sectionIndex < 1){
                    sectionIndex = sectionIndex+1;
                    theoryDefinition.setVisibility(View.VISIBLE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.VISIBLE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GeometrySection.this, Geometry.class));
            }
        });


    }
    public void setText(int viewID, int res){
        TextView text = findViewById(viewID);
        text.setText(res);
    }
    public void bindText(GeometrySections geoSection){
        setText(R.id.sectionDefinition, geoSection.theoryDef);
        setText(R.id.sectionProperties, geoSection.theoryProperties);
        setText(R.id.sectionWorkedExamples, geoSection.theoryWorkedExamples);
        setText(R.id.sectionQuiz, geoSection.quiz);
    }
}

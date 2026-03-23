package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.kofigyan.stateprogressbar.StateProgressBar;

public class GeometrySection extends AppCompatActivity {

    private int sectionIndex = 0;
    private Button previous;
    private Button current;
    private Button next;

    private Button answerone_1, answertwo_1, answerthree_1, answerfour_1, answerone_2,
            answertwo_2, answerthree_2, answerfour_2, answerone_3, answertwo_3,
            answerthree_3, answerfour_3, answerone_4, answertwo_4, answerthree_4,
            answerfour_4, answerone_5, answertwo_5, answerthree_5, answerfour_5;
    private TextView question1, question2, question3, question4, question5;
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

    private static final String [] parts = {"Def", "Props", "Examples", "Quiz"};
    private int index;
//    private String[] descriptionData = {"Stage 1", "Stage 2", "Stage 3", "Stage 4"};

    protected void onCreate(Bundle savedInstanceState){
//        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geometry_section);

//        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.stateProgressBar_2);
//        stateProgressBar.setStateDescriptionData(descriptionData);

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

        answerone_1 = findViewById(R.id.buttonAnswerOne); answertwo_1 = findViewById(R.id.buttonAnswerTwo);
        answerthree_1 = findViewById(R.id.buttonAnswerThree); answerfour_1 = findViewById(R.id.buttonAnswerFour);

        answerone_2 = findViewById(R.id.buttonAnswerOne_2); answertwo_2 = findViewById(R.id.buttonAnswerTwo_2);
        answerthree_2 = findViewById(R.id.buttonAnswerThree_2); answerfour_2 = findViewById(R.id.buttonAnswerFour_2);

        answerone_3 = findViewById(R.id.buttonAnswerOne_3); answertwo_3 = findViewById(R.id.buttonAnswerTwo_3);
        answerthree_3 = findViewById(R.id.buttonAnswerThree_3); answerfour_3 = findViewById(R.id.buttonAnswerFour_3);

        answerone_4 = findViewById(R.id.buttonAnswerOne_4); answertwo_4 = findViewById(R.id.buttonAnswerTwo_4);
        answerthree_4 = findViewById(R.id.buttonAnswerThree_4); answerfour_4 = findViewById(R.id.buttonAnswerFour_4);

        answerone_5 = findViewById(R.id.buttonAnswerOne_5); answertwo_5 = findViewById(R.id.buttonAnswerTwo_5);
        answerthree_5 = findViewById(R.id.buttonAnswerThree_5); answerfour_5 = findViewById(R.id.buttonAnswerFour_5);

        answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE); answerfour_1.setVisibility(View.GONE);
        answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE); answerfour_2.setVisibility(View.GONE);
        answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE); answerfour_3.setVisibility(View.GONE);
        answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE); answerfour_4.setVisibility(View.GONE);
        answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE); answerfour_5.setVisibility(View.GONE);

        question1 = findViewById(R.id.firstQuestion); question2 = findViewById(R.id.secondQuestion); question3 = findViewById(R.id.thirdQuestion);
        question4 = findViewById(R.id.fourthQuestion); question5 = findViewById(R.id.fifthQuestion);

        question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
        question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                switch(stateProgressBar.getCurrentStateNumber()){
//                    case 1:
//                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
//                        break;
//                    case 2:
//                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
//                        break;
//                    case 3:
//                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);
//                        break;
//                    case 4:
//                        stateProgressBar.setAllStatesCompleted(true);
//                        break;
//                }

                sectionIndex = sectionIndex + 1;
                if(sectionIndex == 1){
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.VISIBLE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.VISIBLE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE); answerfour_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE); answerfour_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE); answerfour_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE); answerfour_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE); answerfour_5.setVisibility(View.GONE);

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                }
                if(sectionIndex == 2){
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.VISIBLE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.VISIBLE);
                    checkExamples.setVisibility(View.GONE);

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE); answerfour_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE); answerfour_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE); answerfour_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE); answerfour_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE); answerfour_5.setVisibility(View.GONE);

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                }
                if(sectionIndex == 3){
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.VISIBLE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.VISIBLE);

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE); answerfour_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE); answerfour_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE); answerfour_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE); answerfour_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE); answerfour_5.setVisibility(View.GONE);

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                }
                if(sectionIndex == 4){
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.VISIBLE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);

                    question1.setVisibility(View.VISIBLE); question2.setVisibility(View.VISIBLE); question3.setVisibility(View.VISIBLE);
                    question4.setVisibility(View.VISIBLE); question5.setVisibility(View.VISIBLE);
                    answerone_1.setVisibility(View.VISIBLE); answertwo_1.setVisibility(View.VISIBLE); answerthree_1.setVisibility(View.VISIBLE); answerfour_1.setVisibility(View.VISIBLE);
                    answerone_2.setVisibility(View.VISIBLE); answertwo_2.setVisibility(View.VISIBLE); answerthree_2.setVisibility(View.VISIBLE); answerfour_2.setVisibility(View.VISIBLE);
                    answerone_3.setVisibility(View.VISIBLE); answertwo_3.setVisibility(View.VISIBLE); answerthree_3.setVisibility(View.VISIBLE); answerfour_3.setVisibility(View.VISIBLE);
                    answerone_4.setVisibility(View.VISIBLE); answertwo_4.setVisibility(View.VISIBLE); answerthree_4.setVisibility(View.VISIBLE); answerfour_4.setVisibility(View.VISIBLE);
                    answerone_5.setVisibility(View.VISIBLE); answertwo_5.setVisibility(View.VISIBLE); answerthree_5.setVisibility(View.VISIBLE); answerfour_5.setVisibility(View.VISIBLE);

                }
                if(sectionIndex > 4){
                    sectionIndex = sectionIndex-1;
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.VISIBLE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);

                    question1.setVisibility(View.VISIBLE); question2.setVisibility(View.VISIBLE); question3.setVisibility(View.VISIBLE);
                    question4.setVisibility(View.VISIBLE); question5.setVisibility(View.VISIBLE);
                    answerone_1.setVisibility(View.VISIBLE); answertwo_1.setVisibility(View.VISIBLE); answerthree_1.setVisibility(View.VISIBLE); answerfour_1.setVisibility(View.VISIBLE);
                    answerone_2.setVisibility(View.VISIBLE); answertwo_2.setVisibility(View.VISIBLE); answerthree_2.setVisibility(View.VISIBLE); answerfour_2.setVisibility(View.VISIBLE);
                    answerone_3.setVisibility(View.VISIBLE); answertwo_3.setVisibility(View.VISIBLE); answerthree_3.setVisibility(View.VISIBLE); answerfour_3.setVisibility(View.VISIBLE);
                    answerone_4.setVisibility(View.VISIBLE); answertwo_4.setVisibility(View.VISIBLE); answerthree_4.setVisibility(View.VISIBLE); answerfour_4.setVisibility(View.VISIBLE);
                    answerone_5.setVisibility(View.VISIBLE); answertwo_5.setVisibility(View.VISIBLE); answerthree_5.setVisibility(View.VISIBLE); answerfour_5.setVisibility(View.VISIBLE);

                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sectionIndex = sectionIndex - 1;
                if(sectionIndex == 1){
                    index = sectionIndex;
                    current.setText(parts[index - 1]);
                    theoryDefinition.setVisibility(View.VISIBLE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.VISIBLE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE); answerfour_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE); answerfour_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE); answerfour_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE); answerfour_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE); answerfour_5.setVisibility(View.GONE);

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                }
                if(sectionIndex == 2){
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.VISIBLE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.VISIBLE);
                    checkExamples.setVisibility(View.GONE);

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE); answerfour_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE); answerfour_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE); answerfour_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE); answerfour_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE); answerfour_5.setVisibility(View.GONE);

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                }
                if(sectionIndex == 3){
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.VISIBLE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.VISIBLE);

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE); answerfour_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE); answerfour_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE); answerfour_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE); answerfour_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE); answerfour_5.setVisibility(View.GONE);

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                }
                if(sectionIndex == 4){
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.GONE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.VISIBLE);

                    checkDefinition.setVisibility(View.GONE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);

                    question1.setVisibility(View.VISIBLE); question2.setVisibility(View.VISIBLE); question3.setVisibility(View.VISIBLE);
                    question4.setVisibility(View.VISIBLE); question5.setVisibility(View.VISIBLE);
                    answerone_1.setVisibility(View.VISIBLE); answertwo_1.setVisibility(View.VISIBLE); answerthree_1.setVisibility(View.VISIBLE); answerfour_1.setVisibility(View.VISIBLE);
                    answerone_2.setVisibility(View.VISIBLE); answertwo_2.setVisibility(View.VISIBLE); answerthree_2.setVisibility(View.VISIBLE); answerfour_2.setVisibility(View.VISIBLE);
                    answerone_3.setVisibility(View.VISIBLE); answertwo_3.setVisibility(View.VISIBLE); answerthree_3.setVisibility(View.VISIBLE); answerfour_3.setVisibility(View.VISIBLE);
                    answerone_4.setVisibility(View.VISIBLE); answertwo_4.setVisibility(View.VISIBLE); answerthree_4.setVisibility(View.VISIBLE); answerfour_4.setVisibility(View.VISIBLE);
                    answerone_5.setVisibility(View.VISIBLE); answertwo_5.setVisibility(View.VISIBLE); answerthree_5.setVisibility(View.VISIBLE); answerfour_5.setVisibility(View.VISIBLE);
                }
                if(sectionIndex < 1){
                    sectionIndex = sectionIndex+1;
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.VISIBLE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

                    checkDefinition.setVisibility(View.VISIBLE);
                    checkProperties.setVisibility(View.GONE);
                    checkExamples.setVisibility(View.GONE);

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE); answerfour_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE); answerfour_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE); answerfour_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE); answerfour_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE); answerfour_5.setVisibility(View.GONE);

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                }
            }
        });

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

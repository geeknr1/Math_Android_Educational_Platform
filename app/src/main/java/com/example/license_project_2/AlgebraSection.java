package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
//import com.example.license_project_2.Quiz;
//import com.example.license_project_2.Question;

import androidx.appcompat.app.AppCompatActivity;

//import com.kofigyan.stateprogressbar.StateProgressBar;

public class AlgebraSection extends AppCompatActivity {

    private int sectionIndex = 0;
    private Button current;
    private Button answerone_1, answertwo_1, answerthree_1, answerone_2,
                   answertwo_2, answerthree_2, answerone_3, answertwo_3,
                   answerthree_3, answerone_4, answertwo_4, answerthree_4,
                   answerone_5, answertwo_5, answerthree_5;
    private TextView question1, question2, question3, question4, question5;
    private TextView theoryDefinition, theoryProperties, theoryWorkedExamples, quizPrime;
    private TextView taskDoneOne, taskDoneTwo, taskDoneThree;
    private CheckBox checkDefinition, checkProperties, checkExamples;
    private int scorePercentage=0;
    private ProgressManager pm;
    private String currentLessonName;
    private static final String [] parts = {"Def", "Props", "Examples", "Quiz"};
    private int index;
    private Animation bounceAnimationThree, bounceAnimation, bounceAnimationTwo;
//    private String[] descriptionData = {"Stage 1", "Stage 2", "Stage 3", "Stage 4"};

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algebra_section);

//        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.stateProgressBar);
//        stateProgressBar.setStateDescriptionData(descriptionData);

        AlgebraSections sectionAlg = AlgebraSections.detachFrom(getIntent());
        bindText(sectionAlg);
        pm = new ProgressManager(this);
        currentLessonName = sectionAlg.name();


        theoryDefinition = findViewById(R.id.sectionDefinition);
        theoryProperties = findViewById(R.id.sectionProperties);
        theoryWorkedExamples = findViewById(R.id.sectionWorkedExamples);
        quizPrime = findViewById(R.id.sectionQuiz);

        taskDoneOne = findViewById(R.id.definitionPercentage);
        taskDoneTwo = findViewById(R.id.propertiesPercentage);
        taskDoneThree = findViewById(R.id.examplesPercentage);
        ImageButton back = findViewById(R.id.back);

        ImageButton previous = findViewById(R.id.previous);
        current = findViewById(R.id.current);
        ImageButton next = findViewById(R.id.next);

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
        answerthree_1 = findViewById(R.id.buttonAnswerThree);

        answerone_2 = findViewById(R.id.buttonAnswerOne_2); answertwo_2 = findViewById(R.id.buttonAnswerTwo_2);
        answerthree_2 = findViewById(R.id.buttonAnswerThree_2);

        answerone_3 = findViewById(R.id.buttonAnswerOne_3); answertwo_3 = findViewById(R.id.buttonAnswerTwo_3);
        answerthree_3 = findViewById(R.id.buttonAnswerThree_3);

        answerone_4 = findViewById(R.id.buttonAnswerOne_4); answertwo_4 = findViewById(R.id.buttonAnswerTwo_4);
        answerthree_4 = findViewById(R.id.buttonAnswerThree_4);

        answerone_5 = findViewById(R.id.buttonAnswerOne_5); answertwo_5 = findViewById(R.id.buttonAnswerTwo_5);
        answerthree_5 = findViewById(R.id.buttonAnswerThree_5);

        answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
        answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
        answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
        answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
        answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

        question1 = findViewById(R.id.firstQuestion); question2 = findViewById(R.id.secondQuestion); question3 = findViewById(R.id.thirdQuestion);
        question4 = findViewById(R.id.fourthQuestion); question5 = findViewById(R.id.fifthQuestion);

        question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
        question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);

        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceAnimationTwo = AnimationUtils.loadAnimation(this, R.anim.bounce);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                next.startAnimation(bounceAnimation);
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

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);
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

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

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

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

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
                    answerone_1.setVisibility(View.VISIBLE); answertwo_1.setVisibility(View.VISIBLE); answerthree_1.setVisibility(View.VISIBLE);
                    answerone_2.setVisibility(View.VISIBLE); answertwo_2.setVisibility(View.VISIBLE); answerthree_2.setVisibility(View.VISIBLE);
                    answerone_3.setVisibility(View.VISIBLE); answertwo_3.setVisibility(View.VISIBLE); answerthree_3.setVisibility(View.VISIBLE);
                    answerone_4.setVisibility(View.VISIBLE); answertwo_4.setVisibility(View.VISIBLE); answerthree_4.setVisibility(View.VISIBLE);
                    answerone_5.setVisibility(View.VISIBLE); answertwo_5.setVisibility(View.VISIBLE); answerthree_5.setVisibility(View.VISIBLE);

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
                    answerone_1.setVisibility(View.VISIBLE); answertwo_1.setVisibility(View.VISIBLE); answerthree_1.setVisibility(View.VISIBLE);
                    answerone_2.setVisibility(View.VISIBLE); answertwo_2.setVisibility(View.VISIBLE); answerthree_2.setVisibility(View.VISIBLE);
                    answerone_3.setVisibility(View.VISIBLE); answertwo_3.setVisibility(View.VISIBLE); answerthree_3.setVisibility(View.VISIBLE);
                    answerone_4.setVisibility(View.VISIBLE); answertwo_4.setVisibility(View.VISIBLE); answerthree_4.setVisibility(View.VISIBLE);
                    answerone_5.setVisibility(View.VISIBLE); answertwo_5.setVisibility(View.VISIBLE); answerthree_5.setVisibility(View.VISIBLE);
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                previous.startAnimation(bounceAnimationTwo);
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

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

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

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

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

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

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
                    answerone_1.setVisibility(View.VISIBLE); answertwo_1.setVisibility(View.VISIBLE); answerthree_1.setVisibility(View.VISIBLE);
                    answerone_2.setVisibility(View.VISIBLE); answertwo_2.setVisibility(View.VISIBLE); answerthree_2.setVisibility(View.VISIBLE);
                    answerone_3.setVisibility(View.VISIBLE); answertwo_3.setVisibility(View.VISIBLE); answerthree_3.setVisibility(View.VISIBLE);
                    answerone_4.setVisibility(View.VISIBLE); answertwo_4.setVisibility(View.VISIBLE); answerthree_4.setVisibility(View.VISIBLE);
                    answerone_5.setVisibility(View.VISIBLE); answertwo_5.setVisibility(View.VISIBLE); answerthree_5.setVisibility(View.VISIBLE);
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

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

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

        bounceAnimationThree = AnimationUtils.loadAnimation(this, R.anim.zoom);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.startAnimation(bounceAnimationThree);
                startActivity(new Intent(AlgebraSection.this, Algebra.class));
            }
        });


    }
    public void setText(int viewID, int res){
        TextView text = findViewById(viewID);
        text.setText(res);
    }
    public void bindText(AlgebraSections algSection){
        setText(R.id.sectionDefinition, algSection.theoryDef);
        setText(R.id.sectionProperties, algSection.theoryProperties);
        setText(R.id.sectionWorkedExamples, algSection.theoryWorkedExamples);
        setText(R.id.sectionQuiz, algSection.quiz);
    }
}

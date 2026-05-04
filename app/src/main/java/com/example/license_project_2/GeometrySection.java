package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.kofigyan.stateprogressbar.StateProgressBar;

public class GeometrySection extends AppCompatActivity {

    private int sectionIndex = 0;
    private Button current;

    private Button answerone_1, answertwo_1, answerthree_1, answerone_2,
            answertwo_2, answerthree_2, answerone_3, answertwo_3,
            answerthree_3, answerone_4, answertwo_4, answerthree_4,
            answerone_5, answertwo_5, answerthree_5;
    private ImageView question1, question2, question3, question4, question5;
    private TextView theoryDefinition, theoryProperties, theoryWorkedExamples, quizPrime;
    private TextView correctAnswerOne, correctAnswerTwo, correctAnswerThree, correctAnswerFour, correctAnswerFive;
    private ProgressBar progressBarOne, progressBarTwo;
    private int progressValueOne = 0, progressValueTwo = 0;
    private Animation bounceAnimation, bounceAnimationTwo, bounceAnimationThree;

    private static final String [] parts = {"Def", "Props", "Examples", "Quiz"};
    private int index;
    private ImageView definitionImgOne, definitionImgTwo, propertiesImgOne, propertiesImgTwo;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.geometry_section);

        GeometrySections sectionGeo = GeometrySections.detachFrom(getIntent());
        bindText(sectionGeo);


        ImageButton previous = findViewById(R.id.previous);
        current = findViewById(R.id.current);
        ImageButton next = findViewById(R.id.next);

        theoryDefinition = findViewById(R.id.sectionDefinition); theoryProperties = findViewById(R.id.sectionProperties);
        theoryWorkedExamples = findViewById(R.id.sectionWorkedExamples); quizPrime = findViewById(R.id.sectionQuiz);

        ImageButton back = findViewById(R.id.back);

        theoryDefinition.setVisibility(View.GONE); theoryProperties.setVisibility(View.GONE);
        theoryWorkedExamples.setVisibility(View.GONE); quizPrime.setVisibility(View.GONE);

        definitionImgOne = findViewById(R.id.imageDefOne); definitionImgTwo = findViewById(R.id.imageDefTwo);
        propertiesImgOne = findViewById(R.id.imagePropertiesOne); propertiesImgTwo = findViewById(R.id.imagePropertiesTwo);

        definitionImgOne.setVisibility(View.GONE); definitionImgTwo.setVisibility(View.GONE);
        propertiesImgOne.setVisibility(View.GONE); propertiesImgTwo.setVisibility(View.GONE);

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

        answerone_1.setText(sectionGeo.answerOne_1); answertwo_1.setText(sectionGeo.answerTwo_1); answerthree_1.setText(sectionGeo.answerThree_1);
        answerone_2.setText(sectionGeo.answerOne_2); answertwo_2.setText(sectionGeo.answerTwo_2); answerthree_2.setText(sectionGeo.answerThree_2);
        answerone_3.setText(sectionGeo.answerOne_3); answertwo_3.setText(sectionGeo.answerTwo_3); answerthree_3.setText(sectionGeo.answerThree_3);
        answerone_4.setText(sectionGeo.answerOne_4); answertwo_4.setText(sectionGeo.answerTwo_4); answerthree_4.setText(sectionGeo.answerThree_4);
        answerone_5.setText(sectionGeo.answerOne_5); answertwo_5.setText(sectionGeo.answerTwo_5); answerthree_5.setText(sectionGeo.answerThree_5);

        answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
        answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
        answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
        answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
        answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

        correctAnswerOne = findViewById(R.id.correctOne); correctAnswerTwo = findViewById(R.id.correctTwo);
        correctAnswerThree = findViewById(R.id.correctThree); correctAnswerFour = findViewById(R.id.correctFour);
        correctAnswerFive = findViewById(R.id.correctFive);
        correctAnswerOne.setText(sectionGeo.correctAnswerOne); correctAnswerTwo.setText(sectionGeo.correctAnswerTwo);
        correctAnswerThree.setText(sectionGeo.correctAnswerThree); correctAnswerFour.setText(sectionGeo.correctAnswerFour);
        correctAnswerFive.setText(sectionGeo.correctAnswerFive);

        correctAnswerOne.setVisibility(View.GONE); correctAnswerTwo.setVisibility(View.GONE); correctAnswerThree.setVisibility(View.GONE);
        correctAnswerFour.setVisibility(View.GONE); correctAnswerFive.setVisibility(View.GONE);
        
        

        question1 = findViewById(R.id.requirementOneImg); question2 = findViewById(R.id.requirementTwoImg); question3 = findViewById(R.id.requirementThreeImg);
        question4 = findViewById(R.id.requirementFourImg); question5 = findViewById(R.id.requirementFiveImg);
        
        question1.setImageResource(sectionGeo.requirementOne); question2.setImageResource(sectionGeo.requirementTwo);
        question3.setImageResource(sectionGeo.requirementThree); question4.setImageResource(sectionGeo.requirementFour);
        question5.setImageResource(sectionGeo.requirementFive);

        question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
        question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);

        progressBarOne = findViewById(R.id.progressBarGeometryTheory); progressBarTwo = findViewById(R.id.progressBarGeometryQuiz);
        progressBarOne.setVisibility(View.VISIBLE); progressBarTwo.setVisibility(View.GONE);

        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);

        answerone_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerOne.getText().toString().equals(answerone_1.getText().toString()))
                    answerone_1.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answerone_1.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answertwo_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerOne.getText().toString().equals(answertwo_1.getText().toString()))
                    answertwo_1.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answertwo_1.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answerthree_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerOne.getText().toString().equals(answerthree_1.getText().toString()))
                    answerthree_1.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answerthree_1.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answerone_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerTwo.getText().toString().equals(answerone_2.getText().toString()))
                    answerone_2.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answerone_2.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answertwo_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerTwo.getText().toString().equals(answertwo_2.getText().toString()))
                    answertwo_2.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answertwo_2.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answerthree_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerTwo.getText().toString().equals(answerthree_2.getText().toString()))
                    answerthree_2.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answerthree_2.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answerone_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerThree.getText().toString().equals(answerone_3.getText().toString()))
                    answerone_3.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answerone_3.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answertwo_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerThree.getText().toString().equals(answertwo_3.getText().toString()))
                    answertwo_3.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answertwo_3.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answerthree_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerThree.getText().toString().equals(answerthree_3.getText().toString()))
                    answerthree_3.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answerthree_3.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answerone_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerFour.getText().toString().equals(answerone_4.getText().toString()))
                    answerone_4.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answerone_4.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answertwo_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerFour.getText().toString().equals(answertwo_4.getText().toString()))
                    answertwo_4.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answertwo_4.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answerthree_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerFour.getText().toString().equals(answerthree_4.getText().toString()))
                    answerthree_4.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answerthree_4.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answerone_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerFive.getText().toString().equals(answerone_5.getText().toString()))
                    answerone_5.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answerone_5.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answertwo_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerFive.getText().toString().equals(answertwo_5.getText().toString()))
                    answertwo_5.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answertwo_5.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        answerthree_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswerFive.getText().toString().equals(answerthree_5.getText().toString()))
                    answerthree_5.setBackgroundColor(getResources().getColor(R.color.blue));
                else
                    answerthree_5.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(progressValueOne < 100 && sectionIndex != 3){
                    progressValueOne += 25;
                    progressBarOne.setProgress(progressValueOne);
                } else if (progressValueOne < 100 & sectionIndex >= 3) {
                    progressValueOne += 50;
                    progressBarOne.setProgress(progressValueOne);
                }

                next.startAnimation(bounceAnimation);
                sectionIndex = sectionIndex + 1;
                if(sectionIndex == 1){
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.VISIBLE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

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

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

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

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

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

        bounceAnimationTwo =  AnimationUtils.loadAnimation(this, R.anim.bounce);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sectionIndex == 4 && progressValueOne > 0){
                    progressValueOne -= 50;
                    progressBarOne.setProgress(progressValueOne);
                }
                else{
                    progressValueOne -= 25;
                    progressBarOne.setProgress(progressValueOne);
                }

                previous.startAnimation(bounceAnimationTwo);
                sectionIndex = sectionIndex - 1;
                if(sectionIndex == 1){
                    index = sectionIndex;
                    current.setText(parts[index - 1]);
                    theoryDefinition.setVisibility(View.VISIBLE);
                    theoryProperties.setVisibility(View.GONE);
                    theoryWorkedExamples.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

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

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

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

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

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

                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                }
            }
        });

        bounceAnimationThree = AnimationUtils.loadAnimation(this, R.anim.bounce);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerone_1.setBackgroundColor(getResources().getColor(R.color.black));
                answertwo_1.setBackgroundColor(getResources().getColor(R.color.black));
                answerthree_1.setBackgroundColor(getResources().getColor(R.color.black));
                answerone_2.setBackgroundColor(getResources().getColor(R.color.black));
                answertwo_2.setBackgroundColor(getResources().getColor(R.color.black));
                answerthree_2.setBackgroundColor(getResources().getColor(R.color.black));
                answerone_3.setBackgroundColor(getResources().getColor(R.color.black));
                answertwo_3.setBackgroundColor(getResources().getColor(R.color.black));
                answerthree_3.setBackgroundColor(getResources().getColor(R.color.black));
                answerone_4.setBackgroundColor(getResources().getColor(R.color.black));
                answertwo_4.setBackgroundColor(getResources().getColor(R.color.black));
                answerthree_4.setBackgroundColor(getResources().getColor(R.color.black));
                answerone_5.setBackgroundColor(getResources().getColor(R.color.black));
                answertwo_5.setBackgroundColor(getResources().getColor(R.color.black));
                answerthree_5.setBackgroundColor(getResources().getColor(R.color.black));
                back.startAnimation(bounceAnimationThree);
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

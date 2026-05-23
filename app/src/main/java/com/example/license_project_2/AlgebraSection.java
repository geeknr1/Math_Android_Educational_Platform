package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
//import com.example.license_project_2.Quiz;
//import com.example.license_project_2.Question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

//import com.kofigyan.stateprogressbar.StateProgressBar;

public class AlgebraSection extends AppCompatActivity {

    private int sectionIndex = 0;
    private int[] counterOne = {0}, counterTwo = {0} , counterThree = {0} ,
                counterFour = {0}, counterFive = {0}, counterSix = {0}, counterSeven = {0}, counterEight = {0};
    private Button current;
    private Button answerone_1, answertwo_1, answerthree_1, answerone_2,
                   answertwo_2, answerthree_2, answerone_3, answertwo_3,
                   answerthree_3, answerone_4, answertwo_4, answerthree_4,
                   answerone_5, answertwo_5, answerthree_5;
    private ImageView question1, question2, question3, question4, question5;
    private TextView theoryDefinition, theoryProperties, theoryWorkedExamples, quizPrime;
    private ProgressBar progressBarOne, progressBarTwo;
    private int progressValueOne = 0, progressValueTwo = 0;
    private String currentLessonName;
    private static final String [] parts = {"Def", "Props", "Examples", "Quiz"};
    private int index;
    private TextView correctAnswerOne, correctAnswerTwo, correctAnswerThree, correctAnswerFour, correctAnswerFive,
                     correctAnswerDefinition, correctAnswerProperties, correctAnswerExample;
    private Animation bounceAnimationThree, bounceAnimation, bounceAnimationTwo;
    private TextView defQuestion, propsQuestion, exampleQuestion;
    private Button defAnswerOne, defAnswerTwo, defAnswerThree, propsAnswerOne, propsAnswerTwo, propsAnswerThree, exampleAnswerOne, exampleAnswerTwo, exampleAnswerThree;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.algebra_section);

        AlgebraSections sectionAlg = AlgebraSections.detachFrom(getIntent());
        bindText(sectionAlg);
        currentLessonName = sectionAlg.name();


        theoryDefinition = findViewById(R.id.sectionDefinition);
        defQuestion = findViewById(R.id.sectionDefQuestion);
        defAnswerOne = findViewById(R.id.buttonAnswerDefOne);
        defAnswerTwo = findViewById(R.id.buttonAnswerDefTwo);
        defAnswerThree = findViewById(R.id.buttonAnswerDefThree);
        correctAnswerDefinition = findViewById(R.id.correctDefinition);
        defQuestion.setText(sectionAlg.theoryDefQuestion);
        defAnswerOne.setText(sectionAlg.theoryDefAnswerOne);
        defAnswerTwo.setText(sectionAlg.theoryDefAnswerTwo);
        defAnswerThree.setText(sectionAlg.theoryDefAnswerThree);
        correctAnswerDefinition.setText(sectionAlg.theoryDefCorrect);
        correctAnswerDefinition.setVisibility(View.GONE);


        theoryProperties = findViewById(R.id.sectionProperties);
        propsQuestion = findViewById(R.id.sectionPropsQuestion);
        propsAnswerOne = findViewById(R.id.buttonAnswerPropsOne);
        propsAnswerTwo = findViewById(R.id.buttonAnswerPropsTwo);
        propsAnswerThree = findViewById(R.id.buttonAnswerPropsThree);
        correctAnswerProperties = findViewById(R.id.correctProperties);
        propsQuestion.setText(sectionAlg.theoryPropsQuestion);
        propsAnswerOne.setText(sectionAlg.theoryPropsAnswerOne);
        propsAnswerTwo.setText(sectionAlg.theoryPropsAnswerTwo);
        propsAnswerThree.setText(sectionAlg.theoryPropsAnswerThree);
        correctAnswerProperties.setText(sectionAlg.theoryPropsCorrect);
        correctAnswerProperties.setVisibility(View.GONE);

        theoryWorkedExamples = findViewById(R.id.sectionWorkedExamples);
        exampleQuestion = findViewById(R.id.sectionExampleQuestion);
        exampleAnswerOne = findViewById(R.id.buttonAnswerExampleOne);
        exampleAnswerTwo = findViewById(R.id.buttonAnswerExampleTwo);
        exampleAnswerThree = findViewById(R.id.buttonAnswerExampleThree);
        correctAnswerExample = findViewById(R.id.correctExample);
        exampleQuestion.setText(sectionAlg.theoryExampleQuestion);
        exampleAnswerOne.setText(sectionAlg.theoryExampleAnswerOne);
        exampleAnswerTwo.setText(sectionAlg.theoryExampleAnswerTwo);
        exampleAnswerThree.setText(sectionAlg.theoryExampleAnswerThree);
        correctAnswerExample.setText(sectionAlg.theoryExampleCorrect);
        correctAnswerExample.setVisibility(View.GONE);

        quizPrime = findViewById(R.id.sectionQuiz);


        ImageButton back = findViewById(R.id.back);
        ImageButton previous = findViewById(R.id.previous);
        current = findViewById(R.id.current);
        ImageButton next = findViewById(R.id.next);

        theoryDefinition.setVisibility(View.GONE);
        defQuestion.setVisibility(View.GONE);
        defAnswerOne.setVisibility(View.GONE);
        defAnswerTwo.setVisibility(View.GONE);
        defAnswerThree.setVisibility(View.GONE);

        theoryProperties.setVisibility(View.GONE);
        propsQuestion.setVisibility(View.GONE);
        propsAnswerOne.setVisibility(View.GONE);
        propsAnswerTwo.setVisibility(View.GONE);
        propsAnswerThree.setVisibility(View.GONE);

        theoryWorkedExamples.setVisibility(View.GONE);
        exampleQuestion.setVisibility(View.GONE);
        exampleAnswerOne.setVisibility(View.GONE);
        exampleAnswerTwo.setVisibility(View.GONE);
        exampleAnswerThree.setVisibility(View.GONE);

        quizPrime.setVisibility(View.GONE);

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

        correctAnswerOne = findViewById(R.id.correctOne); correctAnswerTwo = findViewById(R.id.correctTwo);
        correctAnswerThree = findViewById(R.id.correctThree); correctAnswerFour = findViewById(R.id.correctFour);
        correctAnswerFive = findViewById(R.id.correctFive);

        answerone_1.setText(sectionAlg.answerOne_1); answertwo_1.setText(sectionAlg.answerTwo_1); answerthree_1.setText(sectionAlg.answerThree_1);
        answerone_2.setText(sectionAlg.answerOne_2); answertwo_2.setText(sectionAlg.answerTwo_2); answerthree_2.setText(sectionAlg.answerThree_2);
        answerone_3.setText(sectionAlg.answerOne_3); answertwo_3.setText(sectionAlg.answerTwo_3); answerthree_3.setText(sectionAlg.answerThree_3);
        answerone_4.setText(sectionAlg.answerOne_4); answertwo_4.setText(sectionAlg.answerTwo_4); answerthree_4.setText(sectionAlg.answerThree_4);
        answerone_5.setText(sectionAlg.answerOne_5); answertwo_5.setText(sectionAlg.answerTwo_5); answerthree_5.setText(sectionAlg.answerThree_5);
        correctAnswerOne.setText(sectionAlg.correctAnswerOne); correctAnswerTwo.setText(sectionAlg.correctAnswerTwo);
        correctAnswerThree.setText(sectionAlg.correctAnswerThree); correctAnswerFour.setText(sectionAlg.correctAnswerFour);
        correctAnswerFive.setText(sectionAlg.correctAnswerFive);

        answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
        answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
        answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
        answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
        answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

        correctAnswerOne.setVisibility(View.GONE); correctAnswerTwo.setVisibility(View.GONE); correctAnswerThree.setVisibility(View.GONE);
        correctAnswerFour.setVisibility(View.GONE); correctAnswerFive.setVisibility(View.GONE);

        question1 = findViewById(R.id.requirementOneImg); question2 = findViewById(R.id.requirementTwoImg); question3 = findViewById(R.id.requirementThreeImg);
        question4 = findViewById(R.id.requirementFourImg); question5 = findViewById(R.id.requirementFiveImg);

        question1.setImageResource(sectionAlg.requirementOne); question2.setImageResource(sectionAlg.requirementTwo); question3.setImageResource(sectionAlg.requirementThree);
        question4.setImageResource(sectionAlg.requirementFour); question5.setImageResource(sectionAlg.requirementFive);
        question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
        question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);

        progressBarOne = findViewById(R.id.progressBarAlgebraTheory); progressBarTwo = findViewById(R.id.progressBarAlgebraQuiz);
        progressBarOne.setVisibility(View.VISIBLE); progressBarTwo.setVisibility(View.GONE);

        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceAnimationTwo = AnimationUtils.loadAnimation(this, R.anim.bounce);

        answerone_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterOne, answerone_1, correctAnswerOne);
            }
        });

        answertwo_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterOne, answertwo_1, correctAnswerOne);
            }
        });

        answerthree_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterOne, answerthree_1, correctAnswerOne);
            }
        });

        answerone_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterTwo, answerone_2, correctAnswerTwo);
            }
        });

        answertwo_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterTwo, answertwo_2, correctAnswerTwo);
            }
        });

        answerthree_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterTwo, answerthree_2, correctAnswerTwo);
            }
        });

        answerone_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterThree, answerone_3, correctAnswerThree);
            }
        });

        answertwo_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterThree, answertwo_3, correctAnswerThree);
            }
        });

        answerthree_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterThree, answerthree_3, correctAnswerThree);
            }
        });

        answerone_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterFour, answerone_4, correctAnswerFour);
            }
        });

        answertwo_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterFour, answertwo_4, correctAnswerFour);
            }
        });

        answerthree_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterFour, answerthree_4, correctAnswerFour);
            }
        });

        answerone_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterFive, answerone_5, correctAnswerFive);
            }
        });

        answertwo_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterFive, answertwo_5, correctAnswerFive);
            }
        });

        answerthree_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterFive, answerthree_5, correctAnswerFive);
            }
        });

        defAnswerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterSix, defAnswerOne, correctAnswerDefinition);
            }
        });

        defAnswerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterSix, defAnswerTwo, correctAnswerDefinition);
            }
        });

        defAnswerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterSix, defAnswerThree, correctAnswerDefinition);
            }
        });

        propsAnswerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterSeven, propsAnswerOne, correctAnswerProperties);
            }
        });

        propsAnswerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterSeven, propsAnswerTwo, correctAnswerProperties);
            }
        });

        propsAnswerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterSeven, propsAnswerThree, correctAnswerProperties);
            }
        });

        exampleAnswerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterEight, exampleAnswerOne, correctAnswerExample);
            }
        });

        exampleAnswerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterEight, exampleAnswerTwo, correctAnswerExample);
            }
        });

        exampleAnswerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerButton(counterEight, exampleAnswerThree, correctAnswerExample);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                next.startAnimation(bounceAnimation);
                sectionIndex = sectionIndex + 1;
                if(sectionIndex == 1){
                    counterSix[0] = 0;
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.VISIBLE);
                    defQuestion.setVisibility(View.VISIBLE);
                    defAnswerOne.setVisibility(View.VISIBLE);
                    defAnswerTwo.setVisibility(View.VISIBLE);
                    defAnswerThree.setVisibility(View.VISIBLE);
                    defAnswerOne.setBackgroundColor(getResources().getColor(R.color.black));
                    defAnswerTwo.setBackgroundColor(getResources().getColor(R.color.black));
                    defAnswerThree.setBackgroundColor(getResources().getColor(R.color.black));

                    theoryProperties.setVisibility(View.GONE);
                    propsQuestion.setVisibility(View.GONE);
                    propsAnswerOne.setVisibility(View.GONE);
                    propsAnswerTwo.setVisibility(View.GONE);
                    propsAnswerThree.setVisibility(View.GONE);

                    theoryWorkedExamples.setVisibility(View.GONE);
                    exampleQuestion.setVisibility(View.GONE);
                    exampleAnswerOne.setVisibility(View.GONE);
                    exampleAnswerTwo.setVisibility(View.GONE);
                    exampleAnswerThree.setVisibility(View.GONE);

                    quizPrime.setVisibility(View.GONE);

                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);
                }
                if(sectionIndex == 2){
                    counterSeven[0] = 0;
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.GONE);
                    defQuestion.setVisibility(View.GONE);
                    defAnswerOne.setVisibility(View.GONE);
                    defAnswerTwo.setVisibility(View.GONE);
                    defAnswerThree.setVisibility(View.GONE);

                    theoryProperties.setVisibility(View.VISIBLE);
                    propsQuestion.setVisibility(View.VISIBLE);
                    propsAnswerOne.setVisibility(View.VISIBLE);
                    propsAnswerTwo.setVisibility(View.VISIBLE);
                    propsAnswerThree.setVisibility(View.VISIBLE);
                    propsAnswerOne.setBackgroundColor(getResources().getColor(R.color.black));
                    propsAnswerTwo.setBackgroundColor(getResources().getColor(R.color.black));
                    propsAnswerThree.setBackgroundColor(getResources().getColor(R.color.black));

                    theoryWorkedExamples.setVisibility(View.GONE);
                    exampleQuestion.setVisibility(View.GONE);
                    exampleAnswerOne.setVisibility(View.GONE);
                    exampleAnswerTwo.setVisibility(View.GONE);
                    exampleAnswerThree.setVisibility(View.GONE);

                    quizPrime.setVisibility(View.GONE);


                    question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
                    question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);
                    answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
                    answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
                    answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
                    answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
                    answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

                }
                if(sectionIndex == 3){
                    counterEight[0] = 0;
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.GONE);
                    defQuestion.setVisibility(View.GONE);
                    defAnswerOne.setVisibility(View.GONE);
                    defAnswerTwo.setVisibility(View.GONE);
                    defAnswerThree.setVisibility(View.GONE);

                    theoryProperties.setVisibility(View.GONE);
                    propsQuestion.setVisibility(View.GONE);
                    propsAnswerOne.setVisibility(View.GONE);
                    propsAnswerTwo.setVisibility(View.GONE);
                    propsAnswerThree.setVisibility(View.GONE);

                    theoryWorkedExamples.setVisibility(View.VISIBLE);
                    exampleQuestion.setVisibility(View.VISIBLE);
                    exampleAnswerOne.setVisibility(View.VISIBLE);
                    exampleAnswerTwo.setVisibility(View.VISIBLE);
                    exampleAnswerThree.setVisibility(View.VISIBLE);
                    exampleAnswerOne.setBackgroundColor(getResources().getColor(R.color.black));
                    exampleAnswerTwo.setBackgroundColor(getResources().getColor(R.color.black));
                    exampleAnswerThree.setBackgroundColor(getResources().getColor(R.color.black));
                    quizPrime.setVisibility(View.GONE);

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
                    defQuestion.setVisibility(View.GONE);
                    defAnswerOne.setVisibility(View.GONE);
                    defAnswerTwo.setVisibility(View.GONE);
                    defAnswerThree.setVisibility(View.GONE);

                    theoryProperties.setVisibility(View.GONE);
                    propsQuestion.setVisibility(View.GONE);
                    propsAnswerOne.setVisibility(View.GONE);
                    propsAnswerTwo.setVisibility(View.GONE);
                    propsAnswerThree.setVisibility(View.GONE);

                    theoryWorkedExamples.setVisibility(View.GONE);
                    exampleQuestion.setVisibility(View.GONE);
                    exampleAnswerOne.setVisibility(View.GONE);
                    exampleAnswerTwo.setVisibility(View.GONE);
                    exampleAnswerThree.setVisibility(View.GONE);

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
                    defQuestion.setVisibility(View.GONE);
                    defAnswerOne.setVisibility(View.GONE);
                    defAnswerTwo.setVisibility(View.GONE);
                    defAnswerThree.setVisibility(View.GONE);

                    theoryProperties.setVisibility(View.GONE);
                    propsQuestion.setVisibility(View.GONE);
                    propsAnswerOne.setVisibility(View.GONE);
                    propsAnswerTwo.setVisibility(View.GONE);
                    propsAnswerThree.setVisibility(View.GONE);

                    theoryWorkedExamples.setVisibility(View.GONE);
                    exampleQuestion.setVisibility(View.GONE);
                    exampleAnswerOne.setVisibility(View.GONE);
                    exampleAnswerTwo.setVisibility(View.GONE);
                    exampleAnswerThree.setVisibility(View.GONE);
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

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(sectionIndex == 4 && progressValueOne > 0){
//                    progressValueOne -= 50;
//                    progressBarOne.setProgress(progressValueOne);
//                }
//                else{
//                    progressValueOne -= 25;
//                    progressBarOne.setProgress(progressValueOne);
//                }
                previous.startAnimation(bounceAnimationTwo);
                sectionIndex = sectionIndex - 1;
                if(sectionIndex == 1){
                    index = sectionIndex;
                    current.setText(parts[index - 1]);

                    theoryDefinition.setVisibility(View.VISIBLE);
                    defQuestion.setVisibility(View.VISIBLE);
                    defAnswerOne.setVisibility(View.VISIBLE);
                    defAnswerTwo.setVisibility(View.VISIBLE);
                    defAnswerThree.setVisibility(View.VISIBLE);

                    theoryProperties.setVisibility(View.GONE);
                    propsQuestion.setVisibility(View.GONE);
                    propsAnswerOne.setVisibility(View.GONE);
                    propsAnswerTwo.setVisibility(View.GONE);
                    propsAnswerThree.setVisibility(View.GONE);

                    theoryWorkedExamples.setVisibility(View.GONE);
                    exampleQuestion.setVisibility(View.GONE);
                    exampleAnswerOne.setVisibility(View.GONE);
                    exampleAnswerTwo.setVisibility(View.GONE);
                    exampleAnswerThree.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

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
                    defQuestion.setVisibility(View.GONE);
                    defAnswerOne.setVisibility(View.GONE);
                    defAnswerTwo.setVisibility(View.GONE);
                    defAnswerThree.setVisibility(View.GONE);

                    theoryProperties.setVisibility(View.VISIBLE);
                    propsQuestion.setVisibility(View.VISIBLE);
                    propsAnswerOne.setVisibility(View.VISIBLE);
                    propsAnswerTwo.setVisibility(View.VISIBLE);
                    propsAnswerThree.setVisibility(View.VISIBLE);

                    theoryWorkedExamples.setVisibility(View.GONE);
                    exampleQuestion.setVisibility(View.GONE);
                    exampleAnswerOne.setVisibility(View.GONE);
                    exampleAnswerTwo.setVisibility(View.GONE);
                    exampleAnswerThree.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

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
                    defQuestion.setVisibility(View.GONE);
                    defAnswerOne.setVisibility(View.GONE);
                    defAnswerTwo.setVisibility(View.GONE);
                    defAnswerThree.setVisibility(View.GONE);

                    theoryProperties.setVisibility(View.GONE);
                    propsQuestion.setVisibility(View.GONE);
                    propsAnswerOne.setVisibility(View.GONE);
                    propsAnswerTwo.setVisibility(View.GONE);
                    propsAnswerThree.setVisibility(View.GONE);

                    theoryWorkedExamples.setVisibility(View.VISIBLE);
                    exampleQuestion.setVisibility(View.VISIBLE);
                    exampleAnswerOne.setVisibility(View.VISIBLE);
                    exampleAnswerTwo.setVisibility(View.VISIBLE);
                    exampleAnswerThree.setVisibility(View.VISIBLE);
                    quizPrime.setVisibility(View.GONE);

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
                    defQuestion.setVisibility(View.GONE);
                    defAnswerOne.setVisibility(View.GONE);
                    defAnswerTwo.setVisibility(View.GONE);
                    defAnswerThree.setVisibility(View.GONE);

                    theoryProperties.setVisibility(View.GONE);
                    propsQuestion.setVisibility(View.GONE);
                    propsAnswerOne.setVisibility(View.GONE);
                    propsAnswerTwo.setVisibility(View.GONE);
                    propsAnswerThree.setVisibility(View.GONE);

                    theoryWorkedExamples.setVisibility(View.GONE);
                    exampleQuestion.setVisibility(View.GONE);
                    exampleAnswerOne.setVisibility(View.GONE);
                    exampleAnswerTwo.setVisibility(View.GONE);
                    exampleAnswerThree.setVisibility(View.GONE);
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

                    theoryDefinition.setVisibility(View.GONE);
                    defQuestion.setVisibility(View.GONE);
                    defAnswerOne.setVisibility(View.GONE);
                    defAnswerTwo.setVisibility(View.GONE);
                    defAnswerThree.setVisibility(View.GONE);

                    theoryProperties.setVisibility(View.GONE);
                    propsQuestion.setVisibility(View.GONE);
                    propsAnswerOne.setVisibility(View.GONE);
                    propsAnswerTwo.setVisibility(View.GONE);
                    propsAnswerThree.setVisibility(View.GONE);

                    theoryWorkedExamples.setVisibility(View.GONE);
                    exampleQuestion.setVisibility(View.GONE);
                    exampleAnswerOne.setVisibility(View.GONE);
                    exampleAnswerTwo.setVisibility(View.GONE);
                    exampleAnswerThree.setVisibility(View.GONE);
                    quizPrime.setVisibility(View.GONE);

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

        bounceAnimationThree = AnimationUtils.loadAnimation(this, R.anim.zoom);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterOne = new int[]{0};
                counterTwo = new int[]{0};
                counterThree = new int[]{0};
                counterFour = new int[]{0};
                counterFive = new int[]{0};
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
                progressValueOne = progressValueTwo = 0;
                progressBarOne.setProgress(progressValueOne); progressBarTwo.setProgress(progressValueTwo);
                back.startAnimation(bounceAnimationThree);
                startActivity(new Intent(AlgebraSection.this, Algebra.class));
            }
        });

        System.out.println(String.valueOf(answerone_1));
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

    public void checkAnswerButton(int[] counterX, Button buttonX, TextView correctAnswerX){
        counterX[0]++;
        if(counterX[0] == 1 && correctAnswerX.getText().toString().equals(buttonX.getText().toString())){
            counterX[0]++;
                buttonX.setBackgroundColor(getResources().getColor(R.color.blue));
                if(progressValueOne < 100 && sectionIndex != 3){
                    progressValueOne += 25;
                    progressBarOne.setProgress(progressValueOne);
                } else if (progressValueOne < 100 & sectionIndex >= 3) {
                    progressValueOne += 50;
                    progressBarOne.setProgress(progressValueOne);
                }
            }
        else if(counterX[0] == 1 && !(correctAnswerX.getText().toString().equals(buttonX.getText().toString()))){
                counterX[0]++;
                buttonX.setBackgroundColor(getResources().getColor(R.color.red));
                sectionIndex -= 1;
            }
        else if(counterX[0] > 1) {
            buttonX.setBackgroundColor(getResources().getColor(R.color.black));
//            if (buttonX.getBackground() instanceof ColorDrawable) {
//                ColorDrawable colorDrawable = (ColorDrawable) buttonX.getBackground();
//                int colorCode = colorDrawable.getColor();
//                int colorBlue = ContextCompat.getColor(buttonX.getContext(), R.color.blue);
//                if (colorCode == colorBlue) {
//                    buttonX.setBackgroundColor(getResources().getColor(R.color.blue));
//                }
//            }
        }


    }

}

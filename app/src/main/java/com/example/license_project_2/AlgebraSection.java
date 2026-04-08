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
import android.widget.ImageView;
import android.widget.ProgressBar;
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
    private ImageView question1, question2, question3, question4, question5;
    private TextView theoryDefinition, theoryProperties, theoryWorkedExamples, quizPrime;
    private ProgressBar progressBarOne, progressBarTwo;
    private int progressValueOne = 0, progressValueTwo = 0;
    private ProgressManager pm;
    private String currentLessonName;
    private static final String [] parts = {"Def", "Props", "Examples", "Quiz"};
    private int index;
    private String correctAnswerOne, correctAnswerTwo, correctAnswerThree, correctAnswerFour, correctAnswerFive;
    private String answeroneQuestionOne, answertwoQuestionOne, answerthreeQuestionOne, answeroneQuestionTwo, answertwoQuestionTwo, answerthreeQuestionTwo,
            answeroneQuestionThree, answertwoQuestionThree, answerthreeQuestionThree, answeroneQuestionFour, answertwoQuestionFour, answerthreeQuestionFour,
            answeroneQuestionFive, answertwoQuestionFive, answerthreeQuestionFive;
    private Animation bounceAnimationThree, bounceAnimation, bounceAnimationTwo;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algebra_section);

        AlgebraSections sectionAlg = AlgebraSections.detachFrom(getIntent());
        bindText(sectionAlg);
        pm = new ProgressManager(this);
        currentLessonName = sectionAlg.name();


        theoryDefinition = findViewById(R.id.sectionDefinition);
        theoryProperties = findViewById(R.id.sectionProperties);
        theoryWorkedExamples = findViewById(R.id.sectionWorkedExamples);
        quizPrime = findViewById(R.id.sectionQuiz);


        ImageButton back = findViewById(R.id.back);
        ImageButton previous = findViewById(R.id.previous);
        current = findViewById(R.id.current);
        ImageButton next = findViewById(R.id.next);

        theoryDefinition.setVisibility(View.GONE);
        theoryProperties.setVisibility(View.GONE);
        theoryWorkedExamples.setVisibility(View.GONE);
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

        answerone_1.setText(answeroneQuestionOne); answertwo_1.setText(answertwoQuestionOne); answerthree_1.setText(answerthreeQuestionOne);
        answerone_2.setText(answeroneQuestionTwo); answertwo_2.setText(answertwoQuestionTwo); answerthree_2.setText(answerthreeQuestionTwo);
        answerone_3.setText(answeroneQuestionThree); answertwo_3.setText(answertwoQuestionThree); answerthree_3.setText(answerthreeQuestionThree);
        answerone_4.setText(answeroneQuestionFour); answertwo_4.setText(answertwoQuestionFour); answerthree_4.setText(answerthreeQuestionFour);
        answerone_5.setText(answeroneQuestionFive); answertwo_5.setText(answertwoQuestionFive); answerthree_5.setText(answerthreeQuestionFive);

        answerone_1.setVisibility(View.GONE); answertwo_1.setVisibility(View.GONE); answerthree_1.setVisibility(View.GONE);
        answerone_2.setVisibility(View.GONE); answertwo_2.setVisibility(View.GONE); answerthree_2.setVisibility(View.GONE);
        answerone_3.setVisibility(View.GONE); answertwo_3.setVisibility(View.GONE); answerthree_3.setVisibility(View.GONE);
        answerone_4.setVisibility(View.GONE); answertwo_4.setVisibility(View.GONE); answerthree_4.setVisibility(View.GONE);
        answerone_5.setVisibility(View.GONE); answertwo_5.setVisibility(View.GONE); answerthree_5.setVisibility(View.GONE);

        question1 = findViewById(R.id.requirementOneImg); question2 = findViewById(R.id.requirementTwoImg); question3 = findViewById(R.id.requirementThreeImg);
        question4 = findViewById(R.id.requirementFourImg); question5 = findViewById(R.id.requirementFiveImg);

        question1.setVisibility(View.GONE); question2.setVisibility(View.GONE); question3.setVisibility(View.GONE);
        question4.setVisibility(View.GONE); question5.setVisibility(View.GONE);

        progressBarOne = findViewById(R.id.progressBarAlgebraTheory); progressBarTwo = findViewById(R.id.progressBarAlgebraQuiz);
        progressBarOne.setVisibility(View.VISIBLE); progressBarTwo.setVisibility(View.GONE);

        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bounceAnimationTwo = AnimationUtils.loadAnimation(this, R.anim.bounce);

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
                progressValueOne = progressValueTwo = 0;
                progressBarOne.setProgress(progressValueOne); progressBarTwo.setProgress(progressValueTwo);
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

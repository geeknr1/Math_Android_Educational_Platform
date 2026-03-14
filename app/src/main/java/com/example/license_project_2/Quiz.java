//package com.example.license_project_2;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.TextView;
//import com.example.license_project_2.Questions;
//import com.example.license_project_2.Question;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//
//public class Quiz extends AppCompatActivity {
//    private Button answerOne;
//    private Button answerTwo;
//    private Button answerThree;
//    private Button answerFour;
//    private boolean truthValueOne;
//    private boolean truthValueTwo;
//    private boolean truthValueThree;
//    private boolean truthValueFour;
//    private ImageButton previousQuestion;
//    private ImageButton nextQuestion;
//    private TextView question;
//    private TextView answer;
//    private int correct = 0;
//    private int questionIndex = 0;
//    private Questions questions;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.quiz);
//
//        // Initializing UI elements
//        answerOne = findViewById(R.id.firstResponse);
//        answerTwo = findViewById(R.id.secondResponse);
//        answerThree = findViewById(R.id.thirdResponse);
//        answerFour = findViewById(R.id.fourthResponse);
//        previousQuestion = findViewById(R.id.previousQuestion);
//        nextQuestion = findViewById(R.id.nextQuestion);
//        question = findViewById(R.id.questionText);
//        answer = findViewById(R.id.statement);
//
//        // Hide the answer text initially
//        answer.setVisibility(View.INVISIBLE);
//
//        // Load the first question
//        updateQuestion();
//
//        // Button click listeners
//        answerOne.setOnClickListener(v -> checkAnswer(truthValueOne));
//        answerTwo.setOnClickListener(v -> checkAnswer(truthValueTwo));
//        answerThree.setOnClickListener(v -> checkAnswer(truthValueThree));
//        answerFour.setOnClickListener(v -> checkAnswer(truthValueFour));
//
//        nextQuestion.setOnClickListener(v -> {
//            answer.setVisibility(View.INVISIBLE);
//
//            // Check if there are more questions
//            if (questionIndex < 6) {
//                questionIndex++;
//
//                // If all questions are completed, display the score
//                if (questionIndex == 5) {
//                    nextQuestion.setVisibility(View.GONE);
//                    previousQuestion.setVisibility(View.GONE);
//                    answerOne.setVisibility(View.GONE);
//                    answerTwo.setVisibility(View.GONE);
//                    answerThree.setVisibility(View.GONE);
//                    answerFour.setVisibility(View.GONE);
//
//                    question.setText("Your Score: " + correct + "/6");
//                } else {
//                    updateQuestion();
//                }
//            }
//        });
//
//        previousQuestion.setOnClickListener(v -> {
//            answer.setVisibility(View.INVISIBLE);
//
//            // Prevent going back before the first question
//            if (questionIndex > 0) {
//                questionIndex = (questionIndex - 1) % 5;
//                updateQuestion();
//            }
//        });
//    }
//
//    // Updates the displayed question
//    private void updateQuestion() {
//        Question current = questions.questionArray().get(questionIndex);
//        question.setText(current.getQuestionRequirement());
//    }
//
//    // Checks the user's answer and updates the UI
//    private void checkAnswer(boolean chooseCorrect) {
//        Question currentQuestion = questions.questionArray().get(questionIndex);
//        boolean answerIsTrue = currentQuestion.getCorrectAnswer();
//        String message;
//
//        if (chooseCorrect == answerIsTrue) {
//            message = "Correct";
//            correct++;
//        } else {
//            message = "Incorrect";
//        }
//
//        // Display feedback message
//        answer.setVisibility(View.VISIBLE);
//        answer.setText(message);
//    }
//}
//

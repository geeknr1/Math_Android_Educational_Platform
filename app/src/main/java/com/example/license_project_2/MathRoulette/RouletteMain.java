package com.example.license_project_2.MathRoulette;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.license_project_2.Games;
import com.example.license_project_2.R;

import java.util.Random;

public class RouletteMain extends AppCompatActivity {
    private static final String[] sectors = {"Algebra","Geometry","Calculus","Trigonometry"};
    private static final String[] algebraProblems = {"Solve: x^2+5x+6 = 0", "Factor the quadratic equation x^2 - 5x + 6 = 0.", "Factor the quadratic equation x^2 - 4x + 4 = 0.", "Solve the inequality x + 3 < 5 + 2x.", "Solve the inequality x/5 + 3 < 8.", "Given a polynomial f(x) = x^3 - x^2 - 2x + 1. Factorize and find its roots.", "Solve 3x + 1/2 = (1/2)x - 13/2", "The sum of two numbers is 24 and their product is 128. Find the absolute difference of numbers.", "Solve  3e^x + 6 = 120", "If the sum of the square of two real numbers is 74 and their sum is 12. Then the sum of cubes of these two numbers is ...."};
    private static final String[] algebraAnswers = {"-2, -3", "(x-2)*(x-3)", "(x-2)^2", "x>-2", "x<25", "1.801, 0.447, -1.248", "-14/5", "8", "ln(38)", "468"};
    private static final String[] trigonometryProblems = {"If cosec(θ) + cot(θ) = x, find the value of cosec(θ) - cot(θ), using the trigonometry formula.", "If sin(θ)*cos(θ) = 8, find the value of (sin(θ) + cos(θ))^2 using the trigonometry Formulas.", "If sin(x) = 0.8, find the value of x in degrees.", "If sin(2θ) = 0.6 and θ is in the first quadrant, find the value of θ in radians.", "If sin(α) = 0.5 and cos(β) = 0.8, find sin(α + β).", "Calculate the value of sin(135°) using trigonometric identities.", "An electrician is climbing a 40 m long rope, which is tightly stretched and tied from the top of a vertical pole to the ground. Find the height of the pole if the angle made by the rope with the ground level is 60°.", "What is the value of cos(-15°)?", " If cos(x) = π/3, find the value of cos(3x) (in decimal form with two decimal digit precision).", "Calculate the value of cos(120°)."};
    private static final String[] trigonometryAnswers = {"1/x", "17", "53.13", "0.32175", "0.92", "0.7071", "34.64", "0.9659", "-0.08", "-0.5"};
    private static final String[] calculusProblems = {"Differentiate the function f(x) = x^3 with respect to x.", "Differentiate the function f(x) = (x+1)(x+2) with respect to x.", "Differentiate the function f(x)=(x+1)/(x+2) with respect to x.", "Differentiate the function f(x) = sin(x^2) with respect to x.", "Calculate the derivative of f(x) = 3x^3.", "Find the second-order derivative of f(x) = 4x^4 + 3x^3 + 2x^2 + x + 1", "Determine the intervals where the function f(x)=x^3−6x^2+9x+15 is concave up and concave down.", "Determine the intervals where the function g(x)=2x^4-4x^3-24x^2+48x is concave up and concave down.", "Given y = x/(x^2 + 1). Find the value of the second derivative at x = 1", "Given y(x) = 3x^3 + 12x + 4. Find the value of third derivative at x = 1"};
    private static final String[] calculusAnswers = {"3x^2", "2x+3", "1/(x+2)^2", "2xcos(x^2)", "9x^2", "48x^2+18x+4", "concave up:(-∞,1)∪(3,∞);concave down:(1,3)", "concave up:(-∞,-1)∪(3,∞);concave down:(-1,3)", "0.5", "18"};
    private static final String[] geometryProblems = {"Two triangles are similar. The sides of the first triangle are 6 cm, 8 cm, and 10 cm. The shortest side of the second triangle is 3 cm. Find the lengths of the other two sides of the second triangle.", "In a right triangle, one leg is 9 cm and the hypotenuse is 15 cm. Find the length of the other leg.", "Find the area of a triangle with sides 7 cm, 8 cm, and 9 cm.", "In a triangle, one angle is 35 degrees and another angle is 65 degrees. Find the measure of the third angle.", "In a quadrilateral ABCD, the measures of the angles are ∠A = 4x, ∠B = 3x+10∘, ∠C = 2x, and ∠D = x+20∘. Find the value of x and the measure of each angle.", "The lengths of the adjacent sides of a parallelogram are 6cm and 7cm. Find its perimeter.", "Three angles of a quadrilateral are 60°, 85°, 101°. Find out the fourth angle.", "In parallelogram ABCD, if the diagonals intersect at right angles and the lengths of the diagonals are 12 cm and 16 cm, find the area of the parallelogram.", "In parallelogram ABCD, if angle A = 3x + 10° and angle C = 2x + 30°, find the value of x.", "In parallelogram PQRS, if PQ = 5x - 7, QR = 2x + 3, and PQ = QR, find the value of x."};
    private static final String[] geometryAnswers = {"4, 5", "12", "26.83", "80", "30, 120, 100, 60, 50", "26", "114°", "96", "20", "10"};
    private static final int[] sectorDegrees = new int[sectors.length];
    private static final Random random = new Random();
    private int degree = 0, degreeAlg = 0, degreeGeo = 0, degreeTrigo = 0, degreeCalc = 0, degreeAnsAlg = 0, degreeAnsGeo = 0, degreeAnsTrigo = 0, degreeAnsCalc = 0;
    private boolean isSpinning = false;
    private ImageView spinningWheel;
    private ImageButton backButton;
    private TextView requirement;
    private EditText answer;
    private ImageButton checkAnswer;
    private Animation zoomInAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_roulette);

        final ImageButton spinButton = findViewById(R.id.SpinTheWheel);
        spinningWheel = findViewById(R.id.imageMathContent);
        backButton = findViewById(R.id.back);
        requirement = findViewById(R.id.selectedProblem);
        answer = findViewById(R.id.answerGiven);
        checkAnswer = findViewById(R.id.checkAnswer);

        getDegreeforSectors();
        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isSpinning){
                    spin();
                    isSpinning = true;
                }
            }
        });

        zoomInAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButton.startAnimation(zoomInAnimation);
                startActivity(new Intent(RouletteMain.this, Games.class));
            }
        });
    }

    private void spin(){
        degree = random.nextInt(sectors.length-1);
        degreeAlg = random.nextInt(algebraProblems.length-1);
        degreeCalc = random.nextInt(calculusProblems.length-1);
        degreeTrigo = random.nextInt(trigonometryProblems.length-1);
        degreeGeo = random.nextInt(geometryProblems.length-1);
        RotateAnimation rotateAnimation = new RotateAnimation(0, (360 * sectors.length) + sectorDegrees[degree],
                                                             RotateAnimation.RELATIVE_TO_SELF, 0.51f, RotateAnimation.RELATIVE_TO_SELF, 0.51f);
        rotateAnimation.setDuration(2500);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                requirement.setVisibility(GONE);
                checkAnswer.setVisibility(GONE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                checkAnswer.setVisibility(VISIBLE);
                Toast.makeText(RouletteMain.this, "You've chosen " + sectors[sectors.length - (degree + 1)], Toast.LENGTH_SHORT).show();
                isSpinning = false;

                if(sectors[sectors.length - (degree + 1)].equals("Algebra")){
                    SpannableString algebraString = new SpannableString(algebraProblems[degreeAlg]);
                    requirement.setText(algebraString);
                    requirement.setVisibility(VISIBLE);

                    degreeAnsAlg = degreeAlg;
                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String stringAnswer = answer.getText().toString().trim();
                            if(stringAnswer.equals(algebraAnswers[degreeAnsAlg])){
                                answer.setTextColor(Color.GREEN);
                                Toast.makeText(RouletteMain.this, "Correct answer", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                answer.setTextColor(Color.RED);
                                Toast.makeText(RouletteMain.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


                if(sectors[sectors.length - (degree + 1)].equals("Calculus")){
                    SpannableString calculusString = new SpannableString(calculusProblems[degreeCalc]);
                    requirement.setText(calculusString);
                    requirement.setVisibility(VISIBLE);

                    degreeAnsCalc = degreeCalc;
                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String stringAnswer = answer.getText().toString().trim();
                            if(stringAnswer.equals(calculusAnswers[degreeAnsCalc])){
                                answer.setTextColor(Color.GREEN);
                                Toast.makeText(RouletteMain.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                answer.setTextColor(Color.RED);
                                Toast.makeText(RouletteMain.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


                if(sectors[sectors.length - (degree + 1)].equals("Trigonometry")){
                    SpannableString trigonometryString = new SpannableString(trigonometryProblems[degreeTrigo]);
                    requirement.setText(trigonometryString);
                    requirement.setVisibility(VISIBLE);

                    degreeAnsTrigo = degreeTrigo;
                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String stringAnswer = answer.getText().toString().trim();
                            if(stringAnswer.equals(trigonometryAnswers[degreeAnsTrigo])){
                                answer.setTextColor(Color.GREEN);
                                Toast.makeText(RouletteMain.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                answer.setTextColor(Color.RED);
                                Toast.makeText(RouletteMain.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


                if(sectors[sectors.length - (degree + 1)].equals("Geometry")){
                    SpannableString geometryString = new SpannableString(geometryProblems[degreeGeo]);
                    requirement.setText(geometryString);
                    requirement.setVisibility(VISIBLE);

                    degreeAnsGeo = degreeGeo;
                    checkAnswer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String stringAnswer = answer.getText().toString().trim();
                            if(stringAnswer.equals(geometryAnswers[degreeAnsGeo])){
                                answer.setTextColor(Color.GREEN);
                                Toast.makeText(RouletteMain.this, "Correct answer", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                answer.setTextColor(Color.RED);
                                Toast.makeText(RouletteMain.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        spinningWheel.startAnimation(rotateAnimation);
    }

    private void getDegreeforSectors(){
        int sectorDegree = 360 / sectors.length;
        for(int i = 0; i < sectors.length; i++){
            sectorDegrees[i] = (i+1) * sectorDegree;
        }

    }
}

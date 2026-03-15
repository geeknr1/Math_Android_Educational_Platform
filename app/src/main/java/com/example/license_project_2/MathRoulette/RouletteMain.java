package com.example.license_project_2.MathRoulette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.license_project_2.Games;
import com.example.license_project_2.R;

import java.util.Random;

public class RouletteMain extends AppCompatActivity {
    private static final String[] sectors = {"Algebra","Geometry","Calculus","Trigonometry"};
    private static final String[] algebraProblems = {"", "", "", "", "", "", "", "", "", ""};
    private static final String[] trigonometryProblems = {"", "", "", "", "", "", "", "", "", ""};
    private static final String[] calculusProblems = {"Differentiate the function f(x) = x^3 with respect to x.", "Differentiate the function f(x) = (x+1)(x+2) with respect to x.", "Differentiate the function f(x)=(x+1)/(x+2) with respect to x.", "Differentiate the function f(x) = sin(x^2) with respect to x.", "Calculate the derivative of f(x) = 3x^3.", "Find the second-order derivative of f(x) = 4x^4 + 3x^3 + 2x^2 + x + 1", "Determine the intervals where the function f(x)=x^3−6x^2+9x+15 is concave up and concave down.", "Determine the intervals where the function g(x)=2x^4-4x^3-24x^2+48x is concave up and concave down.", "Given y = x/(x^2 + 1). Find the value of the second derivative at x = 1", "Given y(x) = 3x^3 + 12x + 4. Find the value of third derivative at x = 1"};
    private static final String[] geometryProblems = {"", "", "", "", "", "", "", "", "", ""};
    private static final int[] sectorDegrees = new int[sectors.length];
    private static final int[] algebraProblemsDegrees = new int[algebraProblems.length];
    private static final int[] trigonometryProblemsDegrees = new int[trigonometryProblems.length];
    private static final int[] calculusProblemsDegrees = new int[calculusProblems.length];
    private static final int[] geometryProblemsDegrees = new int[geometryProblems.length];
    private static final Random random = new Random();
    private int degree = 0, degreeAlg = 0, degreeGeo = 0, degreeTrigo = 0, degreeCalc = 0;
    private boolean isSpinning = false;
    private ImageView spinningWheel;

    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_roulette);

        final TextView spinButton = findViewById(R.id.SpinTheWheel);
        spinningWheel = findViewById(R.id.imageMathContent);
        backButton = findViewById(R.id.back);

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
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RouletteMain.this, Games.class));
            }
        });
    }

    private void spin(){
        degree = random.nextInt(sectors.length-1);
        RotateAnimation rotateAnimation = new RotateAnimation(0, (360 * sectors.length) + sectorDegrees[degree],
                                                             RotateAnimation.RELATIVE_TO_SELF, 0.51f, RotateAnimation.RELATIVE_TO_SELF, 0.51f);
        rotateAnimation.setDuration(2500);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(RouletteMain.this, "You've chosen " + sectors[sectors.length - (degree + 1)], Toast.LENGTH_SHORT).show();
                isSpinning = false;
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

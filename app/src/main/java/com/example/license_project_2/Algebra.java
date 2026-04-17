package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Algebra extends AppCompatActivity {
    private TextView welcome;
    private TextView choose;
    private ImageButton back;
    private Animation bounceAnimation;
    private char underDash = '_', emptySpace = ' ';

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algebra);

        welcome = findViewById(R.id.welcome);
        welcome.setVisibility(VISIBLE);

        choose = findViewById(R.id.choose);
        choose.setVisibility(VISIBLE);

        spinnerSetup(R.id.spinnerChapter1Alg, R.array.Whole_Numbers_And_Fractions);
        spinnerSetup(R.id.spinnerChapter2Alg, R.array.Approximate_Calculations);
        spinnerSetup(R.id.spinnerChapter3Alg, R.array.Powers_and_Roots___Real_Numbers);
        spinnerSetup(R.id.spinnerChapter4Alg, R.array.Expressions);
        spinnerSetup(R.id.spinnerChapter5Alg, R.array.Equations_and_Inequalities);
        spinnerSetup(R.id.spinnerChapter6Alg, R.array.Functions_and_Graphs);
        spinnerSetup(R.id.spinnerChapter7Alg, R.array.Arithmetic_and_Geometric_Progressions___Logarithms);

        back = findViewById(R.id.backToTutorial);
        back.setVisibility(VISIBLE);

        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.startAnimation(bounceAnimation);
                startActivity(new Intent(Algebra.this, Tutorial.class));
            }
        });

    }

    private final AdapterView.OnItemSelectedListener listener =
            new AdapterView.OnItemSelectedListener(){
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                    if(position == 0)
                        return;
                    String label = ((String) parent.getItemAtPosition(position)).trim();
                    AlgebraSections sectionAlg = AlgebraSections.valueOf(label);
                    try {
                        Intent intent = new Intent(Algebra.this, AlgebraSection.class);
                        sectionAlg.attachTo(intent);
                        startActivity(intent);
                    }catch(Exception e){
                        Toast.makeText(Algebra.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                    parent.setSelection(0);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            };
    public void spinnerSetup(int spinnerID, int arrayID){
        Spinner spinner = findViewById(spinnerID);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, arrayID, R.layout.selected_item);

        adapter.setDropDownViewResource(R.layout.dropdown_item);
        //adapter.setDropDownViewResource(R.layout.multiple_line_spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(listener);



    }
}

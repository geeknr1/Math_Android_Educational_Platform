package com.example.license_project_2;

import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Geometry extends AppCompatActivity {
    private TextView welcome;
    private TextView choose;
    private Button back;

    protected void onCreate(Bundle savedInstanceState){
//        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geometry);

        welcome = findViewById(R.id.welcome);
        welcome.setVisibility(VISIBLE);

        choose = findViewById(R.id.chapter);
        choose.setVisibility(VISIBLE);

        spinnerSetup(R.id.spinnerChapter1Geo, R.array.Fundamental_Concepts_of_Geometry_and_Geometric_Figures);
        spinnerSetup(R.id.spinnerChapter2Geo, R.array.Straight_Lines);
        spinnerSetup(R.id.spinnerChapter3Geo, R.array.Circles);
        spinnerSetup(R.id.spinnerChapter4Geo, R.array.Similarity_of_Polygons);
        spinnerSetup(R.id.spinnerChapter5Geo, R.array.Transformation_of_Figures);
        spinnerSetup(R.id.spinnerChapter6Geo, R.array.Vectors_in_the_Plane_and_Trigonometric_Functions_of_the_Angle);
        spinnerSetup(R.id.spinnerChapter7Geo, R.array.Areas_of_Polygons);
        spinnerSetup(R.id.spinnerChapter8Geo, R.array.Regular_Polygons___Length_of_Circumference___Area_of_a_Circle);
        spinnerSetup(R.id.spinnerChapter9Geo, R.array.Fundamentals_of_Solid_Geometry);

        back = findViewById(R.id.backToTutorial_2);
        back.setVisibility(VISIBLE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Geometry.this, Tutorial.class));
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
                        Intent intent = new Intent(Geometry.this, GeometrySection.class);
                        sectionAlg.attachTo(intent);
                        startActivity(intent);
                    }catch(Exception e){
                        Toast.makeText(Geometry.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                    parent.setSelection(0);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            };
    public void spinnerSetup(int spinnerID, int arrayID){
        Spinner spinner = findViewById(spinnerID);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, arrayID, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.multiple_line_spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(listener);



    }
}

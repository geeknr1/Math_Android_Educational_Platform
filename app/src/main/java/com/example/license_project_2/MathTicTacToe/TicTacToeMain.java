package com.example.license_project_2.MathTicTacToe;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.Random;

import com.example.license_project_2.Games;
import com.example.license_project_2.R;

public class TicTacToeMain extends AppCompatActivity {
    private TextView selectedOne, selectedTwo, selectedThree, selectedFour, selectedFive,
                        selectedSix, selectedSeven, selectedEight, selectedNine;
    private TextView gridOne, gridTwo, gridThree, gridFour, gridFive, gridSix, gridSeven,
                        gridEight, gridNine;
    private ImageView signOne, signTwo, signThree, signFour, signFive, signSix;
    private TextView columnAnsOne, columnAnsTwo, columnAnsThree;
    private ImageButton resetValues, quitGame;
    private int[] possibleNumbers = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
            51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
            61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
            71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
            81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
            91, 92, 93, 94, 95, 96, 97, 98, 99
    };

    private int selectOne = 0, selectTwo = 0, selectThree = 0, selectFour = 0, selectFive = 0, selectSix = 0,
            selectSeven = 0,  selectEight = 0, selectNine = 0, numberGridOne, numberGridTwo, numberGridThree,
            numberGridFour, numberGridFive, numberGridSix, numberGridSeven, numberGridEight, numberGridNine,
            resultOne, resultTwo, resultThree, clickIndex = 0, gridClickIndex = 0;
    //private int[] selectedNumbers = {selectOne, selectTwo, selectThree, selectFour, selectFive, selectSix, selectSeven, selectEight, selectNine};
    private String valueGridOne, valueGridTwo, valueGridThree, valueGridFour, valueGridFive, valueGridSix, valueGridSeven,
                   valueGridEight, valueGridNine;
    private int numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix, numberSeven, numberEight, numberNine;
    private static final Random random = new Random();
    private Animation bounceAnimationOne, bounceAnimationTwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_tictactoe);

        selectedOne = findViewById(R.id.firstNumber); selectedTwo = findViewById(R.id.secondNumber);
        selectedThree = findViewById(R.id.thirdNumber); selectedFour = findViewById(R.id.fourthNumber);
        selectedFive = findViewById(R.id.fifthNumber); selectedSix = findViewById(R.id.sixthNumber);
        selectedSeven = findViewById(R.id.seventhNumber); selectedEight = findViewById(R.id.eighthNumber);
        selectedNine = findViewById(R.id.ninthNumber);

        selectedOne.setVisibility(View.VISIBLE); selectedTwo.setVisibility(View.VISIBLE);
        selectedThree.setVisibility(View.VISIBLE); selectedFour.setVisibility(View.VISIBLE);
        selectedFive.setVisibility(View.VISIBLE); selectedSix.setVisibility(View.VISIBLE);
        selectedSeven.setVisibility(View.VISIBLE); selectedEight.setVisibility(View.VISIBLE);
        selectedNine.setVisibility(View.VISIBLE);

        gridOne = findViewById(R.id.chosenOne); gridTwo = findViewById(R.id.chosenTwo);
        gridThree = findViewById(R.id.chosenThree); gridFour = findViewById(R.id.chosenFour);
        gridFive = findViewById(R.id.chosenFive); gridSix = findViewById(R.id.chosenSix);
        gridSeven = findViewById(R.id.chosenSeven); gridEight = findViewById(R.id.chosenEight);
        gridNine = findViewById(R.id.chosenNine);

        gridOne.setVisibility(View.VISIBLE); gridTwo.setVisibility(View.VISIBLE); gridThree.setVisibility(View.VISIBLE);
        gridFour.setVisibility(View.VISIBLE); gridFive.setVisibility(View.VISIBLE); gridSix.setVisibility(View.VISIBLE);
        gridSeven.setVisibility(View.VISIBLE); gridEight.setVisibility(View.VISIBLE); gridNine.setVisibility(View.VISIBLE);

        signOne = findViewById(R.id.signOne); signTwo = findViewById(R.id.signTwo); signThree = findViewById(R.id.signThree);
        signFour = findViewById(R.id.signFour); signFive = findViewById(R.id.signFive); signSix = findViewById(R.id.signSix);

        signOne.setVisibility(View.VISIBLE); signTwo.setVisibility(View.VISIBLE); signThree.setVisibility(View.VISIBLE);
        signFour.setVisibility(View.VISIBLE); signFive.setVisibility(View.VISIBLE); signSix.setVisibility(View.VISIBLE);

        columnAnsOne = findViewById(R.id.resultOne); columnAnsTwo = findViewById(R.id.resultTwo);
        columnAnsThree = findViewById(R.id.resultThree);

        columnAnsOne.setVisibility(View.VISIBLE); columnAnsTwo.setVisibility(View.VISIBLE);
        columnAnsThree.setVisibility(View.VISIBLE);

        resetValues = findViewById(R.id.resetValues); quitGame = findViewById(R.id.quitGame);
        resetValues.setVisibility(View.VISIBLE); quitGame.setVisibility(View.VISIBLE);

        gridOne.setText("0"); gridTwo.setText("0"); gridThree.setText("0"); gridFour.setText("0"); gridFive.setText("0");
        gridSix.setText("0"); gridSeven.setText("0"); gridEight.setText("0"); gridNine.setText("0");

        valuesFound();
        plusPlus();
        selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
        selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
        selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
        setResultValuesForPlusPlus();

        bounceAnimationOne = AnimationUtils.loadAnimation(this, R.anim.bounce);
        resetValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetValues.startAnimation(bounceAnimationOne);
                clickIndex += 1;
                gridClickIndex = 0;
                gridOne.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridTwo.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridThree.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridFour.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridFive.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridSix.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridSeven.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridEight.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));
                gridNine.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.roundedorange, null));

                gridOne.setText("0"); gridTwo.setText("0"); gridThree.setText("0"); gridFour.setText("0"); gridFive.setText("0");
                gridSix.setText("0"); gridSeven.setText("0"); gridEight.setText("0"); gridNine.setText("0");

                if(clickIndex % 16 == 1){
                    valuesFound(); plusPlus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForPlusPlus();
                }
                if(clickIndex % 16 == 2){
                    valuesFound(); minusMinus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForMinusMinus();
                }
                if(clickIndex % 16 == 3){
                    valuesFound(); plusMinus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForPlusMinus();
                }
                if(clickIndex % 16 == 4){
                    valuesFound(); minusPlus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForMinusPlus();
                }
                if(clickIndex % 16 == 5){
                    valuesFound(); productProduct(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForProductProduct();
                }
                if(clickIndex % 16 == 6){
                    valuesFound(); divisionDivision(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForDivisionDivision();
                }
                if(clickIndex % 16 == 11){
                    valuesFound(); productDivision(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForProductDivision();
                }
                if(clickIndex % 16 == 12){
                    valuesFound(); divisionProduct(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForDivisionProduct();
                }
                if(clickIndex % 16 == 7){
                    valuesFound(); plusProduct(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForPlusProduct();
                }
                if(clickIndex % 16 == 8){
                    valuesFound(); productPlus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForProductPlus();
                }
                if(clickIndex % 16 == 9){
                    valuesFound(); minusProduct(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForMinusProduct();
                }
                if(clickIndex % 16 == 10){
                    valuesFound(); productMinus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForProductMinus();
                }
                if(clickIndex % 16 == 13){
                    valuesFound(); divisionPlus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForDivisionPlus();
                }
                if(clickIndex % 16 == 14){
                    valuesFound(); plusDivision(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForPlusDivision();
                }
                if(clickIndex % 16 == 15){
                    valuesFound(); divisionMinus(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForDivisionMinus();
                }
                if(clickIndex % 16 == 0){
                    valuesFound(); minusDivision(); setInitialSlotDesign();
                    selectNumber(selectedOne, selectOne); selectNumber(selectedTwo, selectTwo); selectNumber(selectedThree, selectThree);
                    selectNumber(selectedFour, selectFour); selectNumber(selectedFive, selectFive); selectNumber(selectedSix, selectSix);
                    selectNumber(selectedSeven, selectSeven); selectNumber(selectedEight, selectEight); selectNumber(selectedNine, selectNine);
                    setResultValuesForMinusDivision();
                }
            }
        });

        bounceAnimationTwo = AnimationUtils.loadAnimation(this, R.anim.bounce);
        quitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitGame.startAnimation(bounceAnimationTwo);
                gridClickIndex = 0;
                clickIndex = 0;
                startActivity(new Intent(TicTacToeMain.this, Games.class));
            }
        });


    }

    public void checkEquality(int selectOne, int selectTwo, int selectThree, int selectFour, int selectFive, int selectSix, int selectSeven, int selectEight){
        while(selectOne == selectTwo || selectOne == selectThree || selectOne == selectFour || selectOne == selectFive
                || selectOne == selectSix || selectOne == selectSeven || selectOne == selectEight || selectOne == selectNine){
            selectOne = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        }
        while(selectTwo == selectOne || selectTwo == selectThree || selectTwo == selectFour || selectTwo == selectFive
                || selectTwo == selectSix || selectTwo == selectSeven || selectTwo == selectEight || selectTwo == selectNine){
            selectTwo = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        }
        while(selectThree == selectOne || selectThree == selectTwo || selectThree == selectFour || selectThree == selectFive
                || selectThree == selectSix || selectThree == selectSeven || selectThree == selectEight || selectThree == selectNine){
            selectThree = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        }
        while(selectFour == selectOne || selectFour == selectTwo || selectFour == selectThree || selectFour == selectFive
                || selectFour == selectSix || selectFour == selectSeven || selectFour == selectEight || selectFour == selectNine){
            selectFour = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        }
        while(selectFive == selectOne || selectFive == selectTwo || selectFive == selectThree || selectFive == selectFour
                || selectFive == selectSix || selectFive == selectSeven || selectFive == selectEight || selectFive == selectNine){
            selectFive = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        }
        while(selectSix == selectOne || selectSix == selectTwo || selectSix == selectThree || selectSix == selectFour
                || selectSix == selectFive || selectSix == selectSeven || selectSix == selectEight || selectSix == selectNine){
            selectSix = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        }
        while(selectSeven == selectOne || selectSeven == selectTwo || selectSeven == selectThree || selectSeven == selectFour
                || selectSeven == selectFive || selectSeven == selectSix || selectSeven == selectEight || selectSeven == selectNine){
            selectSeven = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        }
        while(selectEight == selectOne || selectEight == selectTwo || selectEight == selectThree || selectEight == selectFour
                || selectEight == selectFive || selectEight == selectSix || selectEight == selectSeven || selectEight == selectNine){
            selectEight = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        }
    }
    public void valuesFound(){
        selectOne = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        selectTwo = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        selectThree = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        selectFour = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        selectFive = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        selectSix = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        selectSeven = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        selectEight = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        selectNine = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];

        checkEquality(selectOne, selectTwo, selectThree, selectFour, selectFive, selectSix, selectSeven, selectEight);
        while(selectNine == selectOne || selectNine == selectTwo || selectNine == selectThree || selectNine == selectFour
                || selectNine == selectFive || selectNine == selectSix || selectNine == selectSeven || selectNine == selectEight){
            selectNine = possibleNumbers[random.nextInt(possibleNumbers.length - 1)];
        }

        selectedOne.setText(String.valueOf(selectOne));
        selectedTwo.setText(String.valueOf(selectTwo));
        selectedThree.setText(String.valueOf(selectThree));
        selectedFour.setText(String.valueOf(selectFour));
        selectedFive.setText(String.valueOf(selectFive));
        selectedSix.setText(String.valueOf(selectSix));
        selectedSeven.setText(String.valueOf(selectSeven));
        selectedEight.setText(String.valueOf(selectEight));
        selectedNine.setText(String.valueOf(selectNine));
    }

    public void plusPlus(){
        signOne.setImageResource(R.drawable.plus); signTwo.setImageResource(R.drawable.plus);
        signThree.setImageResource(R.drawable.plus); signFour.setImageResource(R.drawable.plus);
        signFive.setImageResource(R.drawable.plus); signSix.setImageResource(R.drawable.plus);
    }

    public void minusMinus(){
        signOne.setImageResource(R.drawable.minus); signTwo.setImageResource(R.drawable.minus);
        signThree.setImageResource(R.drawable.minus); signFour.setImageResource(R.drawable.minus);
        signFive.setImageResource(R.drawable.minus); signSix.setImageResource(R.drawable.minus);
    }
    public void plusMinus(){
        signOne.setImageResource(R.drawable.plus); signTwo.setImageResource(R.drawable.minus);
        signThree.setImageResource(R.drawable.plus); signFour.setImageResource(R.drawable.minus);
        signFive.setImageResource(R.drawable.plus); signSix.setImageResource(R.drawable.minus);
    }
    public void minusPlus(){
        signOne.setImageResource(R.drawable.minus); signTwo.setImageResource(R.drawable.plus);
        signThree.setImageResource(R.drawable.minus); signFour.setImageResource(R.drawable.plus);
        signFive.setImageResource(R.drawable.minus); signSix.setImageResource(R.drawable.plus);
    }
    public void productProduct(){
        signOne.setImageResource(R.drawable.product); signTwo.setImageResource(R.drawable.product);
        signThree.setImageResource(R.drawable.product); signFour.setImageResource(R.drawable.product);
        signFive.setImageResource(R.drawable.product); signSix.setImageResource(R.drawable.product);
    }
    public void divisionDivision(){
        signOne.setImageResource(R.drawable.division); signTwo.setImageResource(R.drawable.division);
        signThree.setImageResource(R.drawable.division); signFour.setImageResource(R.drawable.division);
        signFive.setImageResource(R.drawable.division); signSix.setImageResource(R.drawable.division);
    }
    public void productDivision(){
        signOne.setImageResource(R.drawable.product); signTwo.setImageResource(R.drawable.division);
        signThree.setImageResource(R.drawable.product); signFour.setImageResource(R.drawable.division);
        signFive.setImageResource(R.drawable.product); signSix.setImageResource(R.drawable.division);
    }
    public void divisionProduct(){
        signOne.setImageResource(R.drawable.division); signTwo.setImageResource(R.drawable.product);
        signThree.setImageResource(R.drawable.division); signFour.setImageResource(R.drawable.product);
        signFive.setImageResource(R.drawable.division); signSix.setImageResource(R.drawable.product);
    }
    public void plusProduct(){
        signOne.setImageResource(R.drawable.plus); signTwo.setImageResource(R.drawable.product);
        signThree.setImageResource(R.drawable.plus); signFour.setImageResource(R.drawable.product);
        signFive.setImageResource(R.drawable.plus); signSix.setImageResource(R.drawable.product);
    }
    public void productPlus(){
        signOne.setImageResource(R.drawable.product); signTwo.setImageResource(R.drawable.plus);
        signThree.setImageResource(R.drawable.product); signFour.setImageResource(R.drawable.plus);
        signFive.setImageResource(R.drawable.product); signSix.setImageResource(R.drawable.plus);
    }
    public void minusProduct(){
        signOne.setImageResource(R.drawable.minus); signTwo.setImageResource(R.drawable.product);
        signThree.setImageResource(R.drawable.minus); signFour.setImageResource(R.drawable.product);
        signFive.setImageResource(R.drawable.minus); signSix.setImageResource(R.drawable.product);
    }
    public void productMinus(){
        signOne.setImageResource(R.drawable.product); signTwo.setImageResource(R.drawable.minus);
        signThree.setImageResource(R.drawable.product); signFour.setImageResource(R.drawable.minus);
        signFive.setImageResource(R.drawable.product); signSix.setImageResource(R.drawable.minus);
    }
    public void plusDivision(){
        signOne.setImageResource(R.drawable.plus); signTwo.setImageResource(R.drawable.division);
        signThree.setImageResource(R.drawable.plus); signFour.setImageResource(R.drawable.division);
        signFive.setImageResource(R.drawable.plus); signSix.setImageResource(R.drawable.division);
    }
    public void divisionPlus(){
        signOne.setImageResource(R.drawable.division); signTwo.setImageResource(R.drawable.plus);
        signThree.setImageResource(R.drawable.division); signFour.setImageResource(R.drawable.plus);
        signFive.setImageResource(R.drawable.division); signSix.setImageResource(R.drawable.plus);
    }
    public void minusDivision(){
        signOne.setImageResource(R.drawable.minus); signTwo.setImageResource(R.drawable.division);
        signThree.setImageResource(R.drawable.minus); signFour.setImageResource(R.drawable.division);
        signFive.setImageResource(R.drawable.minus); signSix.setImageResource(R.drawable.division);
    }
    public void divisionMinus(){
        signOne.setImageResource(R.drawable.division); signTwo.setImageResource(R.drawable.minus);
        signThree.setImageResource(R.drawable.division); signFour.setImageResource(R.drawable.minus);
        signFive.setImageResource(R.drawable.division); signSix.setImageResource(R.drawable.minus);
    }
    public void selectNumber(TextView selectedSlot, int selectNumber){
        selectedSlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridClickIndex++;
                if(gridClickIndex == 1) {
                    gridOne.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button, null));
                    gridOne.setText(String.valueOf(selectNumber));
                    valueGridOne = gridOne.getText().toString();
                    numberGridOne = Integer.parseInt(valueGridOne);
                    selectedSlot.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button_2, null));
                    selectedSlot.setTextColor(Color.parseColor("#000000"));
                }
                if(gridClickIndex == 2){
                    gridTwo.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button, null));
                    gridTwo.setText(String.valueOf(selectNumber));
                    valueGridTwo = gridTwo.getText().toString();
                    numberGridTwo = Integer.parseInt(valueGridTwo);
                    selectedSlot.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button_2, null));
                    selectedSlot.setTextColor(Color.parseColor("#000000"));
                }
                if(gridClickIndex == 3){
                    gridThree.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button, null));
                    gridThree.setText(String.valueOf(selectNumber));
                    valueGridThree = gridThree.getText().toString();
                    numberGridThree = Integer.parseInt(valueGridThree);
                    selectedSlot.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button_2, null));
                    selectedSlot.setTextColor(Color.parseColor("#000000"));
                }
                if(gridClickIndex == 4){
                    gridFour.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button, null));
                    gridFour.setText(String.valueOf(selectNumber));
                    valueGridFour = gridFour.getText().toString();
                    numberGridFour = Integer.parseInt(valueGridFour);
                    selectedSlot.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button_2, null));
                    selectedSlot.setTextColor(Color.parseColor("#000000"));
                }
                if(gridClickIndex == 5){
                    gridFive.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button, null));
                    gridFive.setText(String.valueOf(selectNumber));
                    valueGridFive = gridFive.getText().toString();
                    numberGridFive = Integer.parseInt(valueGridFive);
                    selectedSlot.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button_2, null));
                    selectedSlot.setTextColor(Color.parseColor("#000000"));
                }
                if(gridClickIndex == 6){
                    gridSix.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button, null));
                    gridSix.setText(String.valueOf(selectNumber));
                    valueGridSix = gridSix.getText().toString();
                    numberGridSix = Integer.parseInt(valueGridSix);
                    selectedSlot.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button_2, null));
                    selectedSlot.setTextColor(Color.parseColor("#000000"));
                }
                if(gridClickIndex == 7){
                    gridSeven.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button, null));
                    gridSeven.setText(String.valueOf(selectNumber));
                    valueGridSeven = gridSeven.getText().toString();
                    numberGridSeven = Integer.parseInt(valueGridSeven);
                    selectedSlot.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button_2, null));
                    selectedSlot.setTextColor(Color.parseColor("#000000"));
                }
                if(gridClickIndex == 8){
                    gridEight.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button, null));
                    gridEight.setText(String.valueOf(selectNumber));
                    valueGridEight = gridEight.getText().toString();
                    numberGridEight = Integer.parseInt(valueGridEight);
                    selectedSlot.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button_2, null));
                    selectedSlot.setTextColor(Color.parseColor("#000000"));
                }
                if(gridClickIndex == 9){
                    gridNine.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.square_rounded_button, null));
                    gridNine.setText(String.valueOf(selectNumber));
                    valueGridNine = gridNine.getText().toString();
                    numberGridNine = Integer.parseInt(valueGridNine);
                    selectedSlot.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button_2, null));
                    selectedSlot.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
    }

    public void setFactors(){
        int[] selectedNumbers = {selectOne, selectTwo, selectThree, selectFour, selectFive, selectSix, selectSeven, selectEight, selectNine};
        numberOne = selectedNumbers[random.nextInt(selectedNumbers.length - 1)];
        numberTwo = selectedNumbers[random.nextInt(selectedNumbers.length - 1)];
        numberThree = selectedNumbers[random.nextInt(selectedNumbers.length - 1)];
        numberFour = selectedNumbers[random.nextInt(selectedNumbers.length - 1)];
        numberFive = selectedNumbers[random.nextInt(selectedNumbers.length - 1)];
        numberSix = selectedNumbers[random.nextInt(selectedNumbers.length - 1)];
        numberSeven = selectedNumbers[random.nextInt(selectedNumbers.length - 1)];
        numberEight = selectedNumbers[random.nextInt(selectedNumbers.length - 1)];
        numberNine = selectedNumbers[random.nextInt(selectedNumbers.length - 1)];

        checkEquality(numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix, numberSeven, numberEight);
        while(numberNine == numberOne || numberNine == numberTwo || numberNine == numberThree || numberNine == numberFour ||
                numberNine == numberFive || numberNine == numberSix || numberNine == numberSeven || numberNine == numberEight){
            numberNine = selectedNumbers[random.nextInt(selectedNumbers.length - 1)];
        }
    }

    public void setResultValuesForPlusPlus(){
        setFactors();
        resultOne = numberOne + numberTwo + numberThree; resultTwo = numberFour + numberFive + numberSix;
        resultThree = numberSeven + numberEight + numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForMinusMinus(){
        setFactors();
        resultOne = numberOne - numberTwo - numberThree; resultTwo = numberFour - numberFive - numberSix;
        resultThree = numberSeven - numberEight - numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForPlusMinus(){
        setFactors();
        resultOne = numberOne + numberTwo - numberThree; resultTwo = numberFour + numberFive - numberSix;
        resultThree = numberSeven + numberEight - numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForMinusPlus(){
        setFactors();
        resultOne = numberOne - numberTwo + numberThree; resultTwo = numberFour - numberFive + numberSix;
        resultThree = numberSeven - numberEight + numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForProductProduct(){
        setFactors();
        resultOne = numberOne * numberTwo * numberThree; resultTwo = numberFour * numberFive * numberSix;
        resultThree = numberSeven * numberEight * numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForDivisionDivision(){
        setFactors();
        resultOne = numberOne / numberTwo / numberThree; resultTwo = numberFour / numberFive / numberSix;
        resultThree = numberSeven / numberEight / numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForProductDivision(){
        setFactors();
        resultOne = numberOne * numberTwo / numberThree; resultTwo = numberFour * numberFive / numberSix;
        resultThree = numberSeven * numberEight / numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForDivisionProduct(){
        setFactors();
        resultOne = numberOne / numberTwo * numberThree; resultTwo = numberFour / numberFive * numberSix;
        resultThree = numberSeven / numberEight * numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForPlusProduct(){
        setFactors();
        resultOne = numberOne + numberTwo * numberThree; resultTwo = numberFour + numberFive * numberSix;
        resultThree = numberSeven + numberEight * numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForProductPlus(){
        setFactors();
        resultOne = numberOne * numberTwo + numberThree; resultTwo = numberFour * numberFive + numberSix;
        resultThree = numberSeven * numberEight + numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForMinusProduct(){
        setFactors();
        resultOne = numberOne - numberTwo * numberThree; resultTwo = numberFour - numberFive * numberSix;
        resultThree = numberSeven - numberEight * numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForProductMinus(){
        setFactors();
        resultOne = numberOne * numberTwo - numberThree; resultTwo = numberFour * numberFive - numberSix;
        resultThree = numberSeven * numberEight - numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForPlusDivision(){
        setFactors();
        resultOne = numberOne + numberTwo / numberThree; resultTwo = numberFour + numberFive / numberSix;
        resultThree = numberSeven + numberEight / numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForDivisionPlus(){
        setFactors();
        resultOne = numberOne / numberTwo + numberThree; resultTwo = numberFour / numberFive + numberSix;
        resultThree = numberSeven / numberEight + numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForMinusDivision(){
        setFactors();
        resultOne = numberOne - numberTwo / numberThree; resultTwo = numberFour - numberFive / numberSix;
        resultThree = numberSeven - numberEight / numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setResultValuesForDivisionMinus(){
        setFactors();
        resultOne = numberOne / numberTwo - numberThree; resultTwo = numberFour / numberFive - numberSix;
        resultThree = numberSeven / numberEight - numberNine;
        columnAnsOne.setText(String.valueOf(resultOne)); columnAnsTwo.setText(String.valueOf(resultTwo));
        columnAnsThree.setText(String.valueOf(resultThree));
    }

    public void setInitialSlotDesign(){
        selectedOne.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedOne.setTextColor(Color.parseColor("#ffffff"));
        selectedTwo.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedTwo.setTextColor(Color.parseColor("#ffffff"));
        selectedThree.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedThree.setTextColor(Color.parseColor("#ffffff"));
        selectedFour.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedFour.setTextColor(Color.parseColor("#ffffff"));
        selectedFive.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedFive.setTextColor(Color.parseColor("#ffffff"));
        selectedSix.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedSix.setTextColor(Color.parseColor("#ffffff"));
        selectedSeven.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedSeven.setTextColor(Color.parseColor("#ffffff"));
        selectedEight.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedEight.setTextColor(Color.parseColor("#ffffff"));
        selectedNine.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.circular_button, null));
        selectedNine.setTextColor(Color.parseColor("#ffffff"));
    }


}

package com.example.license_project_2.MathGeometry;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.license_project_2.R;

import java.util.Random;

public class Figure {
    Bitmap figure[] = new Bitmap[6];
    int figureFrame = 0;
    int figureX, figureY, figureVelocity;
    Random random;

    public Figure(Context context){
        figure[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.circlegame);
        figure[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.squaregame);
        figure[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.rectanglegame);
        figure[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.trianglegame);
        figure[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.trianglegametwo);
        figure[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.obtusetriangle);

        random = new Random();
    }

    public Bitmap getFigure(int figureFrame){
        return figure[figureFrame];
    }

    public int getFigureWidth(){
        return figure[0].getWidth();
    }

    public int getFigureHeight(){
        return figure[0].getHeight();
    }

    public void resetPosition(){
        figureX = random.nextInt(GameView.dWidth - getFigureWidth());
        figureY = -200 + random.nextInt(600)* -1;
        figureVelocity = 35 + random.nextInt(16);
    }
}

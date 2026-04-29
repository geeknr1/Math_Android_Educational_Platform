package com.example.license_project_2.MathGeometry;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.license_project_2.R;

import java.util.Random;

public class Figure {
    Bitmap[] figure = new Bitmap[6];
    int figureFrame = 0;
    int figureX, figureY, figureVelocity;
    Random random;

    public Figure(Context context){
        figure[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.circlegametwo);
        figure[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.squaregametwo);
        figure[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.rectanglegametwo);
        figure[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.trianglegametwo);
        figure[4] = BitmapFactory.decodeResource(context.getResources(), R.drawable.trianglegametwo_2);
        figure[5] = BitmapFactory.decodeResource(context.getResources(), R.drawable.obtusetriangletwo);

        random = new Random();
        resetPosition();
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
        figureFrame = random.nextInt(figure.length);
        figureX = random.nextInt(GameView.dWidth - getFigureWidth());
        figureY = -200 + random.nextInt(600)* -1;
        figureVelocity = 35 + random.nextInt(16);
    }
}

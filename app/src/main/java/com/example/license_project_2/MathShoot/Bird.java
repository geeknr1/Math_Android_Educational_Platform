package com.example.license_project_2.MathShoot;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.license_project_2.R;

public class Bird {
    public int speed = 10;
    int x = 0, y, width, height, birdCounter = 1;
    Bitmap birdOne, birdTwo, birdThree, birdFour;

    Bird(Resources resource){
        birdOne = BitmapFactory.decodeResource(resource, R.drawable.birdredfirst);
        birdTwo = BitmapFactory.decodeResource(resource, R.drawable.birdredsecond);
        birdThree = BitmapFactory.decodeResource(resource, R.drawable.birdredthird);
        birdFour = BitmapFactory.decodeResource(resource, R.drawable.birdredfourth);

        width = birdOne.getWidth();
        height = birdOne.getHeight();

        width /= 10;
        height /= 10;

        birdOne = Bitmap.createScaledBitmap(birdOne, width, height, false);
        birdTwo = Bitmap.createScaledBitmap(birdTwo, width, height, false);
        birdThree = Bitmap.createScaledBitmap(birdThree, width, height, false);
        birdFour = Bitmap.createScaledBitmap(birdFour, width, height, false);

        y = -height;
    }

    public Bitmap getBird(){
        if(birdCounter == 1){
            birdCounter++;
            return birdOne;
        }
        if(birdCounter == 2){
            birdCounter++;
            return birdTwo;
        }
        if(birdCounter == 3){
            birdCounter++;
            return birdThree;
        }
        birdCounter = 1;
        return birdFour;
    }

    public Rect getCollisionShape(){
        return new Rect(x, y, x + width, y + height);
    }
}

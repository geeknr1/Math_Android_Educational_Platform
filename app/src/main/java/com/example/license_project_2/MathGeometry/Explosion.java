package com.example.license_project_2.MathGeometry;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.license_project_2.R;

public class Explosion {
    Bitmap explosion[] = new Bitmap[4];
    int explosionFrame = 0;
    int explosionX, explosionY;

    public Explosion(Context context){
        explosion[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.explosionone);
        explosion[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.explosiontwo);
        explosion[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.explosionthree);
        explosion[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.explosionfour);
    }

    public Bitmap getExplosion(int explosionFrame){
        return explosion[explosionFrame];
    }
}

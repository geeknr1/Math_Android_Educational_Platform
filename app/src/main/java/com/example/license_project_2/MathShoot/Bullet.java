package com.example.license_project_2.MathShoot;

import static com.example.license_project_2.MathShoot.GameView.screenRatioX;
import static com.example.license_project_2.MathShoot.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.license_project_2.R;

public class Bullet {
    int x, y, width, height;
    Bitmap bullet;

    Bullet(Resources resources){
        bullet = BitmapFactory.decodeResource(resources, R.drawable.bullet);

        width = bullet.getWidth();
        height = bullet.getHeight();

        width /= 5;
        height /= 5;

        width = (int)(width * screenRatioX);
        height = (int)(height * screenRatioY);

        bullet = Bitmap.createScaledBitmap(bullet, width, height, false);
    }

    public Rect getCollisionShape(){
        return new Rect(x, y, x + width, y + height);
    }
}

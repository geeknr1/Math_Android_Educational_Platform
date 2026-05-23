package com.example.license_project_2.MathShoot;

import static com.example.license_project_2.MathShoot.GameView.screenRatioX;
import static com.example.license_project_2.MathShoot.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.license_project_2.R;

public class Number {
    public int speed = 10;
    int x = 0, y, width, height;
    private final Bitmap display;

    Number(Resources resource, int which){
        Bitmap a = BitmapFactory.decodeResource(resource, R.drawable.a);
        Bitmap b = BitmapFactory.decodeResource(resource, R.drawable.b);
        Bitmap c = BitmapFactory.decodeResource(resource, R.drawable.c);
        Bitmap d = BitmapFactory.decodeResource(resource, R.drawable.d);
        Bitmap e = BitmapFactory.decodeResource(resource, R.drawable.e);
        Bitmap f = BitmapFactory.decodeResource(resource, R.drawable.f);
        Bitmap g = BitmapFactory.decodeResource(resource, R.drawable.g);
        Bitmap h = BitmapFactory.decodeResource(resource, R.drawable.h);
        Bitmap i = BitmapFactory.decodeResource(resource, R.drawable.i);

        width = a.getWidth();
        height = a.getHeight();

        width = Math.max(1, (int) ((width / 10f) * screenRatioX));
        height = Math.max(1, (int) ((height / 10f) * screenRatioY));

        width *= 5;
        height *= 5;

        a = Bitmap.createScaledBitmap(a, width, height, false);
        b = Bitmap.createScaledBitmap(b, width, height, false);
        c = Bitmap.createScaledBitmap(c, width, height, false);
        d = Bitmap.createScaledBitmap(d, width, height, false);
        e = Bitmap.createScaledBitmap(e, width, height, false);
        f = Bitmap.createScaledBitmap(f, width, height, false);
        g = Bitmap.createScaledBitmap(g, width, height, false);
        h = Bitmap.createScaledBitmap(h, width, height, false);
        i = Bitmap.createScaledBitmap(i, width, height, false);
        Bitmap[] frames = {a, b, c, d, e, f, g, h, i};
        display = frames[Math.floorMod(which, 9)];
    }

    public Bitmap getNumber() {
        return display;
    }

    public Rect getCollisionShape(){
        return new Rect(x, y, x + width, y + height);
    }
}


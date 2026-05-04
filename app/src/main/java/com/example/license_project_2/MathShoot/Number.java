package com.example.license_project_2.MathShoot;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.license_project_2.R;

public class Number {
    public int speed = 10;
    int x = 0, y, width, height, numberCounter = 1;
    Bitmap a, b, c, d, e, f, g, h, i;

    Number(Resources resource){
        a = BitmapFactory.decodeResource(resource, R.drawable.a);
        b = BitmapFactory.decodeResource(resource, R.drawable.b);
        c = BitmapFactory.decodeResource(resource, R.drawable.c);
        d = BitmapFactory.decodeResource(resource, R.drawable.d);
        e = BitmapFactory.decodeResource(resource, R.drawable.e);
        f = BitmapFactory.decodeResource(resource, R.drawable.f);
        g = BitmapFactory.decodeResource(resource, R.drawable.g);
        h = BitmapFactory.decodeResource(resource, R.drawable.h);
        i = BitmapFactory.decodeResource(resource, R.drawable.i);

        width = a.getWidth();
        height = a.getHeight();

        width /= 10;
        height /= 10;

        a = Bitmap.createScaledBitmap(a, width, height, false);
        b = Bitmap.createScaledBitmap(b, width, height, false);
        c = Bitmap.createScaledBitmap(c, width, height, false);
        d = Bitmap.createScaledBitmap(d, width, height, false);
        e = Bitmap.createScaledBitmap(e, width, height, false);
        f = Bitmap.createScaledBitmap(f, width, height, false);
        g = Bitmap.createScaledBitmap(g, width, height, false);
        h = Bitmap.createScaledBitmap(h, width, height, false);
        i = Bitmap.createScaledBitmap(i, width, height, false);

        y = -height;
    }

//    public Bitmap getNumber(){
//        if(numberCounter == 1){
//            numberCounter++;
//            return a;
//        }
//        if(numberCounter == 2){
//            numberCounter++;
//            return b;
//        }
//        if(numberCounter == 3){
//            numberCounter++;
//            return c;
//        }
//        if(numberCounter == 4){
//            numberCounter++;
//            return d;
//        }
//        if(numberCounter == 5){
//            numberCounter++;
//            return e;
//        }
//        if(numberCounter == 6){
//            numberCounter++;
//            return f;
//        }
//        if(numberCounter == 7){
//            numberCounter++;
//            return g;
//        }
//        if(numberCounter == 8){
//            numberCounter++;
//            return h;
//        }
//        return null;
//    }

    public Rect getCollisionShape(){
        return new Rect(x, y, x + width, y + height);
    }
}

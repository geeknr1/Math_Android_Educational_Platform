package com.example.license_project_2.MathShoot;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.license_project_2.R;

public class Background {
    int x = 0, y = 0;
    Bitmap background;
    Background(int screenX, int screenY, Resources resources){
        background = BitmapFactory.decodeResource(resources, R.drawable.flygamebackground);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);
    }
}

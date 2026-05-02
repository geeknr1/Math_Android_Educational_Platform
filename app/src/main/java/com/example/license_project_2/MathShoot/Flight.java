package com.example.license_project_2.MathShoot;

import static com.example.license_project_2.MathShoot.GameView.screenRatioX;
import static com.example.license_project_2.MathShoot.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.license_project_2.R;

public class Flight {
    public boolean isGoingUp = false, isGoingDown = false;
    public int toShoot = 0;
    int x, y, width, height, wingCounter = 0, shootCounter = 1;
    Bitmap flightOne, flightTwo, shootOne, shootTwo, shootThree, shootFour, shootFive, dead;
    private GameView gameView;
    Flight(GameView gameView, int screenY, Resources resources){
        this.gameView = gameView;
        flightOne = BitmapFactory.decodeResource(resources, R.drawable.fly1);
        flightTwo = BitmapFactory.decodeResource(resources, R.drawable.fly2);

        width = flightOne.getWidth();
        height = flightOne.getHeight();

        width /= 4;
        height /= 4;

        width = (int)(width * screenRatioX);
        height = (int)(height *screenRatioY);

        flightOne = Bitmap.createScaledBitmap(flightOne, width, height, false);
        flightTwo = Bitmap.createScaledBitmap(flightTwo, width, height, false);

        shootOne = BitmapFactory.decodeResource(resources, R.drawable.shoot1);
        shootTwo = BitmapFactory.decodeResource(resources, R.drawable.shoot2);
        shootThree = BitmapFactory.decodeResource(resources, R.drawable.shoot3);
        shootFour = BitmapFactory.decodeResource(resources, R.drawable.shoot4);
        shootFive = BitmapFactory.decodeResource(resources, R.drawable.shoot5);

        shootOne = Bitmap.createScaledBitmap(shootOne, width, height, false);
        shootTwo = Bitmap.createScaledBitmap(shootTwo, width, height, false);
        shootThree = Bitmap.createScaledBitmap(shootThree, width, height, false);
        shootFour = Bitmap.createScaledBitmap(shootFour, width, height, false);
        shootFive = Bitmap.createScaledBitmap(shootFive, width, height, false);

        dead = BitmapFactory.decodeResource(resources, R.drawable.dead);
        dead = Bitmap.createScaledBitmap(dead, width, height, false);

        y = screenY / 2;
        x = (int)(64 * screenRatioX);
    }

    public Bitmap getFlight(){
        if(toShoot != 0){
            if(shootCounter == 1){
                shootCounter++;
                return shootOne;
            }
            if(shootCounter == 2){
                shootCounter++;
                return shootTwo;
            }
            if(shootCounter == 3){
                shootCounter++;
                return shootThree;
            }
            if(shootCounter == 4){
                shootCounter++;
                return shootFour;
            }
            shootCounter = 1;
            toShoot--;
            gameView.newBullet();

            return shootFive;
        }

        if(wingCounter == 0){
            wingCounter++;
            return flightOne;
        }
        wingCounter--;
        return flightTwo;
    }

    public Rect getCollisionShape(){
        return new Rect(x, y, x + width, y + height);
    }
    public Bitmap getDead(){
        return dead;
    }
}

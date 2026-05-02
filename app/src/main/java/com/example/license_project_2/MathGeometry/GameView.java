package com.example.license_project_2.MathGeometry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.res.ResourcesCompat;

import com.example.license_project_2.R;
import java.util.ArrayList;
import java.util.Random;

public class GameView extends View {

    static int dWidth, dHeight;
    Bitmap background, ground, kid;
    Rect rectBackground, rectGround;
    Context context;
    Handler handler;
    final long UPDATE_MILLIS = 30;
    Runnable runnable;
    Paint textPaint = new Paint(), healthPaint = new Paint();
    float TEXT_SIZE = 120;
    int  points = 0, healthBar = 3;
    Random random;
    float kidX, kidY, oldX, oldKidX;
    ArrayList<Figure> figures;
    ArrayList<Explosion> explosions;

    public GameView(Context context){
        super(context);
        this.context = context;
        background = BitmapFactory.decodeResource(getResources(), R.drawable.countryside);
        ground = BitmapFactory.decodeResource(getResources(), R.drawable.ground);
        kid = BitmapFactory.decodeResource(getResources(), R.drawable.studentthree);
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = size.y;
        rectBackground = new Rect(0, 0, dWidth, dHeight);
        rectGround = new Rect(0, dHeight - ground.getHeight(), dWidth, dHeight);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        textPaint.setColor(Color.rgb(255, 165, 0));
        textPaint.setTextSize(TEXT_SIZE);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setTypeface(ResourcesCompat.getFont(context, R.font.kenney_blocks));
        healthPaint.setColor(Color.GREEN);
        random = new Random();
        kidX = dWidth / 2 - kid.getWidth() / 2;
        kidY = dHeight - ground.getHeight() - kid.getHeight() + 900;
        figures = new ArrayList<>();
        explosions = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Figure figure = new Figure(context);
            figures.add(figure);
        }
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(background, null, rectBackground, null);
        canvas.drawBitmap(ground, null, rectGround, null);
        canvas.drawBitmap(kid, kidX, kidY, null);
        for(int i = 0; i < figures.size(); i++){
            canvas.drawBitmap(figures.get(i).getFigure(figures.get(i).figureFrame), figures.get(i).figureX, figures.get(i).figureY, null);
            figures.get(i).figureY += figures.get(i).figureVelocity;
            if(figures.get(i).figureY + figures.get(i).getFigureHeight() >= dHeight - ground.getHeight() + 900){
                points += 10;
                Explosion explosion = new Explosion(context);
                explosion.explosionX = figures.get(i).figureX;
                explosion.explosionY = figures.get(i).figureY;
                explosions.add(explosion);
                figures.get(i).resetPosition();
            }
        }

        for(int i = 0; i < figures.size(); i++){
            if(figures.get(i).figureX + figures.get(i).getFigureWidth() >= kidX && figures.get(i).figureX <= kidX + kid.getWidth()
               && figures.get(i).figureY + figures.get(i).getFigureWidth() >= kidY && figures.get(i).figureY + figures.get(i).getFigureWidth() <= kidY + kid.getHeight()){
                healthBar --;
                figures.get(i).resetPosition();
                if(healthBar == 0){
                    Intent intent = new Intent(context, GameOver.class);
                    intent.putExtra("points", points);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }
            }
        }

        for(int i = 0; i < explosions.size(); i++){
            canvas.drawBitmap(explosions.get(i).getExplosion(explosions.get(i).explosionFrame),
                             explosions.get(i).explosionX, explosions.get(i).explosionY, null);
            explosions.get(i).explosionFrame++;
            if(explosions.get(i).explosionFrame > 3){
                explosions.remove(i);
            }
        }

        if(healthBar == 2)
            healthPaint.setColor(Color.YELLOW);
        else if (healthBar == 1)
            healthPaint.setColor(Color.RED);
        canvas.drawRect(dWidth - 200, 30, dWidth - 200 + 60 * healthBar, 80, healthPaint);
        canvas.drawText("" + points, 20, TEXT_SIZE, textPaint);
        handler.postDelayed(runnable, UPDATE_MILLIS);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX(), touchY = event.getY();
        if(touchY >= kidY){
            int action = event.getAction();
            if(action == MotionEvent.ACTION_DOWN){
                oldX = event.getX();
                oldKidX = kidX;
            }
            if(action == MotionEvent.ACTION_MOVE){
                float shift = oldX - touchX, newKidX = oldKidX - shift;
                if(newKidX <= 0)
                    newKidX = 0;
                else if(newKidX >= dWidth - kid.getWidth())
                    kidX = dWidth - kid.getWidth();
                else
                    kidX = newKidX;
            }
        }
        return true;
    }
}

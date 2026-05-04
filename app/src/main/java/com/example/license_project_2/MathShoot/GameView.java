package com.example.license_project_2.MathShoot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

public class GameView extends SurfaceView implements Runnable {
    private Thread thread;
    private boolean isPlaying, isGameOver = false;
    private Background backgroundOne, backgroundTwo;
    private int screenX, screenY;
    private float oldY = 0;
    public static float screenRatioX, screenRatioY;
    private Paint paint;
    private Flight flight;
    private ArrayList<Bullet>bullets;
    private Number[] numbers;
    private Random random;
    public GameView(Context context, int screenX, int screenY) {
        super(context);
        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;
        backgroundOne = new Background(screenX, screenY, getResources());
        backgroundTwo = new Background(screenX, screenY, getResources());
        flight = new Flight(this, screenY, getResources());
        paint = new Paint();
        bullets = new ArrayList<>();
        backgroundTwo.x = screenX;

        numbers = new Number[9];
        for(int i = 0; i < 9; i++){
            Number number = new Number(getResources());
            numbers[i] = number;
        }
        random = new Random();
    }

    @Override
    public void run() {
        while(isPlaying){
            update();
            draw();
            try {
                sleep();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update(){
        backgroundOne.x -= (int) (10 * screenRatioX);
        backgroundTwo.x -= (int) (10 * screenRatioX);

        if(backgroundOne.x + backgroundOne.background.getWidth() < 0)
            backgroundOne.x = screenX;
        if(backgroundTwo.x + backgroundTwo.background.getWidth() < 0)
            backgroundTwo.x = screenX;

        if(flight.isGoingUp)
            flight.y -= 30 * screenRatioY;
        if(flight.isGoingDown)
            flight.y += 30 * screenRatioY;

        if(flight.y < 0)
            flight.y = 0;

        if(flight.y > screenY - flight.height)
            flight.y = screenY - flight.height;

        ArrayList<Bullet> trashBullets = new ArrayList<>();
        for(Bullet bullet: bullets){
            if(bullet.x > screenX)
                trashBullets.add(bullet);
            bullet.x += 50 * screenRatioX;

            for(Number number : numbers){
                if(Rect.intersects(number.getCollisionShape(), bullet.getCollisionShape())){
                    number.x = -500;
                    bullet.x = screenX + 500;
                }
            }
        }

        for(Bullet bullet: trashBullets)
            bullets.remove(bullet);

        for(Number number : numbers){
            number.x -= number.speed;
            if(number.x + number.width < 0){
                int bound = (int)(30 * screenRatioX);
                number.speed = random.nextInt(bound);

                if(number.speed < 5)
                    number.speed = random.nextInt(bound);

                if(number.speed < 10 * screenRatioX)
                    number.speed = (int)(10 * screenRatioX);

                number.x = screenX;
                number.y = random.nextInt(screenY - number.height);
            }

        }
    }

    private void draw(){
        if(getHolder().getSurface().isValid()){
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(backgroundOne.background, backgroundOne.x, backgroundOne.y, paint);
            canvas.drawBitmap(backgroundTwo.background, backgroundTwo.x, backgroundTwo.y, paint);

            if(isGameOver){
                isPlaying = false;
                canvas.drawBitmap(flight.getDead(), flight.x, flight.y, paint);
                getHolder().unlockCanvasAndPost(canvas);
                return;
            }

            for(Number number: numbers){
                canvas.drawBitmap(number.getNumber(), number.x, number.y, paint);
            }

            canvas.drawBitmap(flight.getFlight(), flight.x, flight.y, paint);

            for(Bullet bullet: bullets)
                canvas.drawBitmap(bullet.bullet, bullet.x, bullet.y, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(20);
    }

    public void resume(){
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause(){
        try{
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                oldY = event.getY();
                if(event.getX() > screenX / 2)
                    flight.toShoot++;
                break;
            case MotionEvent.ACTION_UP:
                flight.isGoingUp = false;
                flight.isGoingDown = false;
                break;
            case MotionEvent.ACTION_MOVE:
                flight.isGoingUp = event.getY() < oldY;
                flight.isGoingDown = event.getY() > oldY;
                oldY = event.getY();
                break;
        }
        return true;
    }

    public void newBullet() {
        Bullet bullet = new Bullet(getResources());
        bullet.x = flight.x + flight.width;
        bullet.y = flight.y + flight.height/2;
        bullets.add(bullet);
    }
}

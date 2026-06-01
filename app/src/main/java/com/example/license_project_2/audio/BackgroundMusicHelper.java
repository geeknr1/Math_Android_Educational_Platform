package com.example.license_project_2.audio;

import android.content.Context;
import android.media.MediaPlayer;

public class BackgroundMusicHelper {
    private static final float VOLUME = 0.70f;

    private MediaPlayer player;
    private int currentResId;

    public void start(Context context, int rawResId) {
        if (player != null && currentResId == rawResId && player.isPlaying()) {
            return;
        }
        stop();
        player = MediaPlayer.create(context.getApplicationContext(), rawResId);
        if (player == null) {
            return;
        }
        currentResId = rawResId;
        player.setLooping(true);
        player.setVolume(VOLUME, VOLUME);
        player.start();
    }

    public void pause() {
        if (player != null && player.isPlaying()) {
            player.pause();
        }
    }

    public void stop() {
        if (player != null) {
            player.release();
            player = null;
            currentResId = 0;
        }
    }
}

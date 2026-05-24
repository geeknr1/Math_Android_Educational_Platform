package com.example.license_project_2.notifications.providers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.license_project_2.Games;
import com.example.license_project_2.R;
import com.example.license_project_2.notifications.NotificationItem;
import com.example.license_project_2.notifications.NotificationProvider;

import java.util.ArrayList;
import java.util.List;

public class GameHighScoreProvider implements NotificationProvider {

    public static final String PROVIDER_ID = "game_highscore";
    public static final String NOTIFICATION_ID = "game_highscore_reminder";
    private static final String PREFS_NAME = "my_pref";
    private static final String KEY_HIGHEST = "highest";

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public List<NotificationItem> getNotifications(Context context) {
        List<NotificationItem> items = new ArrayList<>();
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        int highest = prefs.getInt(KEY_HIGHEST, 0);

        if (highest > 0) {
            items.add(new NotificationItem(
                    NOTIFICATION_ID,
                    context.getString(R.string.notif_game_highscore_title),
                    context.getString(R.string.notif_game_highscore_message, highest),
                    PROVIDER_ID,
                    System.currentTimeMillis(),
                    Games.class
            ));
        }
        return items;
    }

    @Override
    public void onNotificationClicked(Context context, NotificationItem item) {
        Intent intent = new Intent(context, Games.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void scheduleReminders(Context context) {
        // In-app only; high score reminders appear when a score exists.
    }
}

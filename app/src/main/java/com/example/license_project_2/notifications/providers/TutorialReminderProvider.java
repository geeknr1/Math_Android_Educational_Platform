package com.example.license_project_2.notifications.providers;

import android.content.Context;
import android.content.Intent;

import com.example.license_project_2.Algebra;
import com.example.license_project_2.Geometry;
import com.example.license_project_2.R;
import com.example.license_project_2.Tutorial;
import com.example.license_project_2.notifications.NotificationItem;
import com.example.license_project_2.notifications.NotificationProvider;

import java.util.ArrayList;
import java.util.List;

public class TutorialReminderProvider implements NotificationProvider {

    public static final String PROVIDER_ID = "tutorial";
    public static final String NOTIFICATION_ALGEBRA = "tutorial_algebra";
    public static final String NOTIFICATION_GEOMETRY = "tutorial_geometry";

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public List<NotificationItem> getNotifications(Context context) {
        List<NotificationItem> items = new ArrayList<>();
        long now = System.currentTimeMillis();

        items.add(new NotificationItem(
                NOTIFICATION_ALGEBRA,
                context.getString(R.string.notif_tutorial_algebra_title),
                context.getString(R.string.notif_tutorial_algebra_message),
                PROVIDER_ID,
                now,
                Algebra.class
        ));

        items.add(new NotificationItem(
                NOTIFICATION_GEOMETRY,
                context.getString(R.string.notif_tutorial_geometry_title),
                context.getString(R.string.notif_tutorial_geometry_message),
                PROVIDER_ID,
                now - 1,
                Geometry.class
        ));

        return items;
    }

    @Override
    public void onNotificationClicked(Context context, NotificationItem item) {
        Class<?> target = item.getTargetActivity();
        if (target == null) {
            target = Tutorial.class;
        }
        Intent intent = new Intent(context, target);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void scheduleReminders(Context context) {
        // In-app only; no scheduled push for tutorial reminders.
    }
}

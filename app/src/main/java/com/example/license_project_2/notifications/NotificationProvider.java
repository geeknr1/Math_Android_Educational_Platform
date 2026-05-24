package com.example.license_project_2.notifications;

import android.content.Context;

import java.util.List;

public interface NotificationProvider {

    String getId();

    List<NotificationItem> getNotifications(Context context);

    void onNotificationClicked(Context context, NotificationItem item);

    void scheduleReminders(Context context);
}

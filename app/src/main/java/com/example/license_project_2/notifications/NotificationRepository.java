package com.example.license_project_2.notifications;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class NotificationRepository {

    private static final String PREFS_NAME = "notification_prefs";
    private static final String KEY_READ_IDS = "read_notification_ids";
    private static final String KEY_LAST_ACTIVITY_DATE = "last_activity_date";

    private final SharedPreferences prefs;

    public NotificationRepository(Context context) {
        prefs = context.getApplicationContext()
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public boolean isRead(String notificationId) {
        return getReadIds().contains(notificationId);
    }

    public void markAsRead(String notificationId) {
        Set<String> readIds = getReadIds();
        readIds.add(notificationId);
        prefs.edit().putStringSet(KEY_READ_IDS, readIds).apply();
    }

    public void markAllAsRead(Iterable<NotificationItem> items) {
        Set<String> readIds = getReadIds();
        for (NotificationItem item : items) {
            readIds.add(item.getId());
        }
        prefs.edit().putStringSet(KEY_READ_IDS, readIds).apply();
    }

    public int getUnreadCount(Iterable<NotificationItem> items) {
        int count = 0;
        for (NotificationItem item : items) {
            if (!isRead(item.getId())) {
                count++;
            }
        }
        return count;
    }

    public void recordActivityToday(String todayKey) {
        prefs.edit().putString(KEY_LAST_ACTIVITY_DATE, todayKey).apply();
    }

    public String getLastActivityDate() {
        return prefs.getString(KEY_LAST_ACTIVITY_DATE, "");
    }

    private Set<String> getReadIds() {
        Set<String> stored = prefs.getStringSet(KEY_READ_IDS, null);
        if (stored == null) {
            return new HashSet<>();
        }
        return new HashSet<>(stored);
    }
}

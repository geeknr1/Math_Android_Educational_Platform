package com.example.license_project_2.notifications.providers;

import android.content.Context;
import android.content.Intent;

import com.example.license_project_2.R;
import com.example.license_project_2.Tutorial;
import com.example.license_project_2.notifications.NotificationItem;
import com.example.license_project_2.notifications.NotificationProvider;
import com.example.license_project_2.notifications.NotificationRepository;
import com.example.license_project_2.notifications.ReminderScheduler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DailyStudyReminderProvider implements NotificationProvider {

    public static final String PROVIDER_ID = "daily_study";
    public static final String NOTIFICATION_ID = "daily_study_reminder";
    public static final int REMINDER_HOUR = 18;
    public static final int REMINDER_MINUTE = 0;

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public List<NotificationItem> getNotifications(Context context) {
        List<NotificationItem> items = new ArrayList<>();
        NotificationRepository repository = new NotificationRepository(context);
        String today = getTodayKey();

        if (!today.equals(repository.getLastActivityDate())) {
            items.add(new NotificationItem(
                    NOTIFICATION_ID,
                    context.getString(R.string.notif_daily_study_title),
                    context.getString(R.string.notif_daily_study_message),
                    PROVIDER_ID,
                    System.currentTimeMillis(),
                    Tutorial.class
            ));
        }
        return items;
    }

    @Override
    public void onNotificationClicked(Context context, NotificationItem item) {
        Intent intent = new Intent(context, Tutorial.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void scheduleReminders(Context context) {
        ReminderScheduler.scheduleDailyReminder(
                context,
                NOTIFICATION_ID,
                REMINDER_HOUR,
                REMINDER_MINUTE,
                context.getString(R.string.notif_daily_study_title),
                context.getString(R.string.notif_daily_study_push_message)
        );
    }

    public static String getTodayKey() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    public static void recordActivity(Context context) {
        NotificationRepository repository = new NotificationRepository(context);
        repository.recordActivityToday(getTodayKey());
    }
}

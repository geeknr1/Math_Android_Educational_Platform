package com.example.license_project_2.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.license_project_2.MainActivity;
import com.example.license_project_2.R;
import com.example.license_project_2.notifications.providers.DailyStudyReminderProvider;

public class ReminderReceiver extends BroadcastReceiver {

    public static final String EXTRA_REMINDER_ID = "reminder_id";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_MESSAGE = "message";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }

        String reminderId = intent.getStringExtra(EXTRA_REMINDER_ID);
        String title = intent.getStringExtra(EXTRA_TITLE);
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        if (reminderId == null || title == null || message == null) {
            return;
        }

        NotificationChannelHelper.createChannel(context);

        Intent openIntent = new Intent(context, MainActivity.class);
        openIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            flags |= PendingIntent.FLAG_IMMUTABLE;
        }

        PendingIntent contentIntent = PendingIntent.getActivity(
                context,
                reminderId.hashCode(),
                openIntent,
                flags
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, NotificationChannelHelper.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_bell)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setContentIntent(contentIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(reminderId.hashCode(), builder.build());
        }

        if (DailyStudyReminderProvider.NOTIFICATION_ID.equals(reminderId)) {
            ReminderScheduler.scheduleDailyReminder(
                    context,
                    reminderId,
                    DailyStudyReminderProvider.REMINDER_HOUR,
                    DailyStudyReminderProvider.REMINDER_MINUTE,
                    title,
                    message
            );
        }
    }
}

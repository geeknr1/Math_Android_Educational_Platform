package com.example.license_project_2.notifications;

import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.license_project_2.NotificationsActivity;
import com.example.license_project_2.R;
import com.example.license_project_2.notifications.providers.DailyStudyReminderProvider;

public class NotificationBellHelper {

    private final AppCompatActivity activity;
    private final NotificationRegistry registry;
    private ImageButton bellButton;
    private TextView badgeView;

    private NotificationBellHelper(AppCompatActivity activity) {
        this.activity = activity;
        this.registry = NotificationRegistry.getInstance(activity);
    }

    public static NotificationBellHelper attach(AppCompatActivity activity) {
        NotificationBellHelper helper = new NotificationBellHelper(activity);
        helper.setup();
        return helper;
    }

    private void setup() {
        bellButton = activity.findViewById(R.id.notificationBellButton);
        badgeView = activity.findViewById(R.id.notificationBadge);

        if (bellButton == null) {
            return;
        }

        Animation bounce = AnimationUtils.loadAnimation(activity, R.anim.bounce);
        bellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bellButton.startAnimation(bounce);
                activity.startActivity(new Intent(activity, NotificationsActivity.class));
            }
        });

        refreshBadge();
        DailyStudyReminderProvider.recordActivity(activity);
    }

    public void refreshBadge() {
        if (badgeView == null) {
            return;
        }

        int unread = registry.getUnreadCount(activity);
        if (unread > 0) {
            badgeView.setVisibility(View.VISIBLE);
            badgeView.setText(unread > 9 ? "9+" : String.valueOf(unread));
        } else {
            badgeView.setVisibility(View.GONE);
        }
    }

    public void onResume() {
        refreshBadge();
        DailyStudyReminderProvider.recordActivity(activity);
    }
}

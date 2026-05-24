package com.example.license_project_2.notifications;

import android.content.Context;

import com.example.license_project_2.notifications.providers.DailyStudyReminderProvider;
import com.example.license_project_2.notifications.providers.GameHighScoreProvider;
import com.example.license_project_2.notifications.providers.TutorialReminderProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NotificationRegistry {

    private static NotificationRegistry instance;

    private final List<NotificationProvider> providers = new ArrayList<>();
    private final NotificationRepository repository;

    private NotificationRegistry(Context context) {
        repository = new NotificationRepository(context.getApplicationContext());
        register(new DailyStudyReminderProvider());
        register(new TutorialReminderProvider());
        register(new GameHighScoreProvider());
    }

    public static synchronized NotificationRegistry getInstance(Context context) {
        if (instance == null) {
            instance = new NotificationRegistry(context);
        }
        return instance;
    }

    public void register(NotificationProvider provider) {
        providers.add(provider);
    }

    public NotificationRepository getRepository() {
        return repository;
    }

    public List<NotificationItem> getAllNotifications(Context context) {
        List<NotificationItem> all = new ArrayList<>();
        for (NotificationProvider provider : providers) {
            all.addAll(provider.getNotifications(context));
        }
        Collections.sort(all, new Comparator<NotificationItem>() {
            @Override
            public int compare(NotificationItem a, NotificationItem b) {
                return Long.compare(b.getTimestamp(), a.getTimestamp());
            }
        });
        return all;
    }

    public int getUnreadCount(Context context) {
        return repository.getUnreadCount(getAllNotifications(context));
    }

    public NotificationProvider findProvider(String providerId) {
        for (NotificationProvider provider : providers) {
            if (provider.getId().equals(providerId)) {
                return provider;
            }
        }
        return null;
    }

    public void scheduleAllReminders(Context context) {
        for (NotificationProvider provider : providers) {
            provider.scheduleReminders(context);
        }
    }
}

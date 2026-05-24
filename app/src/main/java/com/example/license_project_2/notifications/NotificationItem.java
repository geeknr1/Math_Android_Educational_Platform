package com.example.license_project_2.notifications;

public class NotificationItem {

    private final String id;
    private final String title;
    private final String message;
    private final String providerId;
    private final long timestamp;
    private final Class<?> targetActivity;

    public NotificationItem(String id, String title, String message, String providerId,
                            long timestamp, Class<?> targetActivity) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.providerId = providerId;
        this.timestamp = timestamp;
        this.targetActivity = targetActivity;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getProviderId() {
        return providerId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Class<?> getTargetActivity() {
        return targetActivity;
    }
}

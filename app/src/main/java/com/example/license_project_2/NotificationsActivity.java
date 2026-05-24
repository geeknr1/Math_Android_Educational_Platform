package com.example.license_project_2;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.license_project_2.notifications.NotificationItem;
import com.example.license_project_2.notifications.NotificationProvider;
import com.example.license_project_2.notifications.NotificationRegistry;
import com.example.license_project_2.notifications.NotificationRepository;

import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

    private NotificationRegistry registry;
    private NotificationRepository repository;
    private NotificationAdapter adapter;
    private RecyclerView recyclerView;
    private TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_notifications);

        registry = NotificationRegistry.getInstance(this);
        repository = registry.getRepository();

        recyclerView = findViewById(R.id.notificationsRecyclerView);
        emptyView = findViewById(R.id.notificationsEmptyView);
        ImageButton backButton = findViewById(R.id.notificationsBackButton);
        TextView markAllReadButton = findViewById(R.id.markAllReadButton);

        adapter = new NotificationAdapter(repository, new NotificationAdapter.OnNotificationClickListener() {
            @Override
            public void onNotificationClick(NotificationItem item) {
                repository.markAsRead(item.getId());
                NotificationProvider provider = registry.findProvider(item.getProviderId());
                if (provider != null) {
                    provider.onNotificationClicked(NotificationsActivity.this, item);
                }
                finish();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        markAllReadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<NotificationItem> items = registry.getAllNotifications(NotificationsActivity.this);
                repository.markAllAsRead(items);
                loadNotifications();
            }
        });

        loadNotifications();
    }

    private void loadNotifications() {
        List<NotificationItem> items = registry.getAllNotifications(this);
        adapter.setItems(items);

        if (items.isEmpty()) {
            emptyView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            emptyView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }
}

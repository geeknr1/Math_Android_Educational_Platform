package com.example.license_project_2;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.license_project_2.notifications.providers.DailyStudyReminderProvider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class NotificationTest {
    private String getTodayKey() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }
    private boolean shouldShowDailyReminder(
            String lastActivityDate, String todayKey){
        return !todayKey.equals(lastActivityDate);
    }

    @Test
    public void testGetTodayKey_hasCorrectFormat() {
        String key = getTodayKey();
        assertTrue(key.matches("\\d{4}-\\d{2}-\\d{2}"));
    }

    @Test
    public void testShouldShowDailyReminder_notActiveToday_returnsTrue() {
        assertTrue(shouldShowDailyReminder("2025-01-01", "2025-06-13"));
    }

    @Test
    public void testShouldShowDailyReminder_activeToday_returnsFalse() {
        String today = getTodayKey();
        assertFalse(shouldShowDailyReminder(today, today));
    }

    @Test
    public void testDailyReminderHour_isEighteen() {
        assertEquals(18, DailyStudyReminderProvider.REMINDER_HOUR);
    }
}

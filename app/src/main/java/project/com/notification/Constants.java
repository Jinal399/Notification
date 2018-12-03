package project.com.notification;

import android.net.Uri;


    public final class Constants {

        public static final String START_TIME = "timer_start_time";
        public static final String ORIGINAL_TIME = "timer_original_time";
        public static final String DATA_ITEM_PATH = "/timer";
        public static final Uri URI_PATTERN_DATA_ITEMS =
                Uri.fromParts("wear", DATA_ITEM_PATH, null);

        public static final int NOTIFICATION_TIMER_COUNTDOWN = 60;
        public static final int NOTIFICATION_TIMER_EXPIRED = 0;

        public static final String ACTION_SHOW_ALARM
                = "com.android.example.clockwork.timer.ACTION_SHOW";
        public static final String ACTION_DELETE_ALARM
                = "com.android.example.clockwork.timer.ACTION_DELETE";
        public static final String ACTION_RESTART_ALARM
                = "com.android.example.clockwork.timer.ACTION_RESTART";

        private Constants() {
        }

    }


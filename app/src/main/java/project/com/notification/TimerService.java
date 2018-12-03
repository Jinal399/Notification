package project.com.notification;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

/**
 * Service class that manages notifications of the timer.
 */
public class TimerService extends IntentService {

    public static final String TAG = "TimerNotificationSvc";

    public TimerService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "onHandleIntent called with intent: " + intent);
        }


        showTimerDoneNotification();

    }




    private void cancelCountdownNotification() {
        NotificationManager notifyMgr =
                ((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
        notifyMgr.cancel(Constants.NOTIFICATION_TIMER_COUNTDOWN);
    }

    private void showTimerDoneNotification() {
        // Cancel the countdown notification to show the "timer done" notification.
        cancelCountdownNotification();

        // Create an intent to restart a timer.
        Intent restartIntent = new Intent(Constants.ACTION_RESTART_ALARM, null, this,
                TimerService.class);
        PendingIntent pendingIntentRestart = PendingIntent
                .getService(this, 0, restartIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Create notification that timer has expired.
        NotificationManager notifyMgr =
                ((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
        Notification notif = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("hello")
                .setContentText("jinal")
                .setUsesChronometer(true)
                .setWhen(System.currentTimeMillis())
                .addAction(R.drawable.ic_launcher_foreground, "",
                        pendingIntentRestart)
                .setLocalOnly(false)
                .build();
        notifyMgr.notify(Constants.NOTIFICATION_TIMER_EXPIRED, notif);
    }

}
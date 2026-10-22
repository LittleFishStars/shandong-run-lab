package com.fl.saas.s2s.sdk.helper;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.fl.saas.s2s.R;
import com.fl.saas.s2s.sdk.helper.download.DownloadActionReceiver;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CommNotificationHelper extends ContextWrapper {
    private static String CHANNEL_ID = "yd_download_notification";
    public static String NOTIFICATION_CANCEL_DOWNLOAD = "com.fl.saas.s2s.sdk.helper.download.action.cancel";
    private static final int NOTIFICATION_ID = 0;
    public static String NOTIFICATION_PAUSE_DOWNLOAD = "com.fl.saas.s2s.sdk.helper.download.action.pause";
    public static String NOTIFICATION_START_DOWNLOAD = "com.fl.saas.s2s.sdk.helper.download.action.start";
    private String appName;
    private NotificationCompat.Builder builder;
    private String downLoadUrl;
    private NotificationManager manager;
    private RemoteViews remoteViews;

    public CommNotificationHelper(Context context, String str, String str2) {
        super(context);
        this.downLoadUrl = str;
        this.appName = str2;
        str2 = TextUtils.isEmpty(str2) ? "正在下载应用" : str2;
        RemoteViews remoteViews = new RemoteViews(context.getApplicationContext().getPackageName(), R.layout.s2s_download_notification);
        this.remoteViews = remoteViews;
        remoteViews.setImageViewBitmap(R.id.iv_logo, getLargeIcon());
        this.remoteViews.setTextViewText(R.id.tv_name, str2);
        Intent intent = new Intent(this, (Class<?>) DownloadActionReceiver.class);
        intent.setAction(NOTIFICATION_PAUSE_DOWNLOAD);
        intent.putExtra("downLoadUrl", str);
        int i = Build.VERSION.SDK_INT;
        this.remoteViews.setOnClickPendingIntent(R.id.tv_action, PendingIntent.getBroadcast(this, 0, intent, i >= 31 ? 33554432 : 134217728));
        Intent intent2 = new Intent(this, (Class<?>) DownloadActionReceiver.class);
        intent2.setAction(NOTIFICATION_CANCEL_DOWNLOAD);
        intent2.putExtra("downLoadUrl", str);
        this.remoteViews.setOnClickPendingIntent(R.id.tv_cancel, PendingIntent.getBroadcast(this, 0, intent2, i < 31 ? 134217728 : 33554432));
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "应用下载", 2);
        notificationChannel.setSound(null, null);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-65536);
        notificationChannel.setShowBadge(true);
        getManager().createNotificationChannel(notificationChannel);
        this.builder = getNotification();
        getManager().notify(0, this.builder.build());
    }

    private Bitmap getLargeIcon() {
        int identifier = getResources().getIdentifier("s2s_ic_download", "drawable", getPackageName());
        if (identifier != 0) {
            return BitmapFactory.decodeResource(getResources(), identifier);
        }
        return null;
    }

    private NotificationManager getManager() {
        if (this.manager == null) {
            this.manager = (NotificationManager) getSystemService("notification");
        }
        return this.manager;
    }

    private NotificationCompat.Builder getNotification() {
        return new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(getSmallIcon()).setLargeIcon(getLargeIcon()).setCustomContentView(this.remoteViews).setCustomHeadsUpContentView(this.remoteViews).setCustomBigContentView(this.remoteViews).setContent(this.remoteViews).setAutoCancel(true).setPriority(-1).setDefaults(-1);
    }

    private int getSmallIcon() {
        int identifier = getResources().getIdentifier("s2s_ic_download", "drawable", getPackageName());
        return identifier == 0 ? getApplicationInfo().icon : identifier;
    }

    public void cancel() {
        getManager().cancel(0);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0045 A[PHI: r6
      0x0045: PHI (r6v3 android.content.Intent) = (r6v2 android.content.Intent), (r6v9 android.content.Intent) binds: [B:12:0x0043, B:9:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x0048 A[PHI: r6
      0x0048: PHI (r6v7 android.content.Intent) = (r6v2 android.content.Intent), (r6v9 android.content.Intent) binds: [B:12:0x0043, B:9:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    public void changeActionText(boolean z) {
        RemoteViews remoteViews;
        Intent intent;
        int i;
        if (this.builder == null || (remoteViews = this.remoteViews) == null) {
            return;
        }
        if (z) {
            remoteViews.setTextViewText(R.id.tv_action, "暂停");
            intent = new Intent(this, (Class<?>) DownloadActionReceiver.class);
            intent.setAction(NOTIFICATION_PAUSE_DOWNLOAD);
            intent.putExtra("downLoadUrl", this.downLoadUrl);
            if (Build.VERSION.SDK_INT >= 31) {
                i = 33554432;
            } else {
                i = 134217728;
            }
        } else {
            remoteViews.setTextViewText(R.id.tv_action, "继续");
            intent = new Intent(this, (Class<?>) DownloadActionReceiver.class);
            intent.setAction(NOTIFICATION_START_DOWNLOAD);
            intent.putExtra("downLoadUrl", this.downLoadUrl);
            if (Build.VERSION.SDK_INT >= 31) {
                i = 33554432;
            } else {
                i = 134217728;
            }
        }
        this.remoteViews.setOnClickPendingIntent(R.id.tv_action, PendingIntent.getBroadcast(this, 0, intent, i));
        getManager().notify(0, this.builder.setCustomContentView(this.remoteViews).setCustomHeadsUpContentView(this.remoteViews).setCustomBigContentView(this.remoteViews).setContent(this.remoteViews).build());
    }

    public void updateProgress(int i, String str) {
        RemoteViews remoteViews;
        String str2 = i + "%";
        if (this.builder == null || (remoteViews = this.remoteViews) == null) {
            return;
        }
        remoteViews.setTextViewText(R.id.tv_down_tips, str);
        this.remoteViews.setTextViewText(R.id.tv_progress, str2);
        this.remoteViews.setProgressBar(R.id.pb_progress, 100, i, false);
        getManager().notify(0, this.builder.setCustomContentView(this.remoteViews).setCustomHeadsUpContentView(this.remoteViews).setCustomBigContentView(this.remoteViews).setContent(this.remoteViews).build());
    }
}

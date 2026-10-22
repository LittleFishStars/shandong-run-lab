package com.fl.saas;

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
import com.fl.saas.adx.base.download.DownloadActionReceiver;

/* JADX INFO: renamed from: com.fl.saas.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class C1441w extends ContextWrapper {
    private static String f = "fl_download_notification";
    public static String g = "com.fl.saas.s2s.sdk.helper.download.action.start";
    public static String h = "com.fl.saas.s2s.sdk.helper.download.action.pause";
    public static String i = "com.fl.saas.s2s.sdk.helper.download.action.cancel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NotificationManager f30203a;
    private RemoteViews b;
    private NotificationCompat.Builder c;
    private String d;
    private String e;

    public C1441w(Context context, String str, String str2) {
        super(context);
        this.d = str;
        this.e = str2;
        str2 = TextUtils.isEmpty(str2) ? "正在下载应用" : str2;
        RemoteViews remoteViews = new RemoteViews(context.getApplicationContext().getPackageName(), R.layout.fl_adx_download_notification);
        this.b = remoteViews;
        remoteViews.setImageViewBitmap(R.id.iv_logo, b());
        this.b.setTextViewText(R.id.tv_name, str2);
        Intent intent = new Intent(this, (Class<?>) DownloadActionReceiver.class);
        intent.setAction(h);
        intent.putExtra("downLoadUrl", str);
        int i2 = Build.VERSION.SDK_INT;
        this.b.setOnClickPendingIntent(R.id.tv_action, PendingIntent.getBroadcast(this, 0, intent, i2 >= 31 ? 33554432 : 134217728));
        Intent intent2 = new Intent(this, (Class<?>) DownloadActionReceiver.class);
        intent2.setAction(i);
        intent2.putExtra("downLoadUrl", str);
        this.b.setOnClickPendingIntent(R.id.tv_cancel, PendingIntent.getBroadcast(this, 0, intent2, i2 < 31 ? 134217728 : 33554432));
        NotificationChannel notificationChannel = new NotificationChannel(f, "应用下载", 2);
        notificationChannel.setSound(null, null);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-65536);
        notificationChannel.setShowBadge(true);
        c().createNotificationChannel(notificationChannel);
        this.c = d();
        c().notify(0, this.c.build());
    }

    private Bitmap b() {
        int identifier = getResources().getIdentifier("fl_ic_download", "drawable", getPackageName());
        if (identifier != 0) {
            return BitmapFactory.decodeResource(getResources(), identifier);
        }
        return null;
    }

    private NotificationManager c() {
        if (this.f30203a == null) {
            this.f30203a = (NotificationManager) getSystemService("notification");
        }
        return this.f30203a;
    }

    private NotificationCompat.Builder d() {
        return new NotificationCompat.Builder(this, f).setSmallIcon(e()).setLargeIcon(b()).setCustomContentView(this.b).setCustomHeadsUpContentView(this.b).setCustomBigContentView(this.b).setContent(this.b).setAutoCancel(true).setPriority(-1).setDefaults(-1);
    }

    private int e() {
        int identifier = getResources().getIdentifier("fl_ic_download", "drawable", getPackageName());
        return identifier == 0 ? getApplicationInfo().icon : identifier;
    }

    public void a() {
        c().cancel(0);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0045 A[PHI: r6
      0x0045: PHI (r6v3 android.content.Intent) = (r6v2 android.content.Intent), (r6v9 android.content.Intent) binds: [B:12:0x0043, B:9:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x0048 A[PHI: r6
      0x0048: PHI (r6v7 android.content.Intent) = (r6v2 android.content.Intent), (r6v9 android.content.Intent) binds: [B:12:0x0043, B:9:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    public void a(boolean z) {
        RemoteViews remoteViews;
        Intent intent;
        int i2;
        if (this.c == null || (remoteViews = this.b) == null) {
            return;
        }
        if (z) {
            remoteViews.setTextViewText(R.id.tv_action, "暂停");
            intent = new Intent(this, (Class<?>) DownloadActionReceiver.class);
            intent.setAction(h);
            intent.putExtra("downLoadUrl", this.d);
            if (Build.VERSION.SDK_INT >= 31) {
                i2 = 33554432;
            } else {
                i2 = 134217728;
            }
        } else {
            remoteViews.setTextViewText(R.id.tv_action, "继续");
            intent = new Intent(this, (Class<?>) DownloadActionReceiver.class);
            intent.setAction(g);
            intent.putExtra("downLoadUrl", this.d);
            if (Build.VERSION.SDK_INT >= 31) {
                i2 = 33554432;
            } else {
                i2 = 134217728;
            }
        }
        this.b.setOnClickPendingIntent(R.id.tv_action, PendingIntent.getBroadcast(this, 0, intent, i2));
        c().notify(0, this.c.setCustomContentView(this.b).setCustomHeadsUpContentView(this.b).setCustomBigContentView(this.b).setContent(this.b).build());
    }

    public void a(int i2, String str) {
        RemoteViews remoteViews;
        String str2 = i2 + "%";
        if (this.c == null || (remoteViews = this.b) == null) {
            return;
        }
        remoteViews.setTextViewText(R.id.tv_down_tips, str);
        this.b.setTextViewText(R.id.tv_progress, str2);
        this.b.setProgressBar(R.id.pb_progress, 100, i2, false);
        c().notify(0, this.c.setCustomContentView(this.b).setCustomHeadsUpContentView(this.b).setCustomBigContentView(this.b).setContent(this.b).build());
    }
}

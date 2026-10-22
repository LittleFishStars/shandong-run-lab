package com.huachenjie.run.helper;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.huachenjie.run.R;
import com.huachenjie.run.page.sun_run.SunshineRunActivity;
import com.zj.adlib.c82;
import com.zj.adlib.s72;
import java.math.BigDecimal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class SunshineRunNotificationHelper {
    public static final String g = "start";
    public static final String h = "silence";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NotificationManager f12320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f12321a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RemoteViews f12322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NotificationCompat.Builder f12323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MusicReceiver f12324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NotificationCallback f12325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f12326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f12327a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Bitmap f12328b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f12329b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f12330b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Bitmap f12331c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f12332c;
    public Bitmap d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f12333d;
    public String e;
    public String f;

    public class MusicReceiver extends BroadcastReceiver {
        public MusicReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NotificationCallback notificationCallback;
            String action = intent.getAction();
            Log.e("MusicReceiver", action);
            if ("start".equals(action)) {
                NotificationCallback notificationCallback2 = SunshineRunNotificationHelper.this.f12325a;
                if (notificationCallback2 != null) {
                    notificationCallback2.b();
                    return;
                }
                return;
            }
            if (!SunshineRunNotificationHelper.h.equals(action) || (notificationCallback = SunshineRunNotificationHelper.this.f12325a) == null) {
                return;
            }
            notificationCallback.a();
        }
    }

    public interface NotificationCallback {
        void a();

        void b();
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SunshineRunNotificationHelper f35762a = new SunshineRunNotificationHelper();
    }

    public SunshineRunNotificationHelper() {
        this.f12326a = "sunshine_run_channel";
        this.f12329b = "跑步服务";
        this.f35760a = 1100;
        this.f12327a = true;
        this.f12330b = false;
        this.f12332c = "时长 00:00";
        this.f12333d = "时长 00:00";
        this.e = "配速 -/-";
        this.f = "0km/0km";
        this.b = 0;
        this.c = 0;
    }

    public static SunshineRunNotificationHelper d() {
        return a.f35762a;
    }

    public void a(Context context) {
        NotificationManager notificationManager = this.f12320a;
        if (notificationManager == null) {
            return;
        }
        try {
            notificationManager.cancel(1100);
            context.unregisterReceiver(this.f12324a);
        } catch (Exception unused) {
        } finally {
            this.f12323a = null;
        }
    }

    public void b(Context context) {
        this.f12321a = BitmapFactory.decodeResource(context.getResources(), R.drawable.run_sun_noti_start);
        this.f12328b = BitmapFactory.decodeResource(context.getResources(), R.drawable.run_sun_noti_stop);
        this.f12331c = BitmapFactory.decodeResource(context.getResources(), R.drawable.run_sun_noti_silence);
        this.d = BitmapFactory.decodeResource(context.getResources(), R.drawable.run_sun_noti_no_silence);
        this.f12320a = (NotificationManager) context.getApplicationContext().getSystemService("notification");
        p();
        if (this.f12323a != null) {
            a(context);
        }
        f();
        e(context);
        g(context);
        n(context);
        try {
            if (context instanceof Service) {
                ((Service) context).startForeground(1100, this.f12323a.build());
            } else {
                this.f12320a.notify(1100, this.f12323a.build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(Context ctx) {
        if (ctx == null) {
            return;
        }
        if (this.f12320a == null) {
            this.f12320a = (NotificationManager) ctx.getApplicationContext().getSystemService("notification");
        }
        try {
            this.f12320a.cancelAll();
        } catch (Exception unused) {
        }
    }

    public final void e(Context context) {
        Intent intent = new Intent(context, (Class<?>) SunshineRunActivity.class);
        intent.setFlags(603979776);
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, "sunshine_run_channel").setContentIntent(PendingIntent.getActivity(context, 0, intent, 134217728)).setWhen(System.currentTimeMillis()).setContentTitle("闪动校园正在记录你的运动").setContentText("点击展开运动详情");
        int i = R.drawable.run_sun_noti_logo;
        this.f12323a = contentText.setSmallIcon(i).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), i)).setVisibility(1).setAutoCancel(false).setOnlyAlertOnce(true).setOngoing(true);
    }

    @RequiresApi(api = 26)
    public final void f() {
        NotificationChannel notificationChannel = new NotificationChannel("sunshine_run_channel", "跑步服务", 4);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setSound(null, null);
        this.f12320a.createNotificationChannel(notificationChannel);
    }

    public final void g(Context context) {
        if (this.f12323a == null) {
            return;
        }
        this.f12322a = new RemoteViews(context.getPackageName(), R.layout.run_layout_sunshine_run_notification_large);
        try {
            this.f12322a.setOnClickPendingIntent(R.id.iv_start, PendingIntent.getBroadcast(context, 0, new Intent("start"), 0));
            this.f12322a.setOnClickPendingIntent(R.id.iv_silence, PendingIntent.getBroadcast(context, 0, new Intent(h), 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f12322a.setImageViewBitmap(R.id.iv_start, this.f12327a ? this.f12321a : this.f12328b);
        RemoteViews remoteViews = this.f12322a;
        int i = R.id.tv_pause_time;
        remoteViews.setViewVisibility(i, this.f12327a ? 0 : 8);
        this.f12322a.setImageViewBitmap(R.id.iv_silence, this.f12330b ? this.f12331c : this.d);
        this.f12322a.setTextViewText(R.id.tv_time, this.f12332c);
        this.f12322a.setTextViewText(R.id.tv_pace, this.e);
        this.f12322a.setTextViewText(i, this.f12333d);
        this.f12322a.setTextViewText(R.id.tv_distance, this.f);
        this.f12322a.setProgressBar(R.id.progress, this.c, this.b, false);
        NotificationCompat.Builder builder = this.f12323a;
        if (builder != null) {
            builder.setCustomBigContentView(this.f12322a);
        }
    }

    public void h(long pace) {
        if (this.f12322a == null) {
            return;
        }
        String strE = "-/-";
        if (pace != 0 && pace <= 3600) {
            strE = s72.e(pace);
        }
        this.e = "配速 " + strE;
        r();
    }

    public void i(Context context, long pauseTime) {
        if (this.f12322a == null) {
            return;
        }
        this.f12333d = s72.e(pauseTime / 1000) + "后结束";
        g(context);
        r();
    }

    public void j(int distance, int targetDistance) {
        if (this.f12322a == null) {
            return;
        }
        String strB = c82.b(distance < 10 ? 0.001d : BigDecimal.valueOf(distance).divide(BigDecimal.valueOf(1000L), 3, 5).doubleValue(), 3);
        String string = BigDecimal.valueOf(targetDistance).divide(BigDecimal.valueOf(1000L), 2, 4).toString();
        this.b = distance;
        this.c = targetDistance;
        this.f = strB + "km/" + string + "km";
        r();
    }

    public void k(boolean isPause) {
        Bitmap bitmap;
        this.f12327a = isPause;
        RemoteViews remoteViews = this.f12322a;
        if (remoteViews == null || (bitmap = this.f12321a) == null) {
            return;
        }
        int i = R.id.iv_start;
        if (!isPause) {
            bitmap = this.f12328b;
        }
        remoteViews.setImageViewBitmap(i, bitmap);
        this.f12322a.setViewVisibility(R.id.tv_pause_time, isPause ? 0 : 8);
        r();
    }

    public void l(Context context, long time) {
        if (this.f12322a == null) {
            return;
        }
        this.f12332c = "时长 " + DateUtils.formatElapsedTime(time / 1000);
        g(context);
        r();
    }

    public void m(boolean isSilence) {
        Bitmap bitmap;
        this.f12330b = isSilence;
        RemoteViews remoteViews = this.f12322a;
        if (remoteViews == null || (bitmap = this.f12331c) == null) {
            return;
        }
        int i = R.id.iv_silence;
        if (!isSilence) {
            bitmap = this.d;
        }
        remoteViews.setImageViewBitmap(i, bitmap);
        r();
    }

    public final void n(Context context) {
        this.f12324a = new MusicReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("start");
        intentFilter.addAction(h);
        context.registerReceiver(this.f12324a, intentFilter);
    }

    public void o(NotificationCallback callback) {
        this.f12325a = callback;
    }

    public final void p() {
        this.f12327a = true;
        this.f12330b = false;
        this.f12332c = "时长 00:00";
        this.f12333d = "时长 00:00";
        this.e = "配速 -/-";
        this.f = "0km/0km";
        this.b = 0;
        this.c = 0;
    }

    public void q() {
        this.f12325a = null;
    }

    public void r() {
        NotificationCompat.Builder builder = this.f12323a;
        if (builder == null) {
            return;
        }
        try {
            this.f12320a.notify(1100, builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

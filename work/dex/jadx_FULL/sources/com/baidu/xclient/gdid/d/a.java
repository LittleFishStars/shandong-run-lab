package com.baidu.xclient.gdid.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.baidu.xclient.gdid.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f26827a = 60000;
    public static long b = 3600000;
    public static long c = 86400000;

    public static void a(Context context, long j) {
        if (j <= 0) {
            return;
        }
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(b.f26828a);
            intent.setPackage(d.a().a(context));
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 100, intent, 201326592);
            alarmManager.cancel(broadcast);
            alarmManager.set(1, System.currentTimeMillis() + j, broadcast);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }
}

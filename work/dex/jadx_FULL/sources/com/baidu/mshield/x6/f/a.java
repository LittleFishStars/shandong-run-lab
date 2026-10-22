package com.baidu.mshield.x6.f;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {
    public static void a(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.mshield.x6.alarm.work.finger");
            intent.setPackage(context.getPackageName());
            alarmManager.cancel(PendingIntent.getBroadcast(context, 100, intent, 201326592));
            Intent intent2 = new Intent("com.baidu.mshield.x6.alarm.work.zid");
            intent2.setPackage(context.getPackageName());
            alarmManager.cancel(PendingIntent.getBroadcast(context, 101, intent2, 201326592));
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
    }

    public static void b(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.mshield.x6.alarm.work.finger");
            intent.setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 100, intent, 201326592);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
                f.b(th);
            }
            int iB = new com.baidu.mshield.x6.b.b(context).b();
            com.baidu.mshield.b.c.a.b("finger alarm interval=" + iB + " Min");
            alarmManager.set(1, System.currentTimeMillis() + (((long) iB) * 60000), broadcast);
        } catch (Throwable th2) {
            f.b(th2);
        }
    }

    public static void c(Context context) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.mshield.x6.alarm.work.zid");
            intent.setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, intent, 201326592);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
                f.b(th);
            }
            com.baidu.mshield.b.c.a.b("zid alarm interval=" + com.baidu.mshield.x6.e.a.a(context) + " HOUR");
            alarmManager.set(1, System.currentTimeMillis() + (((long) com.baidu.mshield.x6.e.a.a(context)) * 3600000), broadcast);
        } catch (Throwable th2) {
            f.b(th2);
        }
    }
}

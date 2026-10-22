package com.blankj.utilcode.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioAttributes;
import android.net.Uri;
import androidx.annotation.RequiresPermission;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NotificationUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28165a = -1000;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Importance {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f28166a = new a(Utils.a().getPackageName(), Utils.a().getPackageName(), 3);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public NotificationChannel f1324a;

        public a(String str, CharSequence charSequence, int i) {
            this.f1324a = new NotificationChannel(str, charSequence, i);
        }

        public NotificationChannel b() {
            return this.f1324a;
        }

        public a c(boolean z) {
            this.f1324a.setBypassDnd(z);
            return this;
        }

        public a d(String str) {
            this.f1324a.setDescription(str);
            return this;
        }

        public a e(String str) {
            this.f1324a.setGroup(str);
            return this;
        }

        public a f(int i) {
            this.f1324a.setImportance(i);
            return this;
        }

        public a g(int i) {
            this.f1324a.setLightColor(i);
            return this;
        }

        public a h(int i) {
            this.f1324a.setLockscreenVisibility(i);
            return this;
        }

        public a i(CharSequence charSequence) {
            this.f1324a.setName(charSequence);
            return this;
        }

        public a j(boolean z) {
            this.f1324a.setShowBadge(z);
            return this;
        }

        public a k(Uri uri, AudioAttributes audioAttributes) {
            this.f1324a.setSound(uri, audioAttributes);
            return this;
        }

        public a l(long[] jArr) {
            this.f1324a.setVibrationPattern(jArr);
            return this;
        }
    }

    public static boolean a() {
        return NotificationManagerCompat.from(Utils.a()).areNotificationsEnabled();
    }

    public static void b(int i) {
        NotificationManagerCompat.from(Utils.a()).cancel(i);
    }

    public static void c(String str, int i) {
        NotificationManagerCompat.from(Utils.a()).cancel(str, i);
    }

    public static void d() {
        NotificationManagerCompat.from(Utils.a()).cancelAll();
    }

    public static Notification e(a aVar, Utils.Consumer<NotificationCompat.Builder> consumer) {
        ((NotificationManager) Utils.a().getSystemService("notification")).createNotificationChannel(aVar.b());
        NotificationCompat.Builder builder = new NotificationCompat.Builder(Utils.a());
        builder.setChannelId(aVar.f1324a.getId());
        if (consumer != null) {
            consumer.accept(builder);
        }
        return builder.build();
    }

    public static void f(String str) {
        try {
            Class.forName("android.app.StatusBarManager").getMethod(str, new Class[0]).invoke(Utils.a().getSystemService("statusbar"), new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void g(int i, a aVar, Utils.Consumer<NotificationCompat.Builder> consumer) {
        i(null, i, aVar, consumer);
    }

    public static void h(int i, Utils.Consumer<NotificationCompat.Builder> consumer) {
        i(null, i, a.f28166a, consumer);
    }

    public static void i(String str, int i, a aVar, Utils.Consumer<NotificationCompat.Builder> consumer) {
        NotificationManagerCompat.from(Utils.a()).notify(str, i, e(aVar, consumer));
    }

    public static void j(String str, int i, Utils.Consumer<NotificationCompat.Builder> consumer) {
        i(str, i, a.f28166a, consumer);
    }

    @RequiresPermission("android.permission.EXPAND_STATUS_BAR")
    public static void k(boolean z) {
        f(z ? "expandNotificationsPanel" : "collapsePanels");
    }
}

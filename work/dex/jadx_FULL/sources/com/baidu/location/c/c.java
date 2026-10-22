package com.baidu.location.c;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import com.baidu.location.b.q;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f26420a = null;
    public Location b = null;
    public Location c = null;
    public long d = 0;
    public long e = 0;
    private Timer f = null;
    private TimerTask g = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f26422a = new c();
    }

    public class b implements q.c {
        private b() {
        }

        @Override // com.baidu.location.b.q.c
        public void a(Location location) {
            if (location == null) {
                return;
            }
            c cVar = c.this;
            cVar.b = location;
            cVar.e = System.currentTimeMillis();
        }
    }

    public static c a() {
        return a.f26422a;
    }

    private synchronized void d() {
        TimerTask timerTask = this.g;
        if (timerTask != null) {
            timerTask.cancel();
            this.g = null;
        }
        Timer timer = this.f;
        if (timer != null) {
            timer.cancel();
            this.f.purge();
            this.f = null;
        }
    }

    public void a(Context context) {
        if (Build.VERSION.SDK_INT >= 31 && com.baidu.location.e.h.aF != 0) {
            if (!com.baidu.location.e.h.h(context)) {
                b();
                return;
            }
            d();
            if (this.f == null && this.g == null) {
                this.f = new Timer();
                TimerTask timerTask = new TimerTask() { // from class: com.baidu.location.c.c.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        c.this.b();
                    }
                };
                this.g = timerTask;
                this.f.schedule(timerTask, 60000L);
            }
            if (this.f26420a == null) {
                this.f26420a = new b();
                q.a().a(this.f26420a, context, Looper.myLooper());
            }
        }
    }

    public void a(Location location) {
        this.c = location;
        this.d = System.currentTimeMillis();
    }

    public boolean a(Location location, Location location2) {
        if (location2 == null) {
            return false;
        }
        if (location == null) {
            return true;
        }
        try {
            float[] fArr = new float[2];
            Location.distanceBetween(location.getLatitude(), location.getLongitude(), location2.getLatitude(), location2.getLongitude(), fArr);
            return fArr[0] >= 100.0f;
        } catch (Exception unused) {
        }
    }

    public String b(Location location) {
        if (location != null) {
            return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d&ll_r=%d", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf((float) (((double) location.getSpeed()) * 3.6d)), Float.valueOf(location.getBearing()), 0, Long.valueOf(location.getTime() / 1000), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)));
        }
        return null;
    }

    public synchronized void b() {
        if (this.f26420a != null) {
            q.a().a(this.f26420a);
            this.f26420a = null;
        }
        d();
    }

    public void b(Context context) {
        if (Build.VERSION.SDK_INT >= 31 && com.baidu.location.b.a.a().q != 0 && com.baidu.location.e.h.h(context)) {
            if (this.f26420a == null) {
                this.f26420a = new b();
            }
            q.a().a(this.f26420a, context, Looper.getMainLooper());
        }
    }

    public Location c() {
        return System.currentTimeMillis() - this.d < 30000 ? this.c : System.currentTimeMillis() - this.e < 30000 ? this.b : null;
    }
}

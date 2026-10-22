package com.czhj.volley;

import android.os.SystemClock;
import android.util.Log;
import androidx.camera.core.CameraInfo;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class VolleyLog {
    public static boolean DEBUG = false;
    public static String TAG = "Sigmob-Volley";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29474a = "com.czhj.volley.VolleyLog";

    public static class MarkerLog {
        public static final boolean ENABLED = VolleyLog.DEBUG;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final long f29475a = 0;
        private final List<Marker> b = new ArrayList();
        private boolean c = false;

        public static class Marker {
            public final String name;
            public final long thread;
            public final long time;

            public Marker(String str, long j, long j2) {
                this.name = str;
                this.thread = j;
                this.time = j2;
            }
        }

        private long a() {
            if (this.b.size() == 0) {
                return 0L;
            }
            long j = this.b.get(0).time;
            List<Marker> list = this.b;
            return list.get(list.size() - 1).time - j;
        }

        public synchronized void add(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.b.add(new Marker(str, j, SystemClock.elapsedRealtime()));
        }

        public void finalize() {
            if (this.c) {
                return;
            }
            finish("Request on the loose");
            VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void finish(String str) {
            this.c = true;
            long jA = a();
            if (jA <= 0) {
                return;
            }
            long j = this.b.get(0).time;
            VolleyLog.d("(%-4d ms) %s", Long.valueOf(jA), str);
            for (Marker marker : this.b) {
                long j2 = marker.time;
                VolleyLog.d("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(marker.thread), marker.name);
                j = j2;
            }
        }
    }

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClassName().equals(f29474a)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + Consts.DOT + stackTrace[i].getMethodName();
                return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
            }
        }
        str2 = CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN;
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void d(String str, Object... objArr) {
        if (DEBUG) {
            Log.d(TAG, a(str, objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        Log.e(TAG, a(str, objArr));
    }

    public static void e(Throwable th, String str, Object... objArr) {
        Log.e(TAG, a(str, objArr), th);
    }

    public static void setTag(String str) {
        d("Changing log tag to %s", str);
        TAG = str;
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, a(str, objArr));
        }
    }

    public static void wtf(String str, Object... objArr) {
        Log.wtf(TAG, a(str, objArr));
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        Log.wtf(TAG, a(str, objArr), th);
    }
}

package cj.mobile.wm;

import android.os.SystemClock;
import android.util.Log;
import androidx.camera.core.CameraInfo;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ia {
    public static String dexa = "Volley";
    public static boolean dexb = Log.isLoggable("Volley", 2);
    public static final String dexc = ia.class.getName();

    public static class dexa {
        public static final boolean dexc = ia.dexb;
        public final List<C0083dexa> dexa = new ArrayList();
        public boolean dexb = false;

        /* JADX INFO: renamed from: cj.mobile.wm.ia$dexa$dexa, reason: collision with other inner class name */
        public static class C0083dexa {
            public final String dexa;
            public final long dexb;
            public final long dexc;

            public C0083dexa(String str, long j, long j2) {
                this.dexa = str;
                this.dexb = j;
                this.dexc = j2;
            }
        }

        private long dexa() {
            if (this.dexa.size() == 0) {
                return 0L;
            }
            long j = this.dexa.get(0).dexc;
            List<C0083dexa> list = this.dexa;
            return list.get(list.size() - 1).dexc - j;
        }

        public synchronized void dexa(String str) {
            this.dexb = true;
            long jDexa = dexa();
            if (jDexa <= 0) {
                return;
            }
            long j = this.dexa.get(0).dexc;
            ia.dexb("(%-4d ms) %s", Long.valueOf(jDexa), str);
            for (C0083dexa c0083dexa : this.dexa) {
                long j2 = c0083dexa.dexc;
                ia.dexb("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0083dexa.dexb), c0083dexa.dexa);
                j = j2;
            }
        }

        public synchronized void dexa(String str, long j) {
            if (this.dexb) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.dexa.add(new C0083dexa(str, j, SystemClock.elapsedRealtime()));
        }

        public void finalize() {
            if (this.dexb) {
                return;
            }
            dexa("Request on the loose");
            ia.dexc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static String dexa(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClassName().equals(dexc)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + Consts.DOT + stackTrace[i].getMethodName();
                return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
            }
        }
        str2 = CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN;
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void dexa(Throwable th, String str, Object... objArr) {
        Log.e(dexa, dexa(str, objArr), th);
    }

    public static void dexb(String str, Object... objArr) {
        f1.dexa(dexa, dexa(str, objArr));
    }

    public static void dexc(String str, Object... objArr) {
        Log.e(dexa, dexa(str, objArr));
    }

    public static void dexd(String str, Object... objArr) {
        if (dexb) {
            Log.v(dexa, dexa(str, objArr));
        }
    }
}

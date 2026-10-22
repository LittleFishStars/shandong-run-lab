package com.alibaba.ariver.kernel.common.utils;

import android.util.Log;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.kernel.common.RVProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24284a = "RVLogger";
    private static final String b = "Ariver_";
    private static final int c = 7;
    private static final int d = 23;
    private static Proxy e = new Proxy() { // from class: com.alibaba.ariver.kernel.common.utils.RVLogger.1
        @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
        public void d(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
        public void debug(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
        public void e(String str, String str2, Throwable th) {
            Log.e(str, str2, th);
        }

        @Override // com.alibaba.ariver.kernel.common.utils.RVLogger.Proxy
        public void w(String str, String str2, Throwable th) {
            Log.w(str, str2, th);
        }
    };
    private static final String f = "";

    public interface Proxy extends Proxiable {
        void d(String str, String str2);

        void debug(String str, String str2);

        void e(String str, String str2, Throwable th);

        void w(String str, String str2, Throwable th);
    }

    private static Proxy a() {
        Proxy proxy = (Proxy) RVProxy.get(Proxy.class, true);
        return proxy != null ? proxy : e;
    }

    public static void d(String str) {
        try {
            d(f24284a, str);
        } catch (Throwable th) {
            e("RVLogger exception: " + th);
        }
    }

    public static void debug(String str, String str2) {
        if (isEmpty(str2)) {
            return;
        }
        try {
            a().debug(str, str2);
        } catch (Throwable th) {
            e("RVLogger exception: " + th);
        }
    }

    public static void e(String str) {
        try {
            e(f24284a, str, null);
        } catch (Throwable th) {
            e("RVLogger exception: " + th);
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static String makeLogTag(String str) {
        int length = str.length();
        int i = c;
        if (length > 23 - i) {
            return b + str.substring(0, (23 - i) - 1);
        }
        return b + str;
    }

    public static void printPerformanceLog(String str, String str2) {
        Proxy proxy = (Proxy) RVProxy.get(Proxy.class, true);
        if (proxy != null) {
            proxy.e("AriverPerformance", "[Thread:" + Thread.currentThread().getName() + "] [Stage:" + str + "] [Info:" + str2 + "] [TimeStamp:" + System.currentTimeMillis() + "]", null);
            return;
        }
        Log.e("AriverPerformance", "[Thread:" + Thread.currentThread().getName() + "] [Stage:" + str + "] [Info:" + str2 + "] [TimeStamp:" + System.currentTimeMillis() + "]");
    }

    public static void w(String str) {
        try {
            w(f24284a, str);
        } catch (Throwable th) {
            e("RVLogger exception: " + th);
        }
    }

    public static void d(String str, String str2) {
        if (isEmpty(str2)) {
            return;
        }
        try {
            a().d(str, str2);
        } catch (Throwable th) {
            e("RVLogger exception: " + th);
        }
    }

    public static void e(String str, String str2) {
        try {
            e(str, str2, null);
        } catch (Throwable th) {
            e("RVLogger exception: " + th);
        }
    }

    public static void w(String str, String str2) {
        if (isEmpty(str2)) {
            return;
        }
        try {
            a().w(str, str2, null);
        } catch (Throwable th) {
            e("RVLogger exception: " + th);
        }
    }

    public static String makeLogTag(Class cls) {
        return makeLogTag(cls.getSimpleName());
    }

    public static void e(String str, Throwable th) {
        try {
            e(f24284a, str, th);
        } catch (Throwable th2) {
            e("RVLogger exception: " + th2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        try {
            a().w(str, str2, th);
        } catch (Throwable th2) {
            e("RVLogger exception: " + th2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        try {
            a().e(str, str2, th);
        } catch (Throwable th2) {
            e("RVLogger exception: " + th2);
        }
    }
}

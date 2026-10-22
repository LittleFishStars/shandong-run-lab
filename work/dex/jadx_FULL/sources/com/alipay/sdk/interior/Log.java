package com.alipay.sdk.interior;

import android.content.Context;
import android.os.SystemClock;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.w.b;
import com.alipay.sdk.m.y.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Log {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f25380a;

    public interface ISdkLogCallback {
        void onLogLine(String str);
    }

    public static boolean forcedLogReport(Context context) {
        try {
            b.c().a(context);
            long jElapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (jElapsedRealtime - f25380a < 600) {
                return false;
            }
            f25380a = jElapsedRealtime;
            a.a(context);
            return true;
        } catch (Exception e) {
            g.a(e);
            return false;
        }
    }

    public static void setupLogCallback(ISdkLogCallback iSdkLogCallback) {
        g.a(iSdkLogCallback);
    }
}

package com.baidu.sec.privacy.f;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import com.byazt.hv.TTDownloadField;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f26818a = false;
    public static volatile boolean b = false;
    public static long c = 0;
    public static boolean d = false;

    public static void a(Throwable th) {
    }

    public static boolean a(Context context) {
        String[] strArr;
        try {
            if (f26818a) {
                return b;
            }
            if (context == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0 && (strArr = runningAppProcessInfo.pkgList) != null && strArr.length != 0 && Arrays.asList(strArr).contains(context.getPackageName())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static boolean b(Context context) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            if (!e.a(context, new String[]{com.kuaishou.weapon.p0.g.e})) {
                return true;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager.getRunningTasks(1) == null || (runningTaskInfo = activityManager.getRunningTasks(1).get(0)) == null) {
                return false;
            }
            return context.getPackageName().equals(runningTaskInfo.topActivity.getPackageName());
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static boolean c(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static boolean d(Context context) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - c < 1000) {
                return d;
            }
            d = c(context) && a(context);
            c = jCurrentTimeMillis;
            return d;
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void a(boolean z) {
        f26818a = true;
        b = z;
    }
}

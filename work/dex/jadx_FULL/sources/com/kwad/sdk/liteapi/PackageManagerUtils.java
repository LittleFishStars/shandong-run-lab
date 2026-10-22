package com.kwad.sdk.liteapi;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class PackageManagerUtils {
    public static AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static long mLastCallTime;
    private static long packageInfoLimiter;
    private static HashMap<String, PackageInfo> sPackageInfoHashMap;

    public static PackageInfo getPackageInfo(Context context, String str, int i) {
        PackageInfo packageInfo;
        try {
            init(context);
            HashMap<String, PackageInfo> map = sPackageInfoHashMap;
            if (map != null && map.containsKey(str)) {
                return sPackageInfoHashMap.get(str);
            }
            if (shouldCall()) {
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, i);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                HashMap<String, PackageInfo> map2 = sPackageInfoHashMap;
                if (map2 != null) {
                    map2.put(str, packageInfo);
                }
                return packageInfo;
            }
            return null;
        } catch (Throwable th) {
            LiteApiLogger.printStackTraceOnly(th);
        }
    }

    public static PackageInfo getPackageInfoNoCache(Context context, String str, int i) {
        PackageInfo packageInfo;
        try {
            init(context);
            if (shouldCall()) {
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, i);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                HashMap<String, PackageInfo> map = sPackageInfoHashMap;
                if (map != null) {
                    map.put(str, packageInfo);
                }
                return packageInfo;
            }
        } catch (Throwable th) {
            LiteApiLogger.printStackTraceOnly(th);
        }
        return null;
    }

    private static void init(Context context) {
        if (mHasInit.compareAndSet(false, true)) {
            long j = context.getSharedPreferences("ksadsdk_config", 0).getLong("packageInfoLimiter", 0L);
            packageInfoLimiter = j;
            if (j > 0) {
                sPackageInfoHashMap = new HashMap<>();
            }
        }
    }

    private static synchronized boolean shouldCall() {
        if (packageInfoLimiter <= 0) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - mLastCallTime <= packageInfoLimiter) {
            return false;
        }
        mLastCallTime = jCurrentTimeMillis;
        return true;
    }
}

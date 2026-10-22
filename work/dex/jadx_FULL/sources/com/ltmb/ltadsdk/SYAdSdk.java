package com.ltmb.ltadsdk;

import android.app.Application;
import com.ltmb.ltadsdk.api.SYAdInitConfig;
import com.ltmb.ltadsdk.api.SYAdSdkInitCallback;
import com.ltmb.ltadsdk.api.ad.AdError;
import com.ltmb.ltadsdk.api.internal.AdPluginProxy;
import com.ltmb.ltadsdk.api.internal.SYAdManager;
import com.ltmb.ltadsdk.pkg.b1;
import com.ltmb.ltadsdk.pkg.bb;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.f3;
import com.ltmb.ltadsdk.pkg.u6;
import com.ltmb.ltadsdk.pkg.y2;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class SYAdSdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SYAdManager f40288a;

    public static SYAdManager getAdManger() {
        if (f40288a != null) {
            SYAdManager adManager = AdPluginProxy.getAdManager();
            if (adManager != null) {
                f40288a = adManager;
            }
            return f40288a;
        }
        SYAdManager adManager2 = AdPluginProxy.getAdManager();
        if (adManager2 != null) {
            f40288a = adManager2;
        } else {
            f40288a = new bb();
        }
        return f40288a;
    }

    public static int getPluginStatus() {
        boolean z = y2.a;
        try {
            Boolean bool = y2.d;
            if (bool != null) {
                return bool.booleanValue() ? 1 : 2;
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static String getSDKVersion() {
        return "2.4.7.3";
    }

    public static void init(Application application, SYAdInitConfig sYAdInitConfig) {
        try {
            y2.a(application, sYAdInitConfig);
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public static boolean isInited() {
        return y2.a;
    }

    public static boolean isSdkReady() {
        return y2.b.get();
    }

    public static void setEnableShake(boolean z) {
        b1.c = Boolean.valueOf(z);
        f3.a(f3.b, u6.n.a(), "enableShake", Boolean.valueOf(z), (String) null, false, 24);
    }

    public static void setPersonalRecommend(boolean z) {
        b1.b = Boolean.valueOf(z);
        f3.a(f3.b, u6.n.a(), "enablePersonalRecommend", Boolean.valueOf(z), (String) null, false, 24);
    }

    public static void start(SYAdSdkInitCallback sYAdSdkInitCallback) {
        try {
            y2.a(sYAdSdkInitCallback);
        } catch (Throwable th) {
            d9.d.a(th);
            if (sYAdSdkInitCallback != null) {
                try {
                    sYAdSdkInitCallback.onFail(AdError.ERROR_START_FAIL_UNKNOWN.getFirst().intValue(), AdError.ERROR_START_FAIL_UNKNOWN.getSecond());
                } catch (Throwable unused) {
                    d9.d.a(th);
                }
            }
        }
    }
}

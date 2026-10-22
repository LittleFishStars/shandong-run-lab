package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class q {
    private static boolean aGQ;
    private static long aGz;

    public static void He() {
        if (aGQ) {
            return;
        }
        aGQ = true;
        aGz = SystemClock.elapsedRealtime();
    }

    public static void a(Throwable th, String str) {
        try {
            p.a(com.kwai.adclient.kscommerciallogger.model.a.buG, str);
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        } catch (Throwable unused) {
        }
        bi(ServiceProvider.Ud());
        com.kwad.sdk.core.d.c.d("SDKRevertHelper", "onInitError revert");
    }

    private static String b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return str2;
        }
    }

    public static void bh(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - aGz;
        com.kwad.sdk.core.d.c.d("SDKRevertHelper", "onException revert time: " + jElapsedRealtime);
        if (jElapsedRealtime < 10000) {
            bi(context);
        }
    }

    private static void bi(Context context) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString("curversion", "").putBoolean("initFail", true).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public static void bj(Context context) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("initFail", false).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public static boolean bk(Context context) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getBoolean("initFail", false);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    private static SdkConfig bl(Context context) {
        SdkConfig sdkConfigCreate;
        try {
            sdkConfigCreate = SdkConfig.create(b(context, com.getui.gtc.dyc.b.b.f30337a, ""));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            sdkConfigCreate = null;
        }
        return sdkConfigCreate == null ? new SdkConfig.Builder().build() : sdkConfigCreate;
    }

    public static void checkInitSDK(Context context) {
        try {
            if (o.Gs().Fx()) {
                return;
            }
            KsAdSDK.init(context, bl(context));
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    public static void s(Throwable th) {
        a(th, Log.getStackTraceString(th));
    }
}

package com.kc.cw.ad;

import android.content.Context;
import com.kc.cw.ad.d.b.g;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.internal.utilities.IS2SManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SSAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SSAdSdkController f38656a = null;
    private static boolean b = false;

    public static SSAdSdkController getCustomController() {
        return f38656a;
    }

    public static String getOaid(Context context) {
        return g.a(context);
    }

    public static IS2SManager getS2SManger() {
        return q.a();
    }

    public static String getSdkVersion() {
        return "2.6.1.8";
    }

    public static void init(Context context, String str) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        q.a().a(context, str);
    }

    public static void init(Context context, String str, SSAdSdkController sSAdSdkController) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        if (f38656a == null) {
            f38656a = sSAdSdkController;
        }
        q.a().a(context, str);
        q.a().b(str);
    }

    public static void init(Context context, String str, SSAdSdkController sSAdSdkController, String str2) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        if (f38656a == null) {
            f38656a = sSAdSdkController;
        }
        q.a().a(context, str);
        if ("OctopusGroup".equals(str2)) {
            q.a().a(str);
        } else {
            q.a().b(str);
        }
    }

    public static boolean isHttpsEnabled() {
        return q.a().f;
    }

    public static boolean isLimitPersonalAds() {
        return b;
    }

    public static void logTagInfo(String str, boolean z) {
        q.a().a(str, z);
    }

    public static void setAppMuted(boolean z) {
        q.a().a(z);
    }

    public static void setAppVolume(float f) {
        q.a().a(f);
    }

    public static void setCustomController(SSAdSdkController sSAdSdkController) {
        f38656a = sSAdSdkController;
    }

    public static void setIsDownloadDirect(boolean z) {
        q.a().b(z);
    }

    public static void setLimitPersonalAds(boolean z) {
        b = z;
    }

    public static void setTimeout(int i) {
        q.a().b(i);
    }

    public static void useHttps(boolean z) {
        q.a().f = z;
    }
}

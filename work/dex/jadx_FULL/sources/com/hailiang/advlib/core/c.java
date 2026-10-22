package com.hailiang.advlib.core;

import android.content.Context;
import android.widget.LinearLayout;
import com.hailiang.advlib.common.d;
import com.hailiang.advlib.ui.banner.Banner;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class c {
    public static IADBrowser a() {
        return (IADBrowser) com.hailiang.advlib.common.b.c().a(IADBrowser.class, new Object[0]);
    }

    public static _factory a(Context context, QMConfig qMConfig, String str) {
        return (_factory) com.hailiang.advlib.common.b.c().a(_factory.class, context, qMConfig, str);
    }

    public static Banner a(LinearLayout linearLayout) {
        return (Banner) com.hailiang.advlib.common.b.c().a(Banner.class, linearLayout);
    }

    public static void a(IMultiAdObject iMultiAdObject) {
        try {
            d.a(iMultiAdObject).b("closeInteractionAd");
        } catch (Throwable unused) {
        }
    }

    public static void a(boolean z) {
        try {
            d.b((Class<?>) com.hailiang.advlib.common.b.c().b(IMultiAdRequest.class)).a("savePersonalRecommendSwitch", Boolean.valueOf(z));
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Class cls) {
        return com.hailiang.advlib.common.b.c().b(cls) == null;
    }

    public static IMultiAdRequest b() {
        return (IMultiAdRequest) com.hailiang.advlib.common.b.c().a(IMultiAdRequest.class, new Object[0]);
    }

    public static void b(boolean z) {
        try {
            d.b((Class<?>) com.hailiang.advlib.common.b.c().b(IMultiAdRequest.class)).a("saveTwistSwitch", Boolean.valueOf(z));
        } catch (Throwable unused) {
        }
    }

    public static Map<Class, String> c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(_factory.class, "com.hailiang.advlib.__remote__.core.ICliFactory");
        linkedHashMap.put(Banner.class, "com.hailiang.advlib.__remote__.ui.banner._imp_adbanner");
        linkedHashMap.put(IADBrowser.class, "com.hailiang.advlib.__remote__.ui.front._imp_adbrowser");
        linkedHashMap.put(IInciteAd.class, "com.hailiang.advlib.__remote__.ui.front._imp_inciteadactivity");
        linkedHashMap.put(IMultiAdRequest.class, "com.hailiang.advlib.__remote__.core.MultiAdRequest");
        linkedHashMap.put(IMultiAdObject.class, "com.hailiang.advlib.__remote__.core.MultiAdObject");
        linkedHashMap.put(b.class, "com.hailiang.advlib.__remote__.__bootstrap__.LibInit");
        return linkedHashMap;
    }

    public static IInciteAd d() {
        return (IInciteAd) com.hailiang.advlib.common.b.c().a(IInciteAd.class, new Object[0]);
    }

    public static String e() {
        try {
            Field declaredField = com.hailiang.advlib.common.b.c().b(b.class).getDeclaredField("aisdk_lib_version");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            return obj instanceof String ? (String) obj : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}

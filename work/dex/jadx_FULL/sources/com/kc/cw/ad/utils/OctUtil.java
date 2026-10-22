package com.kc.cw.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kc.cw.a.a;
import com.kc.cw.ad.d.b.f;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OctUtil implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static OctUtil f39074a;

    @Keep
    public interface C {
        String e(String str);
    }

    @Keep
    public interface E {
        void e(Throwable th);
    }

    static {
        try {
            System.loadLibrary("shenshi");
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    private OctUtil() {
    }

    public static OctUtil a() {
        if (f39074a == null) {
            f39074a = new OctUtil();
        }
        return f39074a;
    }

    private static void crashCallback(String str) {
        f.c("OctopusAd", "crashCallback: " + str);
        a.a().b();
    }

    public String a(Context context, int i) {
        try {
            return getInfo(context, i);
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
            return "";
        }
    }

    public void a(Context context, String str, String str2, boolean z, C c) {
        String str3;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                startReport(context, str, str2, z, c);
                return;
            } catch (Throwable th) {
                f.a("OctopusAd", "A Throwable Caught", th);
                if (c == null) {
                    return;
                }
                str3 = "-2," + th;
            }
        } else if (c == null) {
            return;
        } else {
            str3 = "-1";
        }
        c.e(str3);
    }

    public native void call(C c, int i);

    public native int changeConfig();

    public native void error(E e);

    public native String getBootMark();

    public native String getInfo(Context context, int i);

    public native String getUpdateMark();

    public native void init(Context context);

    @Override // java.lang.reflect.InvocationHandler
    public native Object invoke(Object obj, Method method, Object[] objArr);

    public native void resumeConfig();

    public native void setInfo(String str);

    public native void startReport(Context context, String str, String str2, boolean z, C c);
}

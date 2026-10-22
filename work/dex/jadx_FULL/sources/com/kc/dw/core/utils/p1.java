package com.kc.dw.core.utils;

import android.content.Context;
import com.acse.ottn.p3;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f39395a;

    public static Boolean a(Context context) {
        try {
            try {
                Boolean bool = f39395a;
                if (bool != null) {
                    return bool;
                }
                Class<?> cls = Class.forName("android.os.SystemProperties");
                f39395a = Boolean.valueOf(((String) cls.getMethod(p3.f, String.class).invoke(cls, "ro.build.characteristics")).contains("tablet"));
                return f39395a;
            } catch (Throwable unused) {
                return Boolean.valueOf((context.getResources().getConfiguration().screenLayout & 15) >= 3);
            }
        } catch (Throwable unused2) {
        }
        return f39395a;
    }
}

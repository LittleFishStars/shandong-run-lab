package com.ipd.dsp.internal.c2;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f38231a;

    public static boolean a() {
        if (f38231a == null) {
            try {
                Class.forName("com.tencent.smtt.sdk.WebView", false, q.class.getClassLoader());
                f38231a = Boolean.TRUE;
            } catch (Throwable unused) {
                f38231a = Boolean.FALSE;
            }
        }
        return f38231a.booleanValue();
    }

    public static Object b() {
        if (!a()) {
            return "";
        }
        try {
            return String.valueOf(QbSdk.getTbsSdkVersion());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context) {
        if (!a()) {
            return "";
        }
        if (context == null) {
            try {
                context = com.ipd.dsp.internal.l1.a.a().getContext();
            } catch (Throwable unused) {
                return "";
            }
        }
        return context != null ? String.valueOf(QbSdk.getTbsVersion(context)) : "";
    }
}

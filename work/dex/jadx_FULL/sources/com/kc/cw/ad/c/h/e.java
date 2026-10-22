package com.kc.cw.ad.c.h;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e {
    public static void a(Context context) {
        b.b = a.C0978a.f38748a.a(context.getApplicationContext());
        b.f38749a = true;
    }

    public static boolean a() {
        if (b.f38749a) {
            return b.b;
        }
        throw new RuntimeException();
    }

    public static String b(Context context) {
        if (b.f38749a) {
            return a.C0978a.f38748a.b(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}

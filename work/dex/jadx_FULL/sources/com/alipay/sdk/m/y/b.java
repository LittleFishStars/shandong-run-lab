package com.alipay.sdk.m.y;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    public static int a(Context context) {
        try {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier(com.gyf.immersionbar.b.f6803b, "dimen", "android"));
        } catch (Throwable th) {
            g.a(th);
            return 0;
        }
    }

    public static int b(Context context) {
        try {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier(com.gyf.immersionbar.b.f6802a, "dimen", "android"));
        } catch (Throwable th) {
            g.a(th);
            return 0;
        }
    }

    public static int c(Context context) {
        return context.getApplicationContext().getApplicationInfo().targetSdkVersion;
    }

    public static boolean d(Context context) {
        return c(context) >= 35 && Build.VERSION.SDK_INT >= 35;
    }
}

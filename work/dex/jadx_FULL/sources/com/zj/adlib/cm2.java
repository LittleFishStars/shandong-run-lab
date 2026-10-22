package com.zj.adlib;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.b;
import com.huachenjie.base.util.rich_text.RichTextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public final class cm2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static Boolean f40997a;

    @Nullable
    public static Boolean b;

    @Nullable
    public static Boolean c;

    @Nullable
    public static Boolean d;

    @Nullable
    public static Boolean e;

    @Nullable
    public static Boolean f;

    @Nullable
    public static Boolean g;

    @Nullable
    public static Boolean h;

    @Nullable
    public static Boolean i;

    @Nullable
    public static Boolean j;

    @Nullable
    public static Boolean k;

    @Nullable
    public static Boolean l;

    @KeepForSdk
    public static boolean a(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (i == null) {
            boolean z = false;
            if (is6.n() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z = true;
            }
            i = Boolean.valueOf(z);
        }
        return i.booleanValue();
    }

    @KeepForSdk
    public static boolean b(@NonNull Context context) {
        if (l == null) {
            boolean z = false;
            if (is6.q() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z = true;
            }
            l = Boolean.valueOf(z);
        }
        return l.booleanValue();
    }

    @KeepForSdk
    public static boolean c(@NonNull Context context) {
        if (f == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z = true;
            }
            f = Boolean.valueOf(z);
        }
        return f.booleanValue();
    }

    @KeepForSdk
    public static boolean d(@NonNull Context context) {
        if (f40997a == null) {
            boolean z = false;
            if (!g(context) && !k(context) && !n(context)) {
                if (h == null) {
                    h = Boolean.valueOf(context.getPackageManager().hasSystemFeature("org.chromium.arc"));
                }
                if (!h.booleanValue() && !a(context) && !i(context)) {
                    if (k == null) {
                        k = Boolean.valueOf(context.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE"));
                    }
                    if (!k.booleanValue() && !b(context)) {
                        z = true;
                    }
                }
            }
            f40997a = Boolean.valueOf(z);
        }
        return f40997a.booleanValue();
    }

    @KeepForSdk
    public static boolean e(@NonNull Context context) {
        return o(context.getResources());
    }

    @KeepForSdk
    @TargetApi(21)
    public static boolean f(@NonNull Context context) {
        return m(context);
    }

    @KeepForSdk
    public static boolean g(@NonNull Context context) {
        return h(context.getResources());
    }

    @KeepForSdk
    public static boolean h(@NonNull Resources resources) {
        if (resources == null) {
            return false;
        }
        if (b == null) {
            b = Boolean.valueOf((resources.getConfiguration().screenLayout & 15) > 3 || o(resources));
        }
        return b.booleanValue();
    }

    @KeepForSdk
    public static boolean i(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (j == null) {
            boolean z = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback")) {
                z = false;
            }
            j = Boolean.valueOf(z);
        }
        return j.booleanValue();
    }

    @KeepForSdk
    public static boolean j() {
        int i2 = b.f31268a;
        return RichTextUtils.USER_SCHEME.equals(Build.TYPE);
    }

    @KeepForSdk
    @TargetApi(20)
    public static boolean k(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (d == null) {
            boolean z = false;
            if (is6.i() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z = true;
            }
            d = Boolean.valueOf(z);
        }
        return d.booleanValue();
    }

    @KeepForSdk
    @TargetApi(26)
    public static boolean l(@NonNull Context context) {
        if (k(context) && !is6.m()) {
            return true;
        }
        if (m(context)) {
            return !is6.n() || is6.q();
        }
        return false;
    }

    @TargetApi(21)
    public static boolean m(@NonNull Context context) {
        if (e == null) {
            boolean z = false;
            if (is6.j() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z = true;
            }
            e = Boolean.valueOf(z);
        }
        return e.booleanValue();
    }

    public static boolean n(@NonNull Context context) {
        if (g == null) {
            boolean z = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z = false;
            }
            g = Boolean.valueOf(z);
        }
        return g.booleanValue();
    }

    public static boolean o(@NonNull Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (c == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z = true;
            }
            c = Boolean.valueOf(z);
        }
        return c.booleanValue();
    }
}

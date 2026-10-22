package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class z {
    public static final String e = "HardwareConfig";
    public static final boolean f;

    @ChecksSdkIntAtLeast(api = 28)
    public static final boolean g;
    public static final File h;
    public static final int i = 50;
    public static final int j = 20000;
    public static final int k = 500;

    @Deprecated
    public static final int l = -1;
    public static volatile z m;

    @GuardedBy("this")
    public int b;

    @GuardedBy("this")
    public boolean c = true;
    public final AtomicBoolean d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38520a = 20000;

    static {
        int i2 = Build.VERSION.SDK_INT;
        f = i2 < 29;
        g = i2 >= 28;
        h = new File("/proc/self/fd");
    }

    @VisibleForTesting
    public z() {
    }

    public static z c() {
        if (m == null) {
            synchronized (z.class) {
                if (m == null) {
                    m = new z();
                }
            }
        }
        return m;
    }

    public static boolean f() {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i2, int i3, boolean z, boolean z2) {
        if (!z) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(e, "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!g) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(e, "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (a()) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(e, "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z2) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(e, "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        if (i2 < 0 || i3 < 0) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(e, "Hardware config disallowed because of invalid dimensions");
            }
            return false;
        }
        if (e()) {
            return true;
        }
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.e(e, "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }

    public void b() {
        com.ipd.dsp.internal.d0.o.b();
        this.d.set(false);
    }

    public final int d() {
        if (f()) {
            return 500;
        }
        return this.f38520a;
    }

    public final synchronized boolean e() {
        boolean z = true;
        int i2 = this.b + 1;
        this.b = i2;
        if (i2 >= 50) {
            this.b = 0;
            String[] list = h.list();
            Objects.requireNonNull(list);
            int length = list.length;
            long jD = d();
            if (length >= jD) {
                z = false;
            }
            this.c = z;
            if (!z && Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.f(r.f, "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jD);
            }
        }
        return this.c;
    }

    public void g() {
        com.ipd.dsp.internal.d0.o.b();
        this.d.set(true);
    }

    public final boolean a() {
        return f && !this.d.get();
    }

    @RequiresApi(26)
    public boolean a(int i2, int i3, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean zA = a(i2, i3, z, z2);
        if (zA) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zA;
    }
}

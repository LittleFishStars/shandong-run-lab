package com.byazt.uk;

import android.os.Build;
import com.byakv.f.FlippedV2Impl;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 87, 13})
public class tt {
    public static final AtomicBoolean c = new AtomicBoolean(false);

    public static void c() {
        AtomicBoolean atomicBoolean = c;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (tt.class) {
            if (atomicBoolean.compareAndSet(false, true)) {
                tt().invokeHiddenApiRestrictions();
            }
        }
    }

    private static com.byazt.fus.ve tt() {
        if (ve()) {
            return new FlippedV2Impl();
        }
        return uj() ? new com.byazt.fus.tt() : new com.byazt.fus.c();
    }

    private static boolean uj() {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            return i == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    private static boolean ve() {
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            return i == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}

package com.zj.adlib;

import android.os.Trace;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class y99 {
    public static void a(String str) {
        if (gj9.f41922a >= 18) {
            b(str);
        }
    }

    @RequiresApi(18)
    public static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (gj9.f41922a >= 18) {
            d();
        }
    }

    @RequiresApi(18)
    public static void d() {
        Trace.endSection();
    }
}

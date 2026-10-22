package com.ipd.dsp.internal.v0;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f38562a;
    public static com.ipd.dsp.internal.x0.b b;
    public static com.ipd.dsp.internal.w0.a c;

    public static void a(Context context) {
        f38562a = new File(context.getCacheDir(), "ipd_cache");
        b = new com.ipd.dsp.internal.x0.a();
        c = new com.ipd.dsp.internal.w0.g(134217728L);
    }

    public static com.ipd.dsp.internal.w0.a b() {
        return c;
    }

    public static com.ipd.dsp.internal.x0.b c() {
        return b;
    }

    public static File a() {
        return f38562a;
    }
}

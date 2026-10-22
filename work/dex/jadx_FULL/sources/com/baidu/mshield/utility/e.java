package com.baidu.mshield.utility;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f26725a = new e();
    public HandlerThread b = new HandlerThread("rp_th", 10);
    public Handler c;

    public e() {
        b();
        this.c = new Handler(this.b.getLooper());
    }

    public static Looper a() {
        return f26725a.c.getLooper();
    }

    public final void b() {
        this.b.start();
    }
}

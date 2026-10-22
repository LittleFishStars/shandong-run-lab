package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h7c extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Looper f42069a;

    public h7c() {
        this.f42069a = Looper.getMainLooper();
    }

    public h7c(Looper looper) {
        super(looper);
        this.f42069a = Looper.getMainLooper();
    }
}

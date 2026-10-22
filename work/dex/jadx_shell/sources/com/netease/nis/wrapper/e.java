package com.netease.nis.wrapper;

import android.widget.Toast;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f6a;

    e(String str) {
        this.f6a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = MyApplication.TAG;
        Toast.makeText(MyApplication.getAppCtx(), this.f6a, 0).show();
    }
}

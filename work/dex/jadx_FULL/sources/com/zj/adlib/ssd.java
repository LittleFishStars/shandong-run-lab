package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ssd implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f44769a = new l6c(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(@NonNull Runnable runnable) {
        this.f44769a.post(runnable);
    }
}

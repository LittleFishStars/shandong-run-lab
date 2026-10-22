package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class jy3 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f42702a;

    @KeepForSdk
    public jy3(@NonNull Looper looper) {
        this.f42702a = new ozc(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(@NonNull Runnable runnable) {
        this.f42702a.post(runnable);
    }
}

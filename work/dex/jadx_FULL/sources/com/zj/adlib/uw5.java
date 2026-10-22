package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class uw5 implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f45240a = Executors.defaultThreadFactory();
    public final String f;

    @KeepForSdk
    public uw5(@NonNull String str) {
        yw6.m(str, "Name must not be null");
        this.f = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @NonNull
    public final Thread newThread(@NonNull Runnable runnable) {
        Thread threadNewThread = this.f45240a.newThread(new f7c(runnable, 0));
        threadNewThread.setName(this.f);
        return threadNewThread;
    }
}

package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class o46 implements ThreadFactory {
    public final String f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicInteger f18560a = new AtomicInteger();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f43666a = Executors.defaultThreadFactory();

    @KeepForSdk
    public o46(@NonNull String str) {
        yw6.m(str, "Name must not be null");
        this.f = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @NonNull
    public final Thread newThread(@NonNull Runnable runnable) {
        Thread threadNewThread = this.f43666a.newThread(new f7c(runnable, 0));
        threadNewThread.setName(this.f + "[" + this.f18560a.getAndIncrement() + "]");
        return threadNewThread;
    }
}

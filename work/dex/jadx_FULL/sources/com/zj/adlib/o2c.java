package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o2c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RegisterListenerMethod f43653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final UnregisterListenerMethod f18544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f18545a;

    public o2c(@NonNull RegisterListenerMethod registerListenerMethod, @NonNull UnregisterListenerMethod unregisterListenerMethod, @NonNull Runnable runnable) {
        this.f43653a = registerListenerMethod;
        this.f18544a = unregisterListenerMethod;
        this.f18545a = runnable;
    }
}

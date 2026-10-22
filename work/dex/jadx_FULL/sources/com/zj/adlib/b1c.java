package com.zj.adlib;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.internal.ActivityLifecycleObserver;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b1c extends ActivityLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f40658a;

    @VisibleForTesting(otherwise = 2)
    public b1c(e0c e0cVar) {
        this.f40658a = new WeakReference(e0cVar);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    @CanIgnoreReturnValue
    public final ActivityLifecycleObserver b(Runnable runnable) {
        e0c e0cVar = (e0c) this.f40658a.get();
        if (e0cVar == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        e0cVar.m(runnable);
        return this;
    }
}

package com.zj.adlib;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class lz9 implements SynchronizationGuard.CriticalSection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mz9 f43189a;

    public lz9(mz9 mz9Var) {
        this.f43189a = mz9Var;
    }

    public static SynchronizationGuard.CriticalSection b(mz9 mz9Var) {
        return new lz9(mz9Var);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object a() {
        return mz9.b(this.f43189a);
    }
}

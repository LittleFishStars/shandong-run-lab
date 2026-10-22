package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final /* synthetic */ class ComponentRuntime$$Lambda$4 implements Runnable {
    private final LazySet arg$1;
    private final Provider arg$2;

    private ComponentRuntime$$Lambda$4(LazySet lazySet, Provider provider) {
        this.arg$1 = lazySet;
        this.arg$2 = provider;
    }

    public static Runnable lambdaFactory$(LazySet lazySet, Provider provider) {
        return new ComponentRuntime$$Lambda$4(lazySet, provider);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.arg$1.add(this.arg$2);
    }
}

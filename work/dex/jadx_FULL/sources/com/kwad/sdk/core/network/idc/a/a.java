package com.kwad.sdk.core.network.idc.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private final long aUr;
    private volatile boolean aUs = false;

    public a(long j, boolean z) {
        this.aUr = j;
    }

    public final boolean Ms() {
        return this.aUs;
    }

    public final long Mt() {
        return this.aUr;
    }

    public final a bF(boolean z) {
        this.aUs = true;
        return this;
    }
}

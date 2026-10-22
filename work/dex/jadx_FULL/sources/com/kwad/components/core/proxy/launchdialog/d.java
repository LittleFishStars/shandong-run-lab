package com.kwad.components.core.proxy.launchdialog;

import androidx.p002lifecycle.Lifecycle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    private final Lifecycle.Event ajg;
    private final long ajh = System.currentTimeMillis();

    public d(Lifecycle.Event event) {
        this.ajg = event;
    }

    public final String toString() {
        return "LifecycleStamp{mEvent=" + this.ajg + ", mEventTimestamp=" + this.ajh + '}';
    }

    public final Lifecycle.Event vH() {
        return this.ajg;
    }

    public final long vI() {
        return this.ajh;
    }
}

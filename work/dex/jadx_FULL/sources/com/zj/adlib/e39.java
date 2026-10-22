package com.zj.adlib;

import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class e39 implements Clock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f41338a;

    public e39(long j) {
        this.f41338a = new AtomicLong(j);
    }

    public void a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("cannot advance time backwards.");
        }
        this.f41338a.addAndGet(j);
    }

    public void b() {
        a(1L);
    }

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return this.f41338a.get();
    }
}

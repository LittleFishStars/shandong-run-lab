package com.huawei.hms.framework.network.grs.g.j;

import android.os.SystemClock;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Future<com.huawei.hms.framework.network.grs.g.d> f37532a;
    private final long b = SystemClock.elapsedRealtime();

    public b(Future<com.huawei.hms.framework.network.grs.g.d> future) {
        this.f37532a = future;
    }

    public Future<com.huawei.hms.framework.network.grs.g.d> a() {
        return this.f37532a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.b <= 300000;
    }
}

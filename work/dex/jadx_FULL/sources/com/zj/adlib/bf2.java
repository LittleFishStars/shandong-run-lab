package com.zj.adlib;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class bf2 implements Clock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bf2 f40737a = new bf2();

    @NonNull
    @KeepForSdk
    public static Clock b() {
        return f40737a;
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long a() {
        return SystemClock.currentThreadTimeMillis();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long nanoTime() {
        return System.nanoTime();
    }
}

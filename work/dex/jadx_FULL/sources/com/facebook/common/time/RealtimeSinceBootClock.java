package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@DoNotStrip
public class RealtimeSinceBootClock implements MonotonicClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RealtimeSinceBootClock f29958a = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @DoNotStrip
    public static RealtimeSinceBootClock get() {
        return f29958a;
    }

    @Override // com.facebook.common.time.MonotonicClock
    public long now() {
        return SystemClock.elapsedRealtime();
    }
}

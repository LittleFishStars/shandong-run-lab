package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ty8 implements Clock {
    @Override // com.google.android.exoplayer2.util.Clock
    public HandlerWrapper a(Looper looper, @Nullable Handler.Callback callback) {
        return new b(new Handler(looper, callback));
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public void onThreadBlocked() {
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long uptimeMillis() {
        return SystemClock.uptimeMillis();
    }
}

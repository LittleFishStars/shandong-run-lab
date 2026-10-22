package com.zj.adlib;

import android.os.SystemClock;
import com.facebook.common.time.Clock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class yy1 implements Clock {
    @Override // com.facebook.common.time.Clock
    public long now() {
        return SystemClock.currentThreadTimeMillis();
    }
}

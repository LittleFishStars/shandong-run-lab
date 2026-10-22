package com.ipd.dsp.internal.f;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e extends IOException {
    public static final long g = 1;
    public static final int h = -1;
    public final int f;

    public e(int i) {
        this("Http request failed", i);
    }

    public int a() {
        return this.f;
    }

    @Deprecated
    public e(String str) {
        this(str, -1);
    }

    public e(String str, int i) {
        this(str, i, null);
    }

    public e(String str, int i, @Nullable Throwable th) {
        super(str + ", status code: " + i, th);
        this.f = i;
    }
}

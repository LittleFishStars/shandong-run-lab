package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class m<T> {
    protected boolean boG = false;
    protected boolean enable;

    public m(boolean z) {
        this.enable = z;
    }

    @Nullable
    public final T cX(Context context) {
        if (!this.enable || this.boG) {
            return null;
        }
        try {
            return cY(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    @Nullable
    public abstract T cY(Context context);

    public final void cs(boolean z) {
        this.enable = z;
    }
}

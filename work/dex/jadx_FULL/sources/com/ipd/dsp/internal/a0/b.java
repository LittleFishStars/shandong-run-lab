package com.ipd.dsp.internal.a0;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Deprecated
public abstract class b<Z> implements p<Z> {
    public com.ipd.dsp.internal.z.e f;

    @Override // com.ipd.dsp.internal.a0.p
    @Nullable
    public com.ipd.dsp.internal.z.e getRequest() {
        return this.f;
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onDestroy() {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void onLoadFailed(@Nullable Drawable drawable) {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onStart() {
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onStop() {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void setRequest(@Nullable com.ipd.dsp.internal.z.e eVar) {
        this.f = eVar;
    }
}

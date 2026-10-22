package com.ipd.dsp.internal.a0;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class e<T> implements p<T> {
    public final int f;
    public final int g;

    @Nullable
    public com.ipd.dsp.internal.z.e h;

    public e() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.ipd.dsp.internal.a0.p
    @Nullable
    public final com.ipd.dsp.internal.z.e getRequest() {
        return this.h;
    }

    @Override // com.ipd.dsp.internal.a0.p
    public final void getSize(@NonNull o oVar) {
        oVar.a(this.f, this.g);
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onDestroy() {
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
    public final void removeCallback(@NonNull o oVar) {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public final void setRequest(@Nullable com.ipd.dsp.internal.z.e eVar) {
        this.h = eVar;
    }

    public e(int i, int i2) {
        if (com.ipd.dsp.internal.d0.o.b(i, i2)) {
            this.f = i;
            this.g = i2;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }
}

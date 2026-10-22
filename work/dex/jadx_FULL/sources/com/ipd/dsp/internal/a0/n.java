package com.ipd.dsp.internal.a0;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Deprecated
public abstract class n<Z> extends b<Z> {
    public final int g;
    public final int h;

    public n() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.ipd.dsp.internal.a0.p
    public final void getSize(@NonNull o oVar) {
        if (com.ipd.dsp.internal.d0.o.b(this.g, this.h)) {
            oVar.a(this.g, this.h);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.g + " and height: " + this.h + ", either provide dimensions in the constructor or call override()");
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void removeCallback(@NonNull o oVar) {
    }

    public n(int i, int i2) {
        this.g = i;
        this.h = i2;
    }
}

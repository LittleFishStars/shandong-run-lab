package com.ipd.dsp.internal.r;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.d0.m;
import com.ipd.dsp.internal.i.v;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements v<byte[]> {
    public final byte[] f;

    public b(byte[] bArr) {
        this.f = (byte[]) m.a(bArr);
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f;
    }

    @Override // com.ipd.dsp.internal.i.v
    public int c() {
        return this.f.length;
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    public Class<byte[]> d() {
        return byte[].class;
    }

    @Override // com.ipd.dsp.internal.i.v
    public void e() {
    }
}

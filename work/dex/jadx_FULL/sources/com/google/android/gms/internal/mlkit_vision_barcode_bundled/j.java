package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j extends zzcu {
    public int K = 0;
    public final int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdb f31380a;

    public j(zzdb zzdbVar) {
        this.f31380a = zzdbVar;
        this.L = zzdbVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.K < this.L;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcw
    public final byte j0() {
        int i = this.K;
        if (i >= this.L) {
            throw new NoSuchElementException();
        }
        this.K = i + 1;
        return this.f31380a.zzb(i);
    }
}

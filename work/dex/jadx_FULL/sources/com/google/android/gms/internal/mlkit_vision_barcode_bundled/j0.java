package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j0 extends zzcu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f31381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zzcw f5811a = a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zzgg f5812a;

    public j0(zzgg zzggVar) {
        this.f5812a = zzggVar;
        this.f31381a = new l0(zzggVar, null);
    }

    public final zzcw a() {
        l0 l0Var = this.f31381a;
        if (l0Var.hasNext()) {
            return l0Var.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5811a != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcw
    public final byte j0() {
        zzcw zzcwVar = this.f5811a;
        if (zzcwVar == null) {
            throw new NoSuchElementException();
        }
        byte bJ0 = zzcwVar.j0();
        if (!this.f5811a.hasNext()) {
            this.f5811a = a();
        }
        return bJ0;
    }
}

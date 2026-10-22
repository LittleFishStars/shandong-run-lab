package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.qsc;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class l0 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzcx f31385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayDeque f5813a;

    public /* synthetic */ l0(zzdb zzdbVar, qsc qscVar) {
        if (!(zzdbVar instanceof zzgg)) {
            this.f5813a = null;
            this.f31385a = (zzcx) zzdbVar;
            return;
        }
        zzgg zzggVar = (zzgg) zzdbVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzggVar.zzf());
        this.f5813a = arrayDeque;
        arrayDeque.push(zzggVar);
        this.f31385a = b(zzggVar.zzd);
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzcx next() {
        zzcx zzcxVarB;
        zzcx zzcxVar = this.f31385a;
        if (zzcxVar == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.f5813a;
            zzcxVarB = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzcxVarB = b(((zzgg) this.f5813a.pop()).zze);
        } while (zzcxVarB.zzd() == 0);
        this.f31385a = zzcxVarB;
        return zzcxVar;
    }

    public final zzcx b(zzdb zzdbVar) {
        while (zzdbVar instanceof zzgg) {
            zzgg zzggVar = (zzgg) zzdbVar;
            this.f5813a.push(zzggVar);
            zzdbVar = zzggVar.zzd;
        }
        return (zzcx) zzdbVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f31385a != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

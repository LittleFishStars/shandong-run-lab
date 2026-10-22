package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.ofc;
import com.zj.adlib.ybc;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class zzch implements Iterator {
    public int K;
    public int L;
    public int M = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcl f31365a;

    public /* synthetic */ zzch(zzcl zzclVar, ofc ofcVar) {
        this.f31365a = zzclVar;
        this.K = zzclVar.zzf;
        this.L = zzclVar.zze();
    }

    public abstract Object a(int i);

    public final void b() {
        if (this.f31365a.zzf != this.K) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.L >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        b();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.L;
        this.M = i;
        Object objA = a(i);
        this.L = this.f31365a.zzf(this.L);
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        b();
        ybc.e(this.M >= 0, "no calls to next() since the last call to remove()");
        this.K += 32;
        zzcl zzclVar = this.f31365a;
        int i = this.M;
        Object[] objArr = zzclVar.zzb;
        objArr.getClass();
        zzclVar.remove(objArr[i]);
        this.L--;
        this.M = -1;
    }
}

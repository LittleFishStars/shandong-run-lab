package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.rlc;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b0 extends zzec.zza {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater<f0, Thread> f31340a;
    public final AtomicReferenceFieldUpdater<f0, f0> b;
    public final AtomicReferenceFieldUpdater<zzec, f0> c;
    public final AtomicReferenceFieldUpdater<zzec, a0> d;
    public final AtomicReferenceFieldUpdater<zzec, Object> e;

    public b0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super(null);
        this.f31340a = atomicReferenceFieldUpdater;
        this.b = atomicReferenceFieldUpdater2;
        this.c = atomicReferenceFieldUpdater3;
        this.d = atomicReferenceFieldUpdater4;
        this.e = atomicReferenceFieldUpdater5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final a0 a(zzec zzecVar, a0 a0Var) {
        return this.d.getAndSet(zzecVar, a0Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final f0 b(zzec zzecVar, f0 f0Var) {
        return this.c.getAndSet(zzecVar, f0Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final void c(f0 f0Var, @CheckForNull f0 f0Var2) {
        this.b.lazySet(f0Var, f0Var2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final void d(f0 f0Var, Thread thread) {
        this.f31340a.lazySet(f0Var, thread);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final boolean e(zzec zzecVar, @CheckForNull a0 a0Var, a0 a0Var2) {
        return rlc.a(this.d, zzecVar, a0Var, a0Var2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final boolean f(zzec zzecVar, @CheckForNull Object obj, Object obj2) {
        return rlc.a(this.e, zzecVar, obj, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzec.zza
    public final boolean g(zzec zzecVar, @CheckForNull f0 f0Var, @CheckForNull f0 f0Var2) {
        return rlc.a(this.c, zzecVar, f0Var, f0Var2);
    }
}

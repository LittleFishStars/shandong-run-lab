package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j extends h implements ListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f31351a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar) {
        super(kVar);
        this.f31351a = kVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        boolean zIsEmpty = this.f31351a.isEmpty();
        a();
        ((ListIterator) ((h) this).f5752a).add(obj);
        this.f31351a.b.zzb++;
        if (zIsEmpty) {
            this.f31351a.b();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        a();
        return ((ListIterator) ((h) this).f5752a).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        a();
        return ((ListIterator) ((h) this).f5752a).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        a();
        return ((ListIterator) ((h) this).f5752a).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        a();
        return ((ListIterator) ((h) this).f5752a).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        a();
        ((ListIterator) ((h) this).f5752a).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, int i) {
        super(kVar, ((List) ((i) kVar).f5755a).listIterator(i));
        this.f31351a = kVar;
    }
}

package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class zzdw implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f31367a;

    public zzdw(Iterator it) {
        it.getClass();
        this.f31367a = it;
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f31367a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f31367a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f31367a.remove();
    }
}

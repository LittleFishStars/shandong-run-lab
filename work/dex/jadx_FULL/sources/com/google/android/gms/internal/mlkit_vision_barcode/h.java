package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class h implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f31348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Collection f5751a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Iterator f5752a;

    public h(i iVar) {
        this.f31348a = iVar;
        Collection collection = iVar.f5755a;
        this.f5751a = collection;
        this.f5752a = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public h(i iVar, Iterator it) {
        this.f31348a = iVar;
        this.f5751a = iVar.f5755a;
        this.f5752a = it;
    }

    final void a() {
        this.f31348a.p();
        if (this.f31348a.f5755a != this.f5751a) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        a();
        return this.f5752a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        a();
        return this.f5752a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f5752a.remove();
        this.f31348a.f5753a.zzb--;
        this.f31348a.c();
    }
}

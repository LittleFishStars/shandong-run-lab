package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.v;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Deprecated
public final class qwc extends AbstractList implements RandomAccess, zzew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzew f44318a;

    public qwc(zzew zzewVar) {
        this.f44318a = zzewVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew
    public final zzew F() {
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew
    public final List b0() {
        return this.f44318a.b0();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((v) this.f44318a).get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new mwc(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew
    public final Object k(int i) {
        return this.f44318a.k(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new iwc(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f44318a.size();
    }
}

package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.ybc;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
enum zzcz implements Iterator {
    INSTANCE;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        ybc.e(false, "no calls to next() since the last call to remove()");
    }
}

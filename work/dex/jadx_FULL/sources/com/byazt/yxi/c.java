package com.byazt.yxi;

import android.util.SparseArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1133, 20})
public class c<E> extends SparseArray<E> {
    public final SparseArray<Object> c;

    public c(SparseArray<Object> sparseArray) {
        this.c = sparseArray;
    }

    public SparseArray<Object> c() {
        return this.c;
    }

    @Override // android.util.SparseArray
    public boolean contains(int i) {
        if (super.contains(i)) {
            return true;
        }
        SparseArray<Object> sparseArray = this.c;
        return sparseArray != null && sparseArray.indexOfKey(i) >= 0;
    }

    @Override // android.util.SparseArray
    public E get(int i, E e) {
        Object obj;
        E e2 = (E) super.get(i, null);
        if (e2 != null) {
            return e2;
        }
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null && (obj = sparseArray.get(i, null)) != null) {
            e2 = (E) obj;
        }
        return e2 != null ? e2 : e;
    }
}

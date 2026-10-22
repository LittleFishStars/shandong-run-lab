package com.aliyun.svideosdk.editor.impl;

import android.util.SparseArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class u<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<E> f25763a;
    private final Object b = this;

    public u(SparseArray<E> sparseArray) {
        this.f25763a = sparseArray;
    }

    public int a(E e) {
        synchronized (this.b) {
            int size = this.f25763a.size();
            for (int i = 0; i < size; i++) {
                if (e == null) {
                    if (this.f25763a.valueAt(i) == null) {
                        return i;
                    }
                } else if (e.equals(this.f25763a.valueAt(i))) {
                    return i;
                }
            }
            return -1;
        }
    }

    public void a() {
        synchronized (this.b) {
            this.f25763a.clear();
        }
    }

    public void a(int i) {
        synchronized (this.b) {
            this.f25763a.delete(i);
        }
    }

    public void a(int i, E e) {
        synchronized (this.b) {
            this.f25763a.put(i, e);
        }
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SparseArray<E> clone() {
        SparseArray<E> sparseArrayClone;
        synchronized (this.b) {
            sparseArrayClone = this.f25763a.clone();
        }
        return sparseArrayClone;
    }

    public E b(int i) {
        E e;
        synchronized (this.b) {
            e = this.f25763a.get(i);
        }
        return e;
    }

    public int c() {
        int size;
        synchronized (this.b) {
            size = this.f25763a.size();
        }
        return size;
    }

    public int c(int i) {
        int iIndexOfKey;
        synchronized (this.b) {
            iIndexOfKey = this.f25763a.indexOfKey(i);
        }
        return iIndexOfKey;
    }

    public int d(int i) {
        int iKeyAt;
        synchronized (this.b) {
            iKeyAt = this.f25763a.keyAt(i);
        }
        return iKeyAt;
    }

    public void e(int i) {
        synchronized (this.b) {
            this.f25763a.removeAt(i);
        }
    }

    public E f(int i) {
        E eValueAt;
        synchronized (this.b) {
            eValueAt = this.f25763a.valueAt(i);
        }
        return eValueAt;
    }
}

package com.zj.adlib;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class p3b<T> extends AbstractList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<a<T>> f43887a = new LinkedList<>();

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f43888a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public T f18764a;

        public a(T t) {
            this.f18764a = t;
        }
    }

    public final boolean a(T t) {
        a<T> aVar = new a<>(t);
        if (this.f43887a.isEmpty()) {
            this.f43887a.add(aVar);
            return true;
        }
        ListIterator<a<T>> listIterator = this.f43887a.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().f43888a < 0) {
                listIterator.previous();
                listIterator.add(aVar);
                return true;
            }
        }
        this.f43887a.addLast(aVar);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f43887a.get(i).f18764a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f43887a.size();
    }
}

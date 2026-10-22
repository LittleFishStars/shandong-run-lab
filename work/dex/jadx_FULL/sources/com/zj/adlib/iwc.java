package com.zj.adlib;

import java.util.ListIterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class iwc implements ListIterator {
    public final /* synthetic */ int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qwc f42459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ListIterator f17295a;

    public iwc(qwc qwcVar, int i) {
        this.f42459a = qwcVar;
        this.K = i;
        this.f17295a = qwcVar.f44318a.listIterator(i);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f17295a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f17295a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f17295a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f17295a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.f17295a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f17295a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}

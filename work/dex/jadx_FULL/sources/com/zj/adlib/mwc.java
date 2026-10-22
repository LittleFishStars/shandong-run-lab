package com.zj.adlib;

import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class mwc implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qwc f43402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Iterator f18323a;

    public mwc(qwc qwcVar) {
        this.f43402a = qwcVar;
        this.f18323a = qwcVar.f44318a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f18323a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f18323a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

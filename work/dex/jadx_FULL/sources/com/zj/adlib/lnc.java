package com.zj.adlib;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class lnc implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f43110a;

    public lnc(Iterator it) {
        this.f43110a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f43110a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f43110a.next();
        return entry.getValue() instanceof pnc ? new hnc(entry, null) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f43110a.remove();
    }
}

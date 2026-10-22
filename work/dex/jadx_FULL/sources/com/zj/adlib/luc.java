package com.zj.adlib;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class luc implements Iterator {
    public int K = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bvc f43163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Iterator f18088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18089a;

    public /* synthetic */ luc(bvc bvcVar, huc hucVar) {
        this.f43163a = bvcVar;
    }

    public final Iterator a() {
        if (this.f18088a == null) {
            this.f18088a = this.f43163a.f15649a.entrySet().iterator();
        }
        return this.f18088a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.K + 1 >= this.f43163a.f15648a.size()) {
            return !this.f43163a.f15649a.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.f18089a = true;
        int i = this.K + 1;
        this.K = i;
        return i < this.f43163a.f15648a.size() ? (Map.Entry) this.f43163a.f15648a.get(this.K) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f18089a) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f18089a = false;
        this.f43163a.o();
        if (this.K >= this.f43163a.f15648a.size()) {
            a().remove();
            return;
        }
        bvc bvcVar = this.f43163a;
        int i = this.K;
        this.K = i - 1;
        bvcVar.m(i);
    }
}

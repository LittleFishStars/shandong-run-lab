package com.zj.adlib;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class otd implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pud f43832a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CharSequence f18722a;

    public otd(pud pudVar, CharSequence charSequence) {
        this.f43832a = pudVar;
        this.f18722a = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f43832a.h(this.f18722a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(ind.a(it.next(), ", "));
                while (it.hasNext()) {
                    sb.append((CharSequence) ", ");
                    sb.append(ind.a(it.next(), ", "));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}

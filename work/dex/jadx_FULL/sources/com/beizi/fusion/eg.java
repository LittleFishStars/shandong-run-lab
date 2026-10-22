package com.beizi.fusion;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class eg extends fg implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f27233a = new ArrayList();

    public void a(Number number) {
        this.f27233a.add(number == null ? hg.f27365a : new lg(number));
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof eg) && ((eg) obj).f27233a.equals(this.f27233a);
        }
        return true;
    }

    public int hashCode() {
        return this.f27233a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f27233a.iterator();
    }

    public void a(String str) {
        this.f27233a.add(str == null ? hg.f27365a : new lg(str));
    }

    public void a(fg fgVar) {
        if (fgVar == null) {
            fgVar = hg.f27365a;
        }
        this.f27233a.add(fgVar);
    }
}

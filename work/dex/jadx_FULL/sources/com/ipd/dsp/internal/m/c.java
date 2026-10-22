package com.ipd.dsp.internal.m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<d, Integer> f38405a;
    public final List<d> b;
    public int c;
    public int d;

    public c(Map<d, Integer> map) {
        this.f38405a = map;
        this.b = new ArrayList(map.keySet());
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            this.c += it.next().intValue();
        }
    }

    public int a() {
        return this.c;
    }

    public boolean b() {
        return this.c == 0;
    }

    public d c() {
        d dVar = this.b.get(this.d);
        Integer num = this.f38405a.get(dVar);
        if (num.intValue() == 1) {
            this.f38405a.remove(dVar);
            this.b.remove(this.d);
        } else {
            this.f38405a.put(dVar, Integer.valueOf(num.intValue() - 1));
        }
        this.c--;
        this.d = this.b.isEmpty() ? 0 : (this.d + 1) % this.b.size();
        return dVar;
    }
}

package com.byazt.ut;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 834, 158})
public class sl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29108a;
    public final Class<Object> c;
    public volatile int da;
    public final boolean i;
    public final boolean n;
    public volatile Function sl;
    public final boolean sp;
    public volatile Map<com.byazt.dna.c, Object> t;
    public final Class<Object> tt;
    public volatile Object u;
    public final int uj;
    public final int ve;
    public final int[] x;
    public volatile int yp;

    public sl(Class cls, Class cls2, boolean z, int i, int i2, String str, boolean z2, int[] iArr, boolean z3) {
        this.c = cls;
        this.tt = cls2;
        this.ve = i;
        this.n = z;
        this.uj = i2;
        this.f29108a = str;
        this.sp = z2;
        if (i < 0) {
            this.yp = i;
        }
        if (z2) {
            this.t = new ConcurrentHashMap();
        }
        this.x = iArr;
        this.i = z3;
    }

    public boolean a() {
        return this.yp > this.da && this.yp > this.ve;
    }

    public int c() {
        return this.da;
    }

    public int n() {
        return this.yp;
    }

    public Function tt() {
        return this.sl;
    }

    public Object uj() {
        return this.u;
    }

    public Map<com.byazt.dna.c, Object> ve() {
        return this.t;
    }

    public void c(int i) {
        this.da = i;
    }

    public void tt(int i) {
        this.yp = i;
    }

    public void c(Function function) {
        this.sl = function;
    }

    public synchronized Object c(com.byazt.dna.c cVar) {
        if (this.sp && cVar != null && this.t != null) {
            return this.t.get(cVar);
        }
        return this.u;
    }

    public synchronized void c(Object obj, com.byazt.dna.c cVar) {
        if (this.sp && cVar != null && this.t != null) {
            this.t.put(cVar, obj);
            return;
        }
        this.u = obj;
    }
}

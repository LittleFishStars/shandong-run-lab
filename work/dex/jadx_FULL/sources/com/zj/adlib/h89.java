package com.zj.adlib;

import android.util.SparseArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h89 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<g89> f42073a = new SparseArray<>();

    public g89 a(int i) {
        g89 g89Var = this.f42073a.get(i);
        if (g89Var != null) {
            return g89Var;
        }
        g89 g89Var2 = new g89(9223372036854775806L);
        this.f42073a.put(i, g89Var2);
        return g89Var2;
    }

    public void b() {
        this.f42073a.clear();
    }
}

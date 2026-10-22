package com.byazt.bwm;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 33, 34})
public class a<V> extends FutureTask<V> implements Comparable<a<V>> {
    public int c;
    public int tt;

    public a(Callable<V> callable, int i, int i2) {
        super(callable);
        this.c = i == -1 ? 5 : i;
        this.tt = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        if (c() < aVar.c()) {
            return 1;
        }
        return c() > aVar.c() ? -1 : 0;
    }

    public int c() {
        return this.c;
    }
}

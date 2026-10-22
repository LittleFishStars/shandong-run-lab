package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d45 extends j45<Integer> {
    /* JADX WARN: Multi-variable type inference failed */
    public Integer e(a45<Integer> a45Var) {
        T t = ((j45) this).f17325a;
        if (t != 0) {
            return (Integer) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // com.zj.adlib.j45
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Integer a(a45<Integer> a45Var) {
        return Integer.valueOf(up5.l(a45Var.g().intValue(), a45Var.b().intValue(), a45Var.c()) + e(a45Var).intValue());
    }
}

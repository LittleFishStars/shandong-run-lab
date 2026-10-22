package com.zj.adlib;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c45 extends j45<Float> {
    public c45() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Float e(a45<Float> a45Var) {
        T t = ((j45) this).f17325a;
        if (t != 0) {
            return (Float) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // com.zj.adlib.j45
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Float a(a45<Float> a45Var) {
        return Float.valueOf(up5.k(a45Var.g().floatValue(), a45Var.b().floatValue(), a45Var.c()) + e(a45Var).floatValue());
    }

    public c45(@NonNull Float f) {
        super(f);
    }
}

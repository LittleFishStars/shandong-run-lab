package com.hp.hpl.sparta.xpath;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class AttrRelationalExpr extends AttrExpr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32699a;

    public AttrRelationalExpr(String str, int i) {
        super(str);
        this.f32699a = i;
    }

    public double c() {
        return this.f32699a;
    }

    public String toString(String str) {
        return "[" + super.toString() + str + "'" + this.f32699a + "']";
    }
}

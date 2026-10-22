package com.hp.hpl.sparta.xpath;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class AttrExpr extends BooleanExpr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32698a;

    public AttrExpr(String str) {
        this.f32698a = str;
    }

    public String b() {
        return this.f32698a;
    }

    public String toString() {
        return "@" + this.f32698a;
    }
}

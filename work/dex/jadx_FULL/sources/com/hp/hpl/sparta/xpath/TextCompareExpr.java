package com.hp.hpl.sparta.xpath;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class TextCompareExpr extends BooleanExpr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32700a;

    public TextCompareExpr(String str) {
        this.f32700a = str;
    }

    public String b() {
        return this.f32700a;
    }

    public String toString(String str) {
        return "[text()" + str + "'" + this.f32700a + "']";
    }
}

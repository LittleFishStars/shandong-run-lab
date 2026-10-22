package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.Sparta;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class AttrCompareExpr extends AttrExpr {
    public final String b;

    public AttrCompareExpr(String str, String str2) {
        super(str);
        this.b = Sparta.a(str2);
    }

    public String c() {
        return this.b;
    }

    public String toString(String str) {
        return "[" + super.toString() + str + "'" + this.b + "']";
    }
}

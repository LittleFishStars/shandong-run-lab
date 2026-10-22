package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class un2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final un2 f45183a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final un2[] f20109a;
    public static final un2 b;
    public static final un2 c;
    public static final un2 d;
    public static final un2 e;
    public static final un2 f;
    public static final un2 g;
    public static final un2 h;
    public static final un2 i;
    public static final un2 j;
    public static final un2 k;
    public static final un2 l;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f20110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f20111a;

    static {
        un2 un2Var = new un2(0, false);
        f45183a = un2Var;
        un2 un2Var2 = new un2(1, true);
        b = un2Var2;
        un2 un2Var3 = new un2(2, false);
        c = un2Var3;
        un2 un2Var4 = new un2(3, true);
        d = un2Var4;
        un2 un2Var5 = new un2(4, false);
        e = un2Var5;
        un2 un2Var6 = new un2(5, true);
        f = un2Var6;
        un2 un2Var7 = new un2(6, false);
        g = un2Var7;
        un2 un2Var8 = new un2(7, true);
        h = un2Var8;
        un2 un2Var9 = new un2(8, false);
        i = un2Var9;
        un2 un2Var10 = new un2(9, true);
        j = un2Var10;
        un2 un2Var11 = new un2(10, false);
        k = un2Var11;
        un2 un2Var12 = new un2(10, true);
        l = un2Var12;
        f20109a = new un2[]{un2Var, un2Var2, un2Var3, un2Var4, un2Var5, un2Var6, un2Var7, un2Var8, un2Var9, un2Var10, un2Var11, un2Var12};
    }

    public un2(int i2, boolean z) {
        this.f20110a = i2;
        this.f20111a = z;
    }

    public boolean a(un2 un2Var) {
        int i2 = this.f20110a;
        int i3 = un2Var.f20110a;
        return i2 < i3 || ((!this.f20111a || j == this) && i2 == i3);
    }

    public un2 b() {
        return !this.f20111a ? f20109a[this.f20110a + 1] : this;
    }

    public un2 c() {
        if (!this.f20111a) {
            return this;
        }
        un2 un2Var = f20109a[this.f20110a - 1];
        return !un2Var.f20111a ? un2Var : f45183a;
    }
}

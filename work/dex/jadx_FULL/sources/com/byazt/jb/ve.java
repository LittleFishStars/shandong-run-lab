package com.byazt.jb;

import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 54})
public final class ve {
    public final int i;
    public final com.byazt.mk.a sp;
    public final com.byazt.mk.a x;
    public static final com.byazt.mk.a c = com.byazt.mk.a.c(u15.f19942b);
    public static final com.byazt.mk.a tt = com.byazt.mk.a.c(":status");
    public static final com.byazt.mk.a ve = com.byazt.mk.a.c(":method");
    public static final com.byazt.mk.a uj = com.byazt.mk.a.c(":path");
    public static final com.byazt.mk.a n = com.byazt.mk.a.c(":scheme");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.byazt.mk.a f28695a = com.byazt.mk.a.c(":authority");

    public ve(String str, String str2) {
        this(com.byazt.mk.a.c(str), com.byazt.mk.a.c(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof ve) {
            ve veVar = (ve) obj;
            if (this.sp.equals(veVar.sp) && this.x.equals(veVar.x)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.sp.hashCode() + 527) * 31) + this.x.hashCode();
    }

    public String toString() {
        return com.byazt.kh.ve.c("%s: %s", this.sp.c(), this.x.c());
    }

    public ve(com.byazt.mk.a aVar, String str) {
        this(aVar, com.byazt.mk.a.c(str));
    }

    public ve(com.byazt.mk.a aVar, com.byazt.mk.a aVar2) {
        this.sp = aVar;
        this.x = aVar2;
        this.i = aVar.sp() + 32 + aVar2.sp();
    }
}

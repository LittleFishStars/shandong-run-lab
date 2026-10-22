package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class c57 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f40904a;

    public c57(boolean z) {
        this.f40904a = z;
    }

    public void a(xg7[] xg7VarArr) {
        if (!this.f40904a || xg7VarArr == null || xg7VarArr.length < 3) {
            return;
        }
        xg7 xg7Var = xg7VarArr[0];
        xg7VarArr[0] = xg7VarArr[2];
        xg7VarArr[2] = xg7Var;
    }

    public boolean b() {
        return this.f40904a;
    }
}

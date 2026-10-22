package com.zj.adlib;

import cn.hzjizhun.admin.base.l0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class ngb extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0 f43518a;
    public final /* synthetic */ String b;

    public ngb(l0 l0Var, String str) {
        this.f43518a = l0Var;
        this.b = str;
    }

    @Override // cn.hzjizhun.admin.base.l0
    public final void a(int i, String str) {
        l0 l0Var = this.f43518a;
        if (l0Var != null) {
            l0Var.a(i, str);
        }
        try {
            rzb.a().f19454a.reportWithProbability(this.b);
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.base.l0
    public final void b(String str) {
        l0 l0Var = this.f43518a;
        if (l0Var != null) {
            l0Var.b(str);
        }
    }
}

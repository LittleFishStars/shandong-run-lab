package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class k0 extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f39378a;

    public k0(j0 j0Var) {
        this.f39378a = j0Var;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        j0 j0Var;
        Boolean bool;
        super.safeRun();
        if (com.kc.dw.core.service.c.a()) {
            LogUtil.dev("OpenAppDialogStateChecker", "dialog state 3");
            j0Var = this.f39378a;
            bool = Boolean.FALSE;
        } else {
            LogUtil.dev("OpenAppDialogStateChecker", "dialog state 5");
            j0Var = this.f39378a;
            bool = Boolean.TRUE;
        }
        j0Var.e = bool;
        j0 j0Var2 = this.f39378a;
        j0.a(j0Var2, j0Var2.e.booleanValue());
    }
}

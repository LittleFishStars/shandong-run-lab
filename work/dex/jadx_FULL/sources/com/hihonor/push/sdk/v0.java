package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class v0<TResult> implements j0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f32678a;
    public l0 b;
    public final Object c = new Object();

    public v0(Executor executor, l0 l0Var) {
        this.b = l0Var;
        this.f32678a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        if (a1Var.e()) {
            return;
        }
        a1Var.d();
        this.f32678a.execute(new u0(this, a1Var));
    }
}

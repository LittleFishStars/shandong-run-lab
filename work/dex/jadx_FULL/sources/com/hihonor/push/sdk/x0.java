package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class x0<TResult> implements j0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f32682a;
    public m0<TResult> b;
    public final Object c = new Object();

    public x0(Executor executor, m0<TResult> m0Var) {
        this.b = m0Var;
        this.f32682a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        if (a1Var.e()) {
            a1Var.d();
            this.f32682a.execute(new w0(this, a1Var));
        }
    }
}

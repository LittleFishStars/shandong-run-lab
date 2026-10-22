package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class t0<TResult> implements j0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f32674a;
    public k0<TResult> b;
    public final Object c = new Object();

    public t0(Executor executor, k0<TResult> k0Var) {
        this.b = k0Var;
        this.f32674a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        this.f32674a.execute(new s0(this, a1Var));
    }
}

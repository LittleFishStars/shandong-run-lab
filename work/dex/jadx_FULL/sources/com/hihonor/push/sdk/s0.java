package com.hihonor.push.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f32672a;
    public final /* synthetic */ t0 b;

    public s0(t0 t0Var, a1 a1Var) {
        this.b = t0Var;
        this.f32672a = a1Var;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.b.c) {
            k0<TResult> k0Var = this.b.b;
            if (k0Var != 0) {
                k0Var.a((a1<TResult>) this.f32672a);
            }
        }
    }
}

package com.hihonor.push.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class u0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f32676a;
    public final /* synthetic */ v0 b;

    public u0(v0 v0Var, a1 a1Var) {
        this.b = v0Var;
        this.f32676a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.b.c) {
            l0 l0Var = this.b.b;
            if (l0Var != null) {
                this.f32676a.b();
                ((y0) l0Var).f32684a.countDown();
            }
        }
    }
}

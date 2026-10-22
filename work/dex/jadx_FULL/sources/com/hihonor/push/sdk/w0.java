package com.hihonor.push.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class w0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f32680a;
    public final /* synthetic */ x0 b;

    public w0(x0 x0Var, a1 a1Var) {
        this.b = x0Var;
        this.f32680a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.b.c) {
            Object obj = this.b.b;
            if (obj != null) {
                this.f32680a.c();
                ((y0) obj).f32684a.countDown();
            }
        }
    }
}

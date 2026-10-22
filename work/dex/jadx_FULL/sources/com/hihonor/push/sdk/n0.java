package com.hihonor.push.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class n0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a1<TResult> f32661a = new a1<>();

    public void a(TResult tresult) {
        a1<TResult> a1Var = this.f32661a;
        synchronized (a1Var.f32637a) {
            if (!a1Var.b) {
                a1Var.b = true;
                a1Var.c = tresult;
                a1Var.f32637a.notifyAll();
                a1Var.a();
            }
        }
    }

    public void a(Exception exc) {
        a1<TResult> a1Var = this.f32661a;
        synchronized (a1Var.f32637a) {
            if (!a1Var.b) {
                a1Var.b = true;
                a1Var.d = exc;
                a1Var.f32637a.notifyAll();
                a1Var.a();
            }
        }
    }
}

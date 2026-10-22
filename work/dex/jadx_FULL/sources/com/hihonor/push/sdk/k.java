package com.hihonor.push.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f32656a;
    public final /* synthetic */ l b;

    public k(l lVar, HonorPushCallback honorPushCallback) {
        this.b = lVar;
        this.f32656a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.b.d;
        HonorPushCallback honorPushCallback = this.f32656a;
        sVar.getClass();
        if (honorPushCallback == null) {
            return;
        }
        a1 a1VarA = b.a(new p0(sVar.f32670a));
        C1449r c1449r = new C1449r(sVar, honorPushCallback);
        a1VarA.getClass();
        a1VarA.a(new t0(o0.c.f32663a, c1449r));
    }
}

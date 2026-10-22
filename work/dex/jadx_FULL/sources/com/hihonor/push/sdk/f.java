package com.hihonor.push.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f32644a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ l c;

    public f(l lVar, HonorPushCallback honorPushCallback, boolean z) {
        this.c = lVar;
        this.f32644a = honorPushCallback;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.c.d;
        sVar.a(new m(sVar, this.b), this.f32644a);
    }
}

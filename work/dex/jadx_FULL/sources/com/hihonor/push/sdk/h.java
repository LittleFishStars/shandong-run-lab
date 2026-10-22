package com.hihonor.push.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f32649a;
    public final /* synthetic */ l b;

    public h(l lVar, HonorPushCallback honorPushCallback) {
        this.b = lVar;
        this.f32649a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.b.d;
        sVar.a(new o(sVar), this.f32649a);
    }
}

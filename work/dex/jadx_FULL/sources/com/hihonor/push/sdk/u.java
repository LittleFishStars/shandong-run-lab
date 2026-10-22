package com.hihonor.push.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f32675a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public u(s sVar, HonorPushCallback honorPushCallback, int i, String str) {
        this.f32675a = honorPushCallback;
        this.b = i;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f32675a;
        if (honorPushCallback != null) {
            honorPushCallback.onFailure(this.b, this.c);
        }
    }
}

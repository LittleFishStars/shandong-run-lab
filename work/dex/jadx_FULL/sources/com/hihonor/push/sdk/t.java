package com.hihonor.push.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f32673a;
    public final /* synthetic */ Object b;

    public t(s sVar, HonorPushCallback honorPushCallback, Object obj) {
        this.f32673a = honorPushCallback;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f32673a;
        if (honorPushCallback != null) {
            honorPushCallback.onSuccess(this.b);
        }
    }
}

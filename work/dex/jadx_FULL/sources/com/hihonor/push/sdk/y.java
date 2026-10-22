package com.hihonor.push.sdk;

import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f32683a;
    public final /* synthetic */ z.a b;

    public y(z.a aVar, int i) {
        this.b = aVar;
        this.f32683a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(HonorPushErrorEnum.fromCode(this.f32683a));
    }
}

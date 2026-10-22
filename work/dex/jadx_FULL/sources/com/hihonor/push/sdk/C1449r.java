package com.hihonor.push.sdk;

import java.util.List;

/* JADX INFO: renamed from: com.hihonor.push.sdk.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class C1449r implements k0<List<HonorPushDataMsg>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f32668a;
    public final /* synthetic */ s b;

    public C1449r(s sVar, HonorPushCallback honorPushCallback) {
        this.b = sVar;
        this.f32668a = honorPushCallback;
    }

    @Override // com.hihonor.push.sdk.k0
    public void a(a1<List<HonorPushDataMsg>> a1Var) {
        if (!a1Var.e()) {
            s.a(this.b, this.f32668a, -1, a1Var.b().toString());
            return;
        }
        s sVar = this.b;
        HonorPushCallback honorPushCallback = this.f32668a;
        List<HonorPushDataMsg> listC = a1Var.c();
        sVar.getClass();
        b1.a(new t(sVar, honorPushCallback, listC));
    }
}

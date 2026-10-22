package com.hihonor.push.sdk;

import android.util.Log;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class a implements k0<HonorPushDataMsg> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorMessageService f32636a;

    public a(HonorMessageService honorMessageService) {
        this.f32636a = honorMessageService;
    }

    @Override // com.hihonor.push.sdk.k0
    public void a(a1<HonorPushDataMsg> a1Var) {
        if (!a1Var.e()) {
            boolean z = a1Var.b() instanceof JSONException;
            return;
        }
        HonorPushDataMsg honorPushDataMsgC = a1Var.c();
        if (honorPushDataMsgC == null) {
            Log.i("HonorMessageService", "parse remote data failed.");
            return;
        }
        Log.i("HonorMessageService", "onMessageReceived. msgId is " + honorPushDataMsgC.getMsgId());
        this.f32636a.onMessageReceived(honorPushDataMsgC);
    }
}

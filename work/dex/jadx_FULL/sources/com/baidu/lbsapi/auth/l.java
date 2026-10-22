package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class l extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f26313a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(LBSAuthManager lBSAuthManager, Looper looper) {
        super(looper);
        this.f26313a = lBSAuthManager;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        b.a("handleMessage !!");
        if (message.what == 0) {
            this.f26313a.a((JSONObject) message.obj);
        }
        LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) LBSAuthManager.j.get(message.getData().getString("listenerKey"));
        b.a("handleMessage listener = " + lBSAuthManagerListener);
        if (lBSAuthManagerListener != null) {
            lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
        }
    }
}

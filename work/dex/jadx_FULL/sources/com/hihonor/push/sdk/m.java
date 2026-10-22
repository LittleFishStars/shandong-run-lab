package com.hihonor.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.DownMsgType;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class m implements Callable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f32659a;
    public final /* synthetic */ s b;

    public m(s sVar, boolean z) {
        this.b = sVar;
        this.f32659a = z;
    }

    @Override // java.util.concurrent.Callable
    public String call() throws Exception {
        this.b.b.getClass();
        try {
            e1 e1Var = new e1(UpMsgType.REQUEST_PUSH_TOKEN, null);
            e1Var.e = b.a();
            String pushToken = ((PushTokenResult) b.a(z.c.a(e1Var))).getPushToken();
            if (this.f32659a) {
                s sVar = this.b;
                sVar.getClass();
                if (!TextUtils.isEmpty(pushToken)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("event_type", DownMsgType.RECEIVE_TOKEN);
                    bundle.putString("push_token", pushToken);
                    g0 g0Var = new g0();
                    Context context = sVar.f32670a;
                    Log.i("MessengerSrvConnection", "start bind service.");
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setAction("com.hihonor.push.action.MESSAGING_EVENT");
                        Context applicationContext = context.getApplicationContext();
                        g0Var.c = applicationContext;
                        g0Var.b = bundle;
                        if (applicationContext.bindService(intent, g0Var, 1)) {
                            Log.i("MessengerSrvConnection", "bind service succeeded.");
                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }
            return pushToken;
        } catch (Exception e2) {
            throw b.a(e2);
        }
    }
}

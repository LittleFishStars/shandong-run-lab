package com.hihonor.push.sdk;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class e0 implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f32643a;

    public e0(f0 f0Var) {
        this.f32643a = f0Var;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null || message.what != 1001) {
            return false;
        }
        this.f32643a.a(8002003);
        return true;
    }
}

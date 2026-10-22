package com.zj.adlib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SuppressLint({"HandlerLeak"})
public final class y1c extends o5c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f45938a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pv3 f20764a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1c(pv3 pv3Var, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f20764a = pv3Var;
        this.f45938a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i);
            return;
        }
        int iJ = this.f20764a.j(this.f45938a);
        if (this.f20764a.o(iJ)) {
            this.f20764a.C(this.f45938a, iJ);
        }
    }
}

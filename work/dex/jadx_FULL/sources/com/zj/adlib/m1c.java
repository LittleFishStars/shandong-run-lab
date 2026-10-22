package com.zj.adlib;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.internal.p;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class m1c extends o5c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f43200a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1c(p pVar, Looper looper) {
        super(looper);
        this.f43200a = pVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            p.N(this.f43200a);
            return;
        }
        if (i == 2) {
            p.M(this.f43200a);
            return;
        }
        Log.w("GoogleApiClientImpl", "Unknown message id: " + i);
    }
}

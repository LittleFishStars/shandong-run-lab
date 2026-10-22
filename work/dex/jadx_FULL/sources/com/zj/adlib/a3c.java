package com.zj.adlib;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a3c extends o5c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i3c f40446a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a3c(i3c i3cVar, Looper looper) {
        super(looper);
        this.f40446a = i3cVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 0) {
            if (i == 1) {
                RuntimeException runtimeException = (RuntimeException) message.obj;
                Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: ".concat(String.valueOf(runtimeException.getMessage())));
                throw runtimeException;
            }
            Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + i);
            return;
        }
        PendingResult pendingResult = (PendingResult) message.obj;
        synchronized (this.f40446a.f17133a) {
            i3c i3cVar = (i3c) yw6.l(this.f40446a.f17132a);
            if (pendingResult == null) {
                i3cVar.m(new Status(13, "Transform returned null"));
            } else if (pendingResult instanceof t2c) {
                i3cVar.m(((t2c) pendingResult).j());
            } else {
                i3cVar.l(pendingResult);
            }
        }
    }
}

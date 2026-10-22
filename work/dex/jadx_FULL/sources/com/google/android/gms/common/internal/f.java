package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.zj.adlib.ozc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f extends ozc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f31299a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        this.f31299a = baseGmsClient;
    }

    public static final void a(Message message) {
        zzc zzcVar = (zzc) message.obj;
        zzcVar.zzc();
        zzcVar.c();
    }

    public static final boolean b(Message message) {
        int i = message.what;
        return i == 2 || i == 1 || i == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f31299a.f5670a.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i = message.what;
        if ((i == 1 || i == 7 || ((i == 4 && !this.f31299a.enableLocalFallback()) || message.what == 5)) && !this.f31299a.isConnecting()) {
            a(message);
            return;
        }
        int i2 = message.what;
        if (i2 == 4) {
            this.f31299a.f5658a = new ConnectionResult(message.arg2);
            if (BaseGmsClient.S(this.f31299a)) {
                BaseGmsClient baseGmsClient = this.f31299a;
                if (!baseGmsClient.f5671a) {
                    baseGmsClient.T(3, null);
                    return;
                }
            }
            BaseGmsClient baseGmsClient2 = this.f31299a;
            ConnectionResult connectionResult = baseGmsClient2.f5658a != null ? baseGmsClient2.f5658a : new ConnectionResult(8);
            this.f31299a.f5661a.b(connectionResult);
            this.f31299a.onConnectionFailed(connectionResult);
            return;
        }
        if (i2 == 5) {
            BaseGmsClient baseGmsClient3 = this.f31299a;
            ConnectionResult connectionResult2 = baseGmsClient3.f5658a != null ? baseGmsClient3.f5658a : new ConnectionResult(8);
            this.f31299a.f5661a.b(connectionResult2);
            this.f31299a.onConnectionFailed(connectionResult2);
            return;
        }
        if (i2 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f31299a.f5661a.b(connectionResult3);
            this.f31299a.onConnectionFailed(connectionResult3);
            return;
        }
        if (i2 == 6) {
            this.f31299a.T(5, null);
            BaseGmsClient baseGmsClient4 = this.f31299a;
            if (baseGmsClient4.f5659a != null) {
                baseGmsClient4.f5659a.onConnectionSuspended(message.arg2);
            }
            this.f31299a.onConnectionSuspended(message.arg2);
            BaseGmsClient.R(this.f31299a, 5, 1, null);
            return;
        }
        if (i2 == 2 && !this.f31299a.isConnected()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((zzc) message.obj).a();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}

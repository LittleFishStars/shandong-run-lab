package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@VisibleForTesting
public final class g implements ServiceConnection {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f31300a;

    public g(BaseGmsClient baseGmsClient, int i) {
        this.f31300a = baseGmsClient;
        this.K = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        BaseGmsClient baseGmsClient = this.f31300a;
        if (iBinder == null) {
            BaseGmsClient.P(baseGmsClient, 16);
            return;
        }
        synchronized (baseGmsClient.f5672b) {
            BaseGmsClient baseGmsClient2 = this.f31300a;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            baseGmsClient2.f5663a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGmsServiceBroker)) ? new zzac(iBinder) : (IGmsServiceBroker) iInterfaceQueryLocalInterface;
        }
        this.f31300a.zzl(0, null, this.K);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f31300a.f5672b) {
            this.f31300a.f5663a = null;
        }
        Handler handler = this.f31300a.f5655a;
        handler.sendMessage(handler.obtainMessage(6, this.K, 1));
    }
}

package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.zj.adlib.yw6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h extends zza {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final IBinder f31301a;
    public final /* synthetic */ BaseGmsClient c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public h(BaseGmsClient baseGmsClient, @Nullable int i, @Nullable IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, i, bundle);
        this.c = baseGmsClient;
        this.f31301a = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult) {
        if (this.c.f5660a != null) {
            this.c.f5660a.onConnectionFailed(connectionResult);
        }
        this.c.onConnectionFailed(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.zza
    public final boolean zzd() {
        try {
            IBinder iBinder = this.f31301a;
            yw6.l(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.c.getServiceDescriptor().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.c.getServiceDescriptor() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceCreateServiceInterface = this.c.createServiceInterface(this.f31301a);
            if (iInterfaceCreateServiceInterface == null || !(BaseGmsClient.R(this.c, 2, 4, iInterfaceCreateServiceInterface) || BaseGmsClient.R(this.c, 3, 4, iInterfaceCreateServiceInterface))) {
                return false;
            }
            this.c.f5658a = null;
            Bundle bundleX = this.c.x();
            BaseGmsClient baseGmsClient = this.c;
            if (baseGmsClient.f5659a == null) {
                return true;
            }
            baseGmsClient.f5659a.onConnected(bundleX);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}

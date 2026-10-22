package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bun.miitmdid.content.StringValues;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class n {
    public Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.n.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.c.i("ZTEDeviceIDHelper", "onServiceConnected");
                n.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public n(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        ServiceConnection serviceConnection;
        String oaid = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction(StringValues.ACTION_BINDTO_MSASERVICE);
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.mContext.getPackageName());
            boolean zBindService = this.mContext.bindService(intent, this.serviceConnection, 1);
            com.kwad.sdk.core.d.c.i("ZTEDeviceIDHelper", "getOAID isBind=" + zBindService);
            try {
                if (zBindService) {
                    try {
                        oaid = new com.kwad.sdk.core.e.b.h.a(this.mLinkedBlockingQueue.take()).getOAID();
                        com.kwad.sdk.core.d.c.i("ZTEDeviceIDHelper", "getOAID oaid:" + oaid);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    }
                    context.unbindService(serviceConnection);
                }
            } catch (Throwable th) {
                this.mContext.unbindService(this.serviceConnection);
                throw th;
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.i("ZTEDeviceIDHelper", "getOAID hw service not found");
            com.kwad.sdk.core.d.c.printStackTrace(e2);
        }
        return oaid;
    }
}

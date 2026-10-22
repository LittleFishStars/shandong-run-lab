package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.d.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.c.i("HWDeviceIDHelper", "onServiceConnected");
                d.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public d(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        ServiceConnection serviceConnection;
        String iDs = "";
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            try {
                if (this.mContext.bindService(intent, this.serviceConnection, 1)) {
                    try {
                        com.kwad.sdk.core.e.b.d.a aVar = new com.kwad.sdk.core.e.b.d.a(this.mLinkedBlockingQueue.take());
                        iDs = aVar.getIDs();
                        com.kwad.sdk.core.d.c.i("HWDeviceIDHelper", "getOAID oaid:" + iDs + "--boos:" + aVar.getBoos());
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
            com.kwad.sdk.core.d.c.i("HWDeviceIDHelper", "getOAID hw service not found");
            com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
        }
        return iDs;
    }
}

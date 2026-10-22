package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.kc.openset.constant.DeviceIdType;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "onServiceConnected ： " + iBinder);
                b.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public b(Context context) {
        this.mContext = context;
    }

    private c.C1283c MP() {
        Context context;
        ServiceConnection serviceConnection;
        c cVar = new c();
        cVar.mContext = this.mContext;
        try {
            Intent intent = new Intent();
            intent.setAction("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            if (c.isAdvertisingIdAvailable(this.mContext) && this.mContext.bindService(intent, this.serviceConnection, 1)) {
                try {
                    try {
                        cVar.aUF = new c.C1283c();
                        com.kwad.sdk.core.e.b.b.a aVar = new com.kwad.sdk.core.e.b.b.a(this.mLinkedBlockingQueue.take());
                        aVar.a(cVar.aUG);
                        aVar.b(cVar.aUH);
                        cVar.mCountDownLatch.await(3000L, TimeUnit.MICROSECONDS);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", e);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    }
                    context.unbindService(serviceConnection);
                } catch (Throwable th) {
                    this.mContext.unbindService(this.serviceConnection);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "getOAID honor service not found" + th2);
        }
        return cVar.aUF;
    }

    public final String getOAID() {
        String string;
        try {
            string = Settings.Global.getString(this.mContext.getContentResolver(), DeviceIdType.OAID);
            try {
                if (TextUtils.isEmpty(string)) {
                    string = Settings.Secure.getString(this.mContext.getContentResolver(), DeviceIdType.OAID);
                }
                com.kwad.sdk.core.d.c.i("HONORDeviceIDHelper", "getOAID secure: " + string);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        } catch (Throwable th2) {
            th = th2;
            string = "";
        }
        if (string != null && !string.isEmpty()) {
            return string;
        }
        c.C1283c c1283cMP = MP();
        return c1283cMP != null ? c1283cMP.id : "";
    }
}

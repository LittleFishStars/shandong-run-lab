package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.SamsungIDInterface;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class SamsungDeviceIDHelper {
    private static final String TAG = "SamsungDeviceIDHelper";
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> linkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.liteapi.oaid.helpers.SamsungDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                SamsungDeviceIDHelper.this.linkedBlockingQueue.put(iBinder);
            } catch (Exception e) {
                LiteApiLogger.printStackTrace(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public SamsungDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getOAID() {
        Context context;
        ServiceConnection serviceConnection;
        String id = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            try {
                if (this.mContext.bindService(intent, this.serviceConnection, 1)) {
                    try {
                        id = new SamsungIDInterface.a(this.linkedBlockingQueue.take()).getID();
                        LiteApiLogger.i(TAG, "getOAID oaid:" + id);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    } catch (Exception e) {
                        LiteApiLogger.printStackTrace(e);
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
            LiteApiLogger.i(TAG, "getOAID service not found");
            LiteApiLogger.printStackTrace(e2);
        }
        return id;
    }
}

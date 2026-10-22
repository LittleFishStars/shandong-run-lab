package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.LenovoIDInterface;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class LenovoDeviceIDHelper {
    private static final String TAG = "LenovoDeviceIDHelper";
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.liteapi.oaid.helpers.LenovoDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                LiteApiLogger.i(LenovoDeviceIDHelper.TAG, "onServiceConnected");
                LenovoDeviceIDHelper.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e) {
                LiteApiLogger.printStackTrace(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public LenovoDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getOAID() {
        Context context;
        ServiceConnection serviceConnection;
        String oaid = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            try {
                if (this.mContext.bindService(intent, this.serviceConnection, 1)) {
                    try {
                        oaid = new LenovoIDInterface.a(this.mLinkedBlockingQueue.take()).getOaid();
                        LiteApiLogger.i(TAG, "getOAID oaid:" + oaid);
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
            LiteApiLogger.i(TAG, "getOAID Lenovo service not found");
            LiteApiLogger.printStackTrace(e2);
        }
        return oaid;
    }
}

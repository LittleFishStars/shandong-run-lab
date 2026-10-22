package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.kc.openset.constant.DeviceIdType;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.HONORInterface;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HONORDeviceIDHelper {
    private static final String TAG = "HONORDeviceIDHelper";
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.liteapi.oaid.helpers.HONORDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                LiteApiLogger.d(HONORDeviceIDHelper.TAG, "onServiceConnected ： " + iBinder);
                HONORDeviceIDHelper.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e) {
                LiteApiLogger.d(HONORDeviceIDHelper.TAG, e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public HONORDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public HONORProxy.c getAdInfo() {
        Context context;
        ServiceConnection serviceConnection;
        HONORProxy hONORProxy = new HONORProxy();
        hONORProxy.mContext = this.mContext;
        try {
            Intent intent = new Intent();
            intent.setAction("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            if (hONORProxy.isAdvertisingIdAvailable(this.mContext) && this.mContext.bindService(intent, this.serviceConnection, 1)) {
                try {
                    try {
                        hONORProxy.info = new HONORProxy.c();
                        HONORInterface.a aVar = new HONORInterface.a(this.mLinkedBlockingQueue.take());
                        aVar.getIDs(hONORProxy.mBinderOne);
                        aVar.getBoos(hONORProxy.mBinderTwo);
                        hONORProxy.mCountDownLatch.await(3000L, TimeUnit.MICROSECONDS);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    } catch (Exception e) {
                        LiteApiLogger.d(TAG, e);
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
            LiteApiLogger.d(TAG, "getOAID honor service not found" + th2);
        }
        return hONORProxy.info;
    }

    public String getOAID() {
        String string;
        try {
            string = Settings.Global.getString(this.mContext.getContentResolver(), DeviceIdType.OAID);
            try {
                if (TextUtils.isEmpty(string)) {
                    string = Settings.Secure.getString(this.mContext.getContentResolver(), DeviceIdType.OAID);
                }
                LiteApiLogger.i(TAG, "getOAID secure: " + string);
            } catch (Throwable th) {
                th = th;
                LiteApiLogger.printStackTrace(th);
            }
        } catch (Throwable th2) {
            th = th2;
            string = "";
        }
        if (string != null && !string.isEmpty()) {
            return string;
        }
        HONORProxy.c adInfo = getAdInfo();
        return adInfo != null ? adInfo.id : "";
    }
}

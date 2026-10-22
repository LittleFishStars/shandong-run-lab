package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.PackageManagerUtils;
import com.kwad.sdk.liteapi.oaid.interfaces.OppoIDInterface;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OppoDeviceIDHelper {
    private static final String TAG = "OppoDeviceIDHelper";
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.liteapi.oaid.helpers.OppoDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LiteApiLogger.i(OppoDeviceIDHelper.TAG, "onServiceConnected");
            try {
                OppoDeviceIDHelper.this.mLinkedBlockingQueue.put(iBinder);
            } catch (InterruptedException e) {
                LiteApiLogger.printStackTrace(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public OppoDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    private String getSign() {
        Signature[] signatureArr;
        try {
            Context context = this.mContext;
            PackageInfo packageInfo = PackageManagerUtils.getPackageInfo(context, context.getPackageName(), 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return null;
            }
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            LiteApiLogger.printStackTrace(e);
            return null;
        }
    }

    private boolean isSupportOppo() {
        try {
            PackageInfo packageInfo = PackageManagerUtils.getPackageInfo(this.mContext, "com.heytap.openid", 0);
            if (packageInfo == null) {
                return false;
            }
            return (Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode) >= 1;
        } catch (Exception e) {
            LiteApiLogger.printStackTrace(e);
        }
    }

    public String getOAID() {
        Context context;
        ServiceConnection serviceConnection;
        String serID = "";
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            boolean zBindService = this.mContext.bindService(intent, this.serviceConnection, 1);
            LiteApiLogger.i(TAG, "getOAID isBin=" + zBindService);
            if (zBindService) {
                try {
                    try {
                        serID = new OppoIDInterface.a(this.mLinkedBlockingQueue.take()).getSerID(this.mContext.getPackageName(), getSign(), "OUID");
                        LiteApiLogger.i(TAG, "getOAID oaid" + serID);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    } catch (Exception e) {
                        LiteApiLogger.printStackTrace(e);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    }
                    context.unbindService(serviceConnection);
                } catch (Throwable th) {
                    this.mContext.unbindService(this.serviceConnection);
                    throw th;
                }
            }
        } catch (Exception e2) {
            LiteApiLogger.i(TAG, "getOAID service not found");
            LiteApiLogger.printStackTraceOnly(e2);
        }
        return serID;
    }
}

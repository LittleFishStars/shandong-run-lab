package com.kwad.sdk.oaid;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.WorkerThread;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OADIDSDKHelper25 {
    private static final String SUB_TAG = "OADIDSDKHelper25:";
    private static final String TAG = "KSAdSDK";
    private static boolean mIsRequestIng = false;
    private static boolean sGetOaidFail = false;

    @Keep
    public static class IIdentifierListener25 implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListener25(long j, a aVar) {
            this.mStartTime = j;
            this.mOaidListener = aVar;
        }

        @Override // com.bun.miitmdid.interfaces.IIdentifierListener
        public void OnSupport(boolean z, IdSupplier idSupplier) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (TextUtils.isEmpty(oaid)) {
                    boolean unused = OADIDSDKHelper25.sGetOaidFail = true;
                } else {
                    Log.d(OADIDSDKHelper25.TAG, "OADIDSDKHelper25:oaid time=" + jCurrentTimeMillis + "--OAID:" + oaid);
                    this.mOaidListener.OnOAIDValid(oaid);
                }
            }
            boolean unused2 = OADIDSDKHelper25.mIsRequestIng = false;
        }
    }

    public interface a {
        @WorkerThread
        void OnOAIDValid(String str);
    }

    public static void getOAId(Context context, a aVar) {
        if (context == null || sGetOaidFail) {
            return;
        }
        if (!isSupport()) {
            sGetOaidFail = true;
            return;
        }
        if (mIsRequestIng) {
            return;
        }
        mIsRequestIng = true;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iInitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener25(jCurrentTimeMillis, aVar));
            Log.d(TAG, "OADIDSDKHelper25:sdk init time=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--result=" + iInitSdk);
        } catch (Throwable unused) {
            Log.d(TAG, "OADIDSDKHelper25:oaid sdk not find ");
            mIsRequestIng = false;
            sGetOaidFail = true;
        }
    }

    public static boolean isSupport() {
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.OADIDSDKHelper25.1
                @Override // com.bun.miitmdid.interfaces.IIdentifierListener
                public void OnSupport(boolean z, IdSupplier idSupplier) {
                }
            }.OnSupport(true, null);
            try {
                Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper25.class.getClassLoader());
                return true;
            } catch (Throwable unused) {
                Log.d(TAG, "OADIDSDKHelper25:com.bun.miitmdid.core.MdidSdkHelper oaid sdk not find ");
                return false;
            }
        } catch (Throwable unused2) {
            Log.d(TAG, "OADIDSDKHelper25:isSupport oaid sdk not find ");
            return false;
        }
    }
}

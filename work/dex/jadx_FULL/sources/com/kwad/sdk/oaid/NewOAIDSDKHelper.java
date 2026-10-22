package com.kwad.sdk.oaid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.e;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class NewOAIDSDKHelper {
    private static boolean mIsRequestIng = false;
    private static boolean sGetOaidFail = false;

    public static class IIdentifierListenerImpl implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListenerImpl(long j, a aVar) {
            this.mStartTime = j;
            this.mOaidListener = aVar;
        }

        public void onSupport(IdSupplier idSupplier) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (TextUtils.isEmpty(oaid)) {
                    NewOAIDSDKHelper.access$002(true);
                } else {
                    Log.d("KSAdSDK", "OADIDSDKHelper:oaid time=" + jCurrentTimeMillis + "--OAID:" + oaid);
                    this.mOaidListener.OnOAIDValid(oaid);
                }
            }
            NewOAIDSDKHelper.access$102(false);
        }
    }

    public interface a {
        void OnOAIDValid(String str);
    }

    public static void a(Context context, a aVar) {
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
            int iInitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListenerImpl(jCurrentTimeMillis, aVar));
            Log.d("KSAdSDK", "OADIDSDKHelper:sdk init time=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--result=" + iInitSdk);
        } catch (Throwable unused) {
            Log.d("KSAdSDK", "OADIDSDKHelper:oaid sdk not find ");
            mIsRequestIng = false;
            sGetOaidFail = true;
        }
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        sGetOaidFail = true;
        return true;
    }

    public static /* synthetic */ boolean access$102(boolean z) {
        mIsRequestIng = false;
        return false;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean isSupport() {
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.NewOAIDSDKHelper.1
                public void onSupport(IdSupplier idSupplier) {
                }
            }.onSupport(null);
            try {
                Log.d("KSAdSDK", "OADIDSDKHelper:oaidVersion" + e.a());
                try {
                    Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, NewOAIDSDKHelper.class.getClassLoader());
                    return true;
                } catch (Throwable unused) {
                    Log.d("KSAdSDK", "OADIDSDKHelper:com.bun.miitmdid.core.MdidSdkHelper oaid sdk not find ");
                    return false;
                }
            } catch (Throwable unused2) {
                Log.d("KSAdSDK", "OADIDSDKHelper:oaidVersion fail");
                return false;
            }
        } catch (Throwable unused3) {
            Log.d("KSAdSDK", "OADIDSDKHelper:isSupport oaid sdk not find ");
            return false;
        }
    }
}

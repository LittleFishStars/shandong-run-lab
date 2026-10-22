package com.ipd.dsp;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.ipd.dsp.api.DspLoadManager;
import com.ipd.dsp.api.IDsp;
import com.ipd.dsp.internal.a.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class Dsp {
    private static Context mOriginalAppContext;
    private static final AtomicBoolean sInit = new AtomicBoolean(false);
    private static IDsp sSdk;

    @Keep
    public static String getAppId() {
        IDsp iDsp = sSdk;
        if (iDsp != null) {
            return iDsp.getAppId();
        }
        return null;
    }

    private static Context getApplicationContext(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    @Nullable
    @Keep
    public static Context getContext() {
        return mOriginalAppContext;
    }

    @Nullable
    @Keep
    public static synchronized DspLoadManager getLoadManager() {
        IDsp iDsp = sSdk;
        if (iDsp == null) {
            return null;
        }
        return iDsp.getAdManager();
    }

    @Keep
    public static String getSDKVersion() {
        return a.f38173a;
    }

    @Keep
    public static synchronized boolean init(Context context, DspConfig dspConfig) {
        try {
            mOriginalAppContext = getApplicationContext(context);
            try {
                if (sSdk == null) {
                    sSdk = com.ipd.dsp.internal.l1.a.a();
                }
                sSdk.init(context, dspConfig);
            } catch (Throwable th) {
                Log.w("Dsp", th);
            }
            sInit.set(sSdk != null);
        } catch (Throwable th2) {
            Log.w("Dsp", th2);
            sInit.set(false);
        }
        return sInit.get();
    }

    @Keep
    public static boolean isDebugLogEnable() {
        IDsp iDsp = sSdk;
        return iDsp != null && iDsp.isDebug();
    }

    @Keep
    public static void setPersonalRecommend(boolean z) {
        IDsp iDsp = sSdk;
        if (iDsp != null) {
            iDsp.setPersonalRecommend(z);
        }
    }

    @Keep
    public static void setProgrammaticRecommend(boolean z) {
        IDsp iDsp = sSdk;
        if (iDsp != null) {
            iDsp.setProgrammaticRecommend(z);
        }
    }
}

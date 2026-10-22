package com.kc.dw.platform.csjblend;

import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.SsdAdConfig;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCBInitConfig extends MediationCustomInitLoader {
    private static final String TAG = "MsCBInitConfig";
    private static SsdAdConfig.CustomController customController = null;
    private static boolean enableBootId = true;
    private static boolean enableInstallBroadcast = true;
    private static boolean enableOaid = true;
    private static boolean enablePersonalRecommend = true;

    public static void setCustomController(SsdAdConfig.CustomController customController2) {
        customController = customController2;
    }

    public static void setEnableBootId(boolean z) {
        enableBootId = z;
    }

    public static void setEnableInstallBroadcast(boolean z) {
        enableInstallBroadcast = z;
    }

    public static void setEnableOaid(boolean z) {
        enableOaid = z;
    }

    public static void setEnablePersonalRecommend(boolean z) {
        enablePersonalRecommend = z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader
    public String getNetworkSdkVersion() {
        return AdSdk.getVersionName();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader
    public void initializeADN(Context context, MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map) {
        SsdAdConfig.Builder builderDownloadConfirm = new SsdAdConfig.Builder().appId(mediationCustomInitConfig.getAppId()).enableOaid(enableOaid).enableInstallBroadcast(enableInstallBroadcast).enableSdkPersonalRecommend(enablePersonalRecommend).enableBootId(enableBootId).enableDebug(true).downloadConfirm(1);
        SsdAdConfig.CustomController customController2 = customController;
        if (customController2 != null) {
            builderDownloadConfirm.customController(customController2);
        }
        AdSdk.init(context, builderDownloadConfirm.build());
        Log.i(LogUtil.getTag(TAG), "ms sdk init");
    }
}

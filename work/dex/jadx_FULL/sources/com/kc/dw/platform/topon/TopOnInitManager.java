package com.kc.dw.platform.topon;

import android.content.Context;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.MediationInitCallback;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.SsdAdConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class TopOnInitManager extends ATInitMediation {
    private static TopOnInitManager sInstance;
    private SsdAdConfig.CustomController customController;
    private boolean isInit;
    private boolean enableOaid = true;
    private boolean enableInstallBroadcast = true;
    private boolean enablePersonalRecommend = true;
    private boolean enableBootId = true;

    private TopOnInitManager() {
    }

    public static TopOnInitManager getInstance() {
        if (sInstance == null) {
            synchronized (TopOnInitManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new TopOnInitManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public String getNetworkName() {
        return "MS";
    }

    public String getNetworkVersion() {
        return AdSdk.getVersionName();
    }

    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        if (this.isInit) {
            mediationInitCallback.onSuccess();
            return;
        }
        SsdAdConfig.Builder builderDownloadConfirm = new SsdAdConfig.Builder().appId((String) map.get("app_id")).enableOaid(this.enableOaid).enableInstallBroadcast(this.enableInstallBroadcast).enableSdkPersonalRecommend(this.enablePersonalRecommend).enableBootId(this.enableBootId).enableDebug(true).downloadConfirm(1);
        SsdAdConfig.CustomController customController = this.customController;
        if (customController != null) {
            builderDownloadConfirm.customController(customController);
        }
        AdSdk.init(context, builderDownloadConfirm.build());
        this.isInit = true;
        mediationInitCallback.onSuccess();
    }

    public void setCustomController(SsdAdConfig.CustomController customController) {
        this.customController = customController;
    }

    public void setEnableBootId(boolean z) {
        this.enableBootId = z;
    }

    public void setEnableInstallBroadcast(boolean z) {
        this.enableInstallBroadcast = z;
    }

    public void setEnableOaid(boolean z) {
        this.enableOaid = z;
    }

    public void setEnablePersonalRecommend(boolean z) {
        this.enablePersonalRecommend = z;
    }
}

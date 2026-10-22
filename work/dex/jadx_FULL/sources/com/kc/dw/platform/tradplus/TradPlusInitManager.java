package com.kc.dw.platform.tradplus;

import android.content.Context;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.SsdAdConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class TradPlusInitManager {
    public static final String APPID = "appId";
    public static final String ECPM = "ecpm";
    public static final String PLACEMENTID = "placementId";
    private SsdAdConfig.CustomController customController;
    private boolean enableBootId;
    private boolean enableInstallBroadcast;
    private boolean enableOaid;
    private boolean enablePersonalRecommend;
    private boolean isInit;

    @Keep
    public interface InitCallback {
        void onError();

        void onSuccess();
    }

    @Keep
    public static class TradPlusInitManagerHolder {
        private static final TradPlusInitManager instance = new TradPlusInitManager();

        private TradPlusInitManagerHolder() {
        }
    }

    private TradPlusInitManager() {
        this.enableOaid = true;
        this.enableInstallBroadcast = true;
        this.enablePersonalRecommend = true;
        this.enableBootId = true;
    }

    public static TradPlusInitManager getInstance() {
        TradPlusInitManager tradPlusInitManager;
        synchronized (TradPlusInitManager.class) {
            try {
                tradPlusInitManager = TradPlusInitManagerHolder.instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tradPlusInitManager;
    }

    private void notifyError(InitCallback initCallback) {
        if (initCallback != null) {
            initCallback.onError();
        }
    }

    private void notifySuccess(InitCallback initCallback) {
        if (initCallback != null) {
            initCallback.onSuccess();
        }
    }

    public String getNetworkName() {
        return "SSD";
    }

    public void initSDK(Context context, Map<String, String> map, InitCallback initCallback) {
        try {
            if (this.isInit) {
                notifySuccess(initCallback);
                return;
            }
            SsdAdConfig.Builder builderDownloadConfirm = new SsdAdConfig.Builder().appId(map.get("appId")).enableOaid(this.enableOaid).enableInstallBroadcast(this.enableInstallBroadcast).enableSdkPersonalRecommend(this.enablePersonalRecommend).enableBootId(this.enableBootId).enableDebug(true).downloadConfirm(1);
            SsdAdConfig.CustomController customController = this.customController;
            if (customController != null) {
                builderDownloadConfirm.customController(customController);
            }
            AdSdk.init(context, builderDownloadConfirm.build());
            this.isInit = true;
            notifySuccess(initCallback);
        } catch (Exception e) {
            e.printStackTrace();
            notifyError(initCallback);
        }
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

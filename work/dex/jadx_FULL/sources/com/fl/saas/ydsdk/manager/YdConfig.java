package com.fl.saas.ydsdk.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.fl.saas.base.adapter.AdapterManager;
import com.fl.saas.base.bean.CustomLocation;
import com.fl.saas.base.cache.PreloadHelper;
import com.fl.saas.base.manager.AdPersonalizedManager;
import com.fl.saas.config.http.ResponseCall;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.OaidUtils;
import com.fl.saas.config.utils.SPUtil;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class YdConfig {
    private static boolean isInit = false;
    private int[] disableAppListAccessAdvs;

    public static final class Holder {
        private static final YdConfig INSTANCE = new YdConfig();

        private Holder() {
        }
    }

    private YdConfig() {
    }

    private YdParamConfig defaultConfig() {
        return new YdParamConfig.Builder().build();
    }

    public static YdConfig getInstance() {
        return Holder.INSTANCE;
    }

    private void initConfig(Context context, String str, String str2, String str3, YdParamConfig ydParamConfig, boolean z) {
        DeviceUtil.channelId = !TextUtils.isEmpty(str2) ? str2 : "";
        if (TextUtils.isEmpty(str3)) {
            str2 = "";
        }
        DeviceUtil.subChannel = str2;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        DeviceUtil.appId = str;
        StringBuilder sb = new StringBuilder();
        if (ydParamConfig != null) {
            DeviceUtil.isCanUseBootID = ydParamConfig.getBuilder().isCanUseBootID();
            sb.append("isCanUseBootID:");
            sb.append(DeviceUtil.isCanUseBootID);
            sb.append("\n");
            DeviceUtil.isCanUseSSID = ydParamConfig.getBuilder().isCanUseSSID();
            sb.append("isCanUseSSID:");
            sb.append(DeviceUtil.isCanUseSSID);
            sb.append("\n");
            DeviceUtil.isCanUseAndroid = ydParamConfig.getBuilder().isCanUseAndroid();
            sb.append("isCanUseAndroid:");
            sb.append(DeviceUtil.isCanUseAndroid);
            sb.append("\n");
            DeviceUtil.isCanUseIMEI = ydParamConfig.getBuilder().isCanUseIMEI();
            sb.append("isCanUseIMEI:");
            sb.append(DeviceUtil.isCanUseIMEI);
            sb.append("\n");
            DeviceUtil.isCanUseMac = ydParamConfig.getBuilder().isCanUseMac();
            DeviceUtil.isCanUseIP = ydParamConfig.getBuilder().isCanUseIP();
            sb.append("isCanUseMac:");
            sb.append(DeviceUtil.isCanUseMac);
            sb.append("\n");
            DeviceUtil.isCanUseIMSI = ydParamConfig.getBuilder().isCanUseIMSI();
            sb.append("isCanUseIMSI:");
            sb.append(DeviceUtil.isCanUseIMSI);
            sb.append("\n");
            DeviceUtil.isCanUseLocation = ydParamConfig.getBuilder().isCanUseLocation();
            DeviceUtil.isInitializeGDT = ydParamConfig.getBuilder().isInitializeGDT();
            DeviceUtil.isInitializeKS = ydParamConfig.getBuilder().isInitializeKS();
            DeviceUtil.isInitializeBD = ydParamConfig.getBuilder().isInitializeBD();
            DeviceUtil.isInitializeCSJ = ydParamConfig.getBuilder().isInitializeCSJ();
            DeviceUtil.isInitializeQTT = ydParamConfig.getBuilder().isInitializeQTT();
            DeviceUtil.sourceTag = ydParamConfig.getBuilder().getSourceTag();
            sb.append("isCanUseLocation:");
            sb.append(DeviceUtil.isCanUseLocation);
            sb.append("\n");
            sb.append("isCanUseOaid:");
            sb.append(ydParamConfig.getBuilder().isCanUseOaid());
            sb.append("\n");
            sb.append("isCanUseSensor:");
            sb.append(ydParamConfig.getBuilder().isCanUseSensor());
            sb.append("\n");
            sb.append("customUserAgent:");
            sb.append(ydParamConfig.getBuilder().getCustomUserAgent());
            sb.append("\n");
            sb.append("customIMEI:");
            sb.append(ydParamConfig.getBuilder().getCustomIMEI());
            sb.append("\n");
            sb.append("customOAID:");
            sb.append(ydParamConfig.getBuilder().getCustomOAID());
            sb.append("\n");
            sb.append("customAndroidId:");
            sb.append(ydParamConfig.getBuilder().getCustomAndroidId());
            sb.append("\n");
            sb.append("customMac:");
            sb.append(ydParamConfig.getBuilder().getCustomMac());
            sb.append("\n");
            sb.append("customLocation:");
            sb.append(ydParamConfig.getBuilder().getCustomLocation());
            sb.append("\n");
            String string = sb.toString();
            DeviceUtil.customConfig = string;
            LogcatUtil.d(string);
            if (!TextUtils.isEmpty(ydParamConfig.getBuilder().getCustomIMEI())) {
                DeviceUtil.deviceImei = ydParamConfig.getBuilder().getCustomIMEI();
                DeviceUtil.isGetImei = true;
            }
            if (!TextUtils.isEmpty(ydParamConfig.getBuilder().getCustomAndroidId())) {
                DeviceUtil.deviceAndroidID = ydParamConfig.getBuilder().getCustomAndroidId();
                DeviceUtil.isGetAndroidID = true;
            }
            if (!TextUtils.isEmpty(ydParamConfig.getBuilder().getCustomMac())) {
                DeviceUtil.deviceMac = ydParamConfig.getBuilder().getCustomMac();
                DeviceUtil.isGetMac = true;
            }
            if (!TextUtils.isEmpty(ydParamConfig.getBuilder().getCustomUserAgent())) {
                DeviceUtil.userAgent = ydParamConfig.getBuilder().getCustomUserAgent();
            }
            DeviceUtil.customLocation = ydParamConfig.getBuilder().getCustomLocation();
            LogcatUtil.isDebug = z;
            boolean zIsCanUseSensor = ydParamConfig.getBuilder().isCanUseSensor();
            DeviceUtil.isCanUseSensor = zIsCanUseSensor;
            if (!zIsCanUseSensor) {
                DeviceUtil.deviceHasAccelerometerSensor = false;
            }
            if (!ydParamConfig.getBuilder().isCanUseOaid()) {
                OaidUtils.setIsCanUseOAID(false);
                String customOAID = ydParamConfig.getBuilder().getCustomOAID();
                OaidUtils.setOaid(customOAID != null ? customOAID : "");
            }
        }
        DeviceUtil.setContext(context.getApplicationContext());
        ResponseCall.setContext(context.getApplicationContext());
        SPUtil.getInstance().init(context.getApplicationContext());
        DeviceUtil.initUserAgent();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.j7a
                @Override // java.lang.Runnable
                public final void run() {
                    AdapterManager.preInitAdapter();
                }
            });
        } else {
            AdapterManager.preInitAdapter();
        }
    }

    public static boolean isInit() {
        return isInit;
    }

    public void disableAppListAccess(int... iArr) {
        this.disableAppListAccessAdvs = iArr;
    }

    public boolean hasDisableAppListAccess() {
        int[] iArr = this.disableAppListAccessAdvs;
        return iArr != null && iArr.length > 0;
    }

    public void init(Context context, String str) {
        init(context, str, "", "", defaultConfig(), false);
    }

    public void init(Context context, String str, YdParamConfig ydParamConfig) {
        if (ydParamConfig != null) {
            init(context, str, "", "", ydParamConfig, false);
        } else {
            init(context, str, "", "", defaultConfig(), false);
        }
    }

    public void init(Context context, String str, YdParamConfig ydParamConfig, boolean z) {
        if (ydParamConfig != null) {
            init(context, str, "", "", ydParamConfig, z);
        } else {
            init(context, str, "", "", defaultConfig(), z);
        }
    }

    public void init(Context context, String str, String str2) {
        init(context, str, str2, "", defaultConfig(), false);
    }

    public void init(Context context, String str, String str2, YdParamConfig ydParamConfig, boolean z) {
        if (ydParamConfig != null) {
            init(context, str, str2, "", ydParamConfig, z);
        } else {
            init(context, str, str2, "", defaultConfig(), z);
        }
    }

    public void init(Context context, String str, String str2, String str3) {
        init(context, str, str2, str3, defaultConfig(), false);
    }

    public void init(Context context, String str, String str2, String str3, YdParamConfig ydParamConfig, boolean z) {
        if (isInit || context == null) {
            return;
        }
        try {
            initConfig(context, str, str2, str3, ydParamConfig, z);
            isInit = true;
        } catch (Exception unused) {
        }
    }

    public void init(Context context, String str, String str2, String str3, boolean z) {
        init(context, str, str2, str3, defaultConfig(), z);
    }

    public void init(Context context, String str, String str2, boolean z) {
        init(context, str, str2, "", defaultConfig(), z);
    }

    public boolean isAppListAccessEnabled(int i) {
        int[] iArr = this.disableAppListAccessAdvs;
        if (iArr == null) {
            return true;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return false;
            }
        }
        return true;
    }

    public void setActivityAndPreloadAd(Activity activity) {
        if (activity != null) {
            PreloadHelper.getInstance().setPreLoadContext(activity);
            PreloadHelper.getInstance().requestPreloadAd();
        }
    }

    public void setCustomLocation(CustomLocation customLocation) {
        DeviceUtil.customLocation = customLocation;
    }

    public void setCustomMap(Map<String, Object> map) {
        if (map != null) {
            DeviceUtil.customMap.clear();
            DeviceUtil.customMap.putAll(map);
        }
    }

    public void setEnableCollectAppInstallStatus(boolean z) {
        DeviceUtil.enableCollectAppInstallStatus = z;
    }

    public void setPersonalizedState(boolean z) {
        AdPersonalizedManager.updateAdPersonalizedConfig(z);
    }

    public void setUserExt(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        DeviceUtil.userExt = str;
    }
}

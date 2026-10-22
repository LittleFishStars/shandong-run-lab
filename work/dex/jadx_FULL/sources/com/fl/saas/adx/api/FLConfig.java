package com.fl.saas.adx.api;

import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.F0;
import com.fl.saas.S0;
import com.fl.saas.adx.base.bean.CustomLocation;
import com.fl.saas.adx.base.manager.AdPersonalizedManager;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import com.fl.saas.adx.util.OaidUtils;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class FLConfig {
    private static boolean hasInit = false;
    private int[] disableAppListAccessAdvs;

    public static final class Holder {
        private static final FLConfig INSTANCE = new FLConfig();

        private Holder() {
        }
    }

    private FLConfig() {
    }

    private FLParamConfig defaultConfig() {
        return new FLParamConfig.Builder().build();
    }

    public static FLConfig getInstance() {
        return Holder.INSTANCE;
    }

    private void initConfig(Context context, String str, String str2, String str3, FLParamConfig fLParamConfig, boolean z) {
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
        if (fLParamConfig != null) {
            DeviceUtil.isCanUseBootID = fLParamConfig.getBuilder().isCanUseBootID();
            sb.append("isCanUseBootID:");
            sb.append(DeviceUtil.isCanUseBootID);
            sb.append("\n");
            DeviceUtil.isCanUseSSID = fLParamConfig.getBuilder().isCanUseSSID();
            sb.append("isCanUseSSID:");
            sb.append(DeviceUtil.isCanUseSSID);
            sb.append("\n");
            DeviceUtil.isCanUseAndroid = fLParamConfig.getBuilder().isCanUseAndroid();
            sb.append("isCanUseAndroid:");
            sb.append(DeviceUtil.isCanUseAndroid);
            sb.append("\n");
            DeviceUtil.isCanUseIMEI = fLParamConfig.getBuilder().isCanUseIMEI();
            sb.append("isCanUseIMEI:");
            sb.append(DeviceUtil.isCanUseIMEI);
            sb.append("\n");
            DeviceUtil.isCanUseMac = fLParamConfig.getBuilder().isCanUseMac();
            sb.append("isCanUseMac:");
            sb.append(DeviceUtil.isCanUseMac);
            sb.append("\n");
            DeviceUtil.isCanUseIMSI = fLParamConfig.getBuilder().isCanUseIMSI();
            sb.append("isCanUseIMSI:");
            sb.append(DeviceUtil.isCanUseIMSI);
            sb.append("\n");
            DeviceUtil.isCanUseLocation = fLParamConfig.getBuilder().isCanUseLocation();
            DeviceUtil.isInitializeGDT = fLParamConfig.getBuilder().isInitializeGDT();
            DeviceUtil.isInitializeKS = fLParamConfig.getBuilder().isInitializeKS();
            DeviceUtil.isInitializeBD = fLParamConfig.getBuilder().isInitializeBD();
            DeviceUtil.isInitializeCSJ = fLParamConfig.getBuilder().isInitializeCSJ();
            DeviceUtil.isInitializeQTT = fLParamConfig.getBuilder().isInitializeQTT();
            DeviceUtil.sourceTag = fLParamConfig.getBuilder().getSourceTag();
            sb.append("isCanUseLocation:");
            sb.append(DeviceUtil.isCanUseLocation);
            sb.append("\n");
            sb.append("isCanUseOaid:");
            sb.append(fLParamConfig.getBuilder().isCanUseOaid());
            sb.append("\n");
            sb.append("isCanUseSensor:");
            sb.append(fLParamConfig.getBuilder().isCanUseSensor());
            sb.append("\n");
            sb.append("customUserAgent:");
            sb.append(fLParamConfig.getBuilder().getCustomUserAgent());
            sb.append("\n");
            sb.append("customIMEI:");
            sb.append(fLParamConfig.getBuilder().getCustomIMEI());
            sb.append("\n");
            sb.append("customOAID:");
            sb.append(fLParamConfig.getBuilder().getCustomOAID());
            sb.append("\n");
            sb.append("customAndroidId:");
            sb.append(fLParamConfig.getBuilder().getCustomAndroidId());
            sb.append("\n");
            sb.append("customMac:");
            sb.append(fLParamConfig.getBuilder().getCustomMac());
            sb.append("\n");
            sb.append("customLocation:");
            sb.append(fLParamConfig.getBuilder().getCustomLocation());
            sb.append("\n");
            String string = sb.toString();
            DeviceUtil.customConfig = string;
            LogcatUtil.e(string);
            if (!TextUtils.isEmpty(fLParamConfig.getBuilder().getCustomIMEI())) {
                DeviceUtil.deviceImei = fLParamConfig.getBuilder().getCustomIMEI();
                DeviceUtil.isGetImei = true;
            }
            if (!TextUtils.isEmpty(fLParamConfig.getBuilder().getCustomAndroidId())) {
                DeviceUtil.deviceAndroidID = fLParamConfig.getBuilder().getCustomAndroidId();
                DeviceUtil.isGetAndroidID = true;
            }
            if (!TextUtils.isEmpty(fLParamConfig.getBuilder().getCustomMac())) {
                DeviceUtil.deviceMac = fLParamConfig.getBuilder().getCustomMac();
                DeviceUtil.isGetMac = true;
            }
            if (!TextUtils.isEmpty(fLParamConfig.getBuilder().getCustomUserAgent())) {
                DeviceUtil.userAgent = fLParamConfig.getBuilder().getCustomUserAgent();
            }
            DeviceUtil.customLocation = fLParamConfig.getBuilder().getCustomLocation();
            LogcatUtil.isDebug = z;
            boolean zIsCanUseSensor = fLParamConfig.getBuilder().isCanUseSensor();
            DeviceUtil.isCanUseSensor = zIsCanUseSensor;
            if (!zIsCanUseSensor) {
                DeviceUtil.deviceHasAccelerometerSensor = false;
            }
            if (!fLParamConfig.getBuilder().isCanUseOaid()) {
                OaidUtils.setIsCanUseOAID(false);
                String customOAID = fLParamConfig.getBuilder().getCustomOAID();
                OaidUtils.setOaid(customOAID != null ? customOAID : "");
            }
        }
        if (hasInit) {
            return;
        }
        DeviceUtil.setContext(context.getApplicationContext());
        F0.a(context.getApplicationContext());
        S0.a().a(context.getApplicationContext());
        DeviceUtil.initUserAgent();
        hasInit = true;
    }

    public static boolean isInit() {
        return hasInit;
    }

    public void disableAppListAccess(int... iArr) {
        this.disableAppListAccessAdvs = iArr;
    }

    public String getSdkVersion() {
        return CommConstant.SdkVersion.SDK_VERSION_VALUE;
    }

    public boolean hasDisableAppListAccess() {
        int[] iArr = this.disableAppListAccessAdvs;
        return iArr != null && iArr.length > 0;
    }

    public void init(Context context, String str) {
        init(context, str, "", "", defaultConfig(), false);
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

    public void init(Context context, String str, FLParamConfig fLParamConfig) {
        if (fLParamConfig != null) {
            init(context, str, "", "", fLParamConfig, false);
        } else {
            init(context, str, "", "", defaultConfig(), false);
        }
    }

    public void init(Context context, String str, FLParamConfig fLParamConfig, boolean z) {
        if (fLParamConfig != null) {
            init(context, str, "", "", fLParamConfig, z);
        } else {
            init(context, str, "", "", defaultConfig(), z);
        }
    }

    public void init(Context context, String str, String str2) {
        init(context, str, str2, "", defaultConfig(), false);
    }

    public void init(Context context, String str, String str2, FLParamConfig fLParamConfig, boolean z) {
        if (fLParamConfig != null) {
            init(context, str, str2, "", fLParamConfig, z);
        } else {
            init(context, str, str2, "", defaultConfig(), z);
        }
    }

    public void init(Context context, String str, String str2, String str3) {
        init(context, str, str2, str3, defaultConfig(), false);
    }

    public void init(Context context, String str, String str2, String str3, FLParamConfig fLParamConfig, boolean z) {
        try {
            initConfig(context, str, str2, str3, fLParamConfig, z);
        } catch (Exception unused) {
        }
    }

    public void init(Context context, String str, String str2, String str3, boolean z) {
        init(context, str, str2, str3, defaultConfig(), z);
    }

    public void init(Context context, String str, String str2, boolean z) {
        init(context, str, str2, "", defaultConfig(), z);
    }
}

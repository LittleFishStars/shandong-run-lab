package com.fl.saas.fl.config;

import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.adx.api.FLConfig;
import com.fl.saas.adx.api.FLParamConfig;
import com.fl.saas.base.adapter.AdapterPreInitialize;
import com.fl.saas.base.bean.CustomLocation;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.SPUtil;
import com.fl.spi.SPI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SPI({AdapterPreInitialize.class})
public class FlAdManagerHolder implements AdapterPreInitialize {
    private static String flAppId = "";
    private static boolean isInit = false;

    public static void init(Context context, String str) {
        try {
            String string = SPUtil.getInstance().getString("fl_id", "");
            flAppId = string;
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                isInit = false;
            } else if (TextUtils.isEmpty(flAppId)) {
                flAppId = str;
            } else if (!flAppId.equals(str)) {
                flAppId = str;
                isInit = false;
            }
            if (isInit) {
                return;
            }
            LogcatUtil.d("preInit" + flAppId);
            SPUtil.getInstance().putString("fl_id", flAppId);
            FLConfig.getInstance().setCustomMap(DeviceUtil.customMap);
            FLConfig.getInstance().setPersonalizedState(DeviceUtil.personalizedState);
            FLConfig.getInstance().setEnableCollectAppInstallStatus(DeviceUtil.enableCollectAppInstallStatus);
            CustomLocation customLocation = DeviceUtil.customLocation;
            FLConfig.getInstance().init(context, flAppId, DeviceUtil.channelId, new FLParamConfig.Builder().setCustomLocation(customLocation != null ? new com.fl.saas.adx.base.bean.CustomLocation(customLocation.getLat(), DeviceUtil.customLocation.getLng()) : null).setCanUseAndroid(DeviceUtil.isCanUseAndroid).setCustomAndroidId(DeviceUtil.getAndroidID()).setCanUseMac(DeviceUtil.isCanUseMac).setCustomMac(DeviceUtil.getMacAddress()).setCanUseIMEI(DeviceUtil.isCanUseIMEI).setCustomIMEI(DeviceUtil.getImei()).setCanUseIMSI(DeviceUtil.isCanUseIMSI).setCanUseBootID(DeviceUtil.isCanUseBootID).setCanUseLocation(DeviceUtil.isCanUseLocation).build(), LogcatUtil.isDebug);
            isInit = true;
            LogcatUtil.d("YdSDK-FL", "init");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.fl.saas.base.adapter.AdapterPreInitialize
    public void preInit(Context context) {
        init(context, "");
    }
}

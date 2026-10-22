package com.kc.dw.gather.bd;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.BDDialogParams;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.kc.dw.base.a;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.SsdAdConfig;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BDInitManager extends CustomInitLoader {
    private static final String TAG = "BDInitManager";

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public String getPlatform() {
        return "BAIDU";
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public String getVersionName() {
        return AdSdk.getBDVersionName();
    }

    @Override // com.kc.dw.platform.custom.CustomInitLoader
    public void initADN(String str, String str2, Map<String, Object> map) {
        try {
            LogUtil.d(TAG, "bd init---------------");
            if (a.adConfig().getCanUseSdkPersonalRecommend()) {
                MobadsPermissionSettings.setLimitPersonalAds(false);
            } else {
                MobadsPermissionSettings.setLimitPersonalAds(true);
            }
            try {
                SsdAdConfig.CustomController customController = a.adConfig().customController();
                if (customController != null) {
                    MobadsPermissionSettings.setPermissionReadDeviceID(customController.isCanUsePhoneState());
                    MobadsPermissionSettings.setPermissionLocation(customController.isCanUseLocation());
                    MobadsPermissionSettings.setPermissionStorage(customController.canUseStoragePermission());
                    MobadsPermissionSettings.setPermissionAppList(customController.canReadInstalledPackages());
                } else {
                    MobadsPermissionSettings.setPermissionReadDeviceID(true);
                    MobadsPermissionSettings.setPermissionLocation(true);
                    MobadsPermissionSettings.setPermissionStorage(true);
                    MobadsPermissionSettings.setPermissionAppList(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            BDAdConfig.Builder dialogParams = new BDAdConfig.Builder().setAppsid(str).setDialogParams(new BDDialogParams.Builder().setDlDialogType(0).setDlDialogAnimStyle(0).build());
            try {
                if (!a.adConfig().enableInstallBroadcast()) {
                    dialogParams.putExtraParam("pk_change_rc", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).putExtraParam("mi market rc", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            dialogParams.build(a.getContext()).init();
            callInitSucc();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

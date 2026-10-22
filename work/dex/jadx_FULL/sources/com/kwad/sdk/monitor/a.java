package com.kwad.sdk.monitor;

import android.text.TextUtils;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class a {
    public static void d(SdkConfig sdkConfig) {
        if (sdkConfig == null) {
            return;
        }
        MediaMessageInfo.MediaPermissionInfo mediaPermissionInfo = new MediaMessageInfo.MediaPermissionInfo();
        KsCustomController ksCustomController = sdkConfig.ksCustomController;
        if (ksCustomController != null) {
            if (ksCustomController.canReadLocation()) {
                mediaPermissionInfo.canReadLocation = 1;
            }
            if (sdkConfig.ksCustomController.getLocation() != null) {
                mediaPermissionInfo.getLocation = 1;
            }
            if (sdkConfig.ksCustomController.getKsLocation() != null) {
                mediaPermissionInfo.getKsLocation = 1;
            }
            if (sdkConfig.ksCustomController.canUsePhoneState()) {
                mediaPermissionInfo.canUsePhoneState = 1;
            }
            if (!TextUtils.isEmpty(sdkConfig.ksCustomController.getImei())) {
                mediaPermissionInfo.getImei = 1;
            }
            if (sdkConfig.ksCustomController.getImeis() != null) {
                mediaPermissionInfo.getImeis = 1;
            }
            if (!TextUtils.isEmpty(sdkConfig.ksCustomController.getAndroidId())) {
                mediaPermissionInfo.getAndroidId = 1;
            }
            if (sdkConfig.ksCustomController.canUseOaid()) {
                mediaPermissionInfo.canUseOaid = 1;
            }
            if (!TextUtils.isEmpty(sdkConfig.ksCustomController.getOaid())) {
                mediaPermissionInfo.getOaid = 1;
            }
            if (sdkConfig.ksCustomController.canUseMacAddress()) {
                mediaPermissionInfo.canUseMacAddress = 1;
            }
            if (!TextUtils.isEmpty(sdkConfig.ksCustomController.getMacAddress())) {
                mediaPermissionInfo.getMacAddress = 1;
            }
            if (sdkConfig.ksCustomController.canUseNetworkState()) {
                mediaPermissionInfo.canUseNetworkState = 1;
            }
            if (sdkConfig.ksCustomController.canUseStoragePermission()) {
                mediaPermissionInfo.canUseStoragePermission = 1;
            }
            if (sdkConfig.ksCustomController.canReadInstalledPackages()) {
                mediaPermissionInfo.canReadInstalledPackages = 1;
            }
            if (sdkConfig.ksCustomController.getInstalledPackages() != null) {
                mediaPermissionInfo.getInstalledPackages = 1;
            }
        }
        if (sdkConfig.canReadMacAddress()) {
            mediaPermissionInfo.canReadMacAddress = 1;
        }
        if (sdkConfig.canReadNearbyWifiList()) {
            mediaPermissionInfo.canReadNearbyWifiList = 1;
        }
        if (sdkConfig.canReadICCID()) {
            mediaPermissionInfo.canReadICCID = 1;
        }
        c.f((com.kwad.sdk.commercial.c.a) MediaMessageInfo.Sw().hh(bt.WM()).hi(mediaPermissionInfo.toJson().toString()).hj(ServiceProvider.getAppId()).fi(2), false);
    }
}

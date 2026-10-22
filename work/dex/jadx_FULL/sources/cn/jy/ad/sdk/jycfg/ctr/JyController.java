package cn.jy.ad.sdk.jycfg.ctr;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface JyController {
    String getAndroidId();

    String getImei();

    List<String> getInstalledPackages();

    String getIp();

    JyLocation getLocation();

    String getMacAddress();

    String getOaid();

    @Deprecated
    boolean isCanReadInstalledPackages();

    boolean isCanUseAndroidId();

    @Deprecated
    boolean isCanUseIp();

    boolean isCanUseLocation();

    boolean isCanUseNetworkState();

    boolean isCanUseOaid();

    boolean isCanUsePermissionRecordAudio();

    boolean isCanUsePhoneState();

    boolean isCanUseSensorManager();

    boolean isCanUseStoragePermission();

    boolean isCanUseWifiState();
}

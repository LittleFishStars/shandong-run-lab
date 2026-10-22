package cn.jy.ad.sdk.jyinter;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface NativeADAppMiitInfo {
    String getAppName();

    long getAppPackageSize();

    String getAppVersion();

    String getDescriptionUrl();

    String getDeveloperName();

    String getIcpNumber();

    String getPermissionsInfo();

    Map<String, String> getPermissionsMap();

    String getPermissionsUrl();

    String getPrivacyUrl();
}

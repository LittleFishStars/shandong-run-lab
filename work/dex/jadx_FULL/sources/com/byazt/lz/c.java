package com.byazt.lz;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface c {
    boolean alist();

    String getAndroidId();

    String getDevImei();

    String getDevOaid();

    String getMacAddress();

    da getMediationPrivacyConfig();

    uj getTTLocation();

    boolean isCanUseAndroidId();

    boolean isCanUseLocation();

    boolean isCanUseMessage();

    boolean isCanUsePermissionRecordAudio();

    boolean isCanUsePhoneState();

    boolean isCanUseWifiState();

    boolean isCanUseWriteExternal();

    Map<String, Object> userPrivacyConfig();
}

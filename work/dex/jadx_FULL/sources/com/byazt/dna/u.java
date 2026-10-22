package com.byazt.dna;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface u {
    String getActiveSimOperatorStr();

    String getAndroidId();

    String getAsyncWifiMac();

    String getBoot();

    String getBuildSerial();

    String getCarrierName();

    String getCompilingTime();

    String getDeviceModel();

    String getDeviceName();

    int getDeviceType(boolean z);

    int getDisplayDpi();

    String getEmuiInfo();

    String getImei(Boolean bool);

    String getImsi(Boolean bool);

    Map<String, String> getIpInfoMap(boolean z);

    String getLanguage();

    String getLocalLanguage();

    com.byazt.fn.c getLocation(boolean z);

    String getMacAddress(Boolean bool);

    String getMcc();

    String getMcc2();

    String getMnc();

    String getMnc2();

    String getNetworkSignalType(int i);

    String[] getNewIpAddrs(boolean z);

    int getOs();

    String getOsVersion();

    int getRealNetworkType(long j);

    String getRom();

    String getRomInfo();

    String getSSID(Boolean bool);

    float getScreenBright();

    int getScreenHeight();

    int getScreenWidth();

    String getSimOperator();

    String getSimOperatorCode();

    String getTimeZone();

    int getTimeZoneInt();

    long getUnlockTime();

    String getUserAgent();

    String getVendor();

    String getWebViewUA(boolean z);

    String getWifiMac(Boolean bool);

    boolean isScreenOn();

    void registerNetworkMonitor(com.byazt.fn.ve veVar);

    void removeNetworkMonitor(com.byazt.fn.ve veVar);
}

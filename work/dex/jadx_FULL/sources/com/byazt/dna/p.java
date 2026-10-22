package com.byazt.dna;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Deprecated
public interface p {
    String getAndroidId();

    String getAppLogDid();

    String getBoot();

    String getBuildSerial();

    String getCarrierName();

    String getCompilingTime();

    int getConnType();

    String getDeviceModel();

    String getDeviceName();

    int getDeviceType(boolean z);

    String getDisplayDensity();

    int getDisplayDpi();

    String getImei(Boolean bool);

    String getImsi(Boolean bool);

    String getIpv4();

    String getIpv6();

    String getLanguage();

    String getLocalLanguage();

    com.byazt.fn.c getLocation();

    String getMacAddress(Boolean bool);

    String getMcc();

    String getMcc2();

    String getMnc();

    String getMnc2();

    String[] getNewIpAddrs(boolean z);

    String getOAID(boolean z);

    int getOs();

    String getOsVersion();

    String getRom();

    String getRomInfo();

    String getSSID(Boolean bool);

    int getScreenHeight();

    int getScreenWidth();

    String getTimeZone();

    int getTimeZoneInt();

    String getTotalMem();

    String getTotalSpace();

    String getUUId();

    String getUserAgent();

    String getVendor();

    String getWebViewUA();

    String getWifiMac(Boolean bool);
}

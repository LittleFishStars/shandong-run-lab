package com.beizi.fusion;

import com.beizi.ad.model.BeiZiLocation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class BeiZiCustomController {
    public boolean forbidSensor() {
        return false;
    }

    public String getAndroidId() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public BeiZiLocation getLocation() {
        return null;
    }

    public String getOaidVersion() {
        return null;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseAppList() {
        return true;
    }

    public boolean isCanUseGaid() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseOaid() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }
}

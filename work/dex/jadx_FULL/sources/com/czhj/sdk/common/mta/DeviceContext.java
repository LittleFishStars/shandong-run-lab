package com.czhj.sdk.common.mta;

import android.location.Location;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class DeviceContext {
    public boolean allowReadSpaceSize() {
        return true;
    }

    public String getAndroidId() {
        return null;
    }

    public String getCarrier() {
        return null;
    }

    public String getCarrierName() {
        return null;
    }

    public String getImei() {
        return null;
    }

    public String getImei1() {
        return null;
    }

    public String getImei2() {
        return null;
    }

    public Location getLocation() {
        return null;
    }

    public String getOaid() {
        return null;
    }

    public boolean isCustomAndroidId() {
        return false;
    }

    public boolean isCustomOaId() {
        return false;
    }

    public boolean isCustomOperatorCode() {
        return false;
    }

    public boolean isCustomOperatorName() {
        return false;
    }

    public boolean isCustomPhoneState() {
        return false;
    }
}

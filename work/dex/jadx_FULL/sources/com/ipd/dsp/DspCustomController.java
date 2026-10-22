package com.ipd.dsp;

import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DspCustomController {
    @Nullable
    @Keep
    public List<Integer> availablePackageIds() {
        return Collections.EMPTY_LIST;
    }

    @Keep
    public boolean canReadInstalledPackages() {
        return true;
    }

    @Keep
    public boolean canReadLocation() {
        return true;
    }

    @Keep
    public boolean canUseAndroidId() {
        return true;
    }

    @Keep
    public boolean canUseBootId() {
        return true;
    }

    @Keep
    public boolean canUseMacAddress() {
        return true;
    }

    @Keep
    public boolean canUseNetworkState() {
        return true;
    }

    @Keep
    public boolean canUseOAID() {
        return true;
    }

    @Keep
    public boolean canUsePhoneState() {
        return true;
    }

    @Keep
    public boolean canUseSensor() {
        return true;
    }

    @Keep
    public boolean canUseSimOperator() {
        return true;
    }

    @Keep
    public String getAndroidId() {
        return "";
    }

    @Keep
    public String getImei() {
        return "";
    }

    @Keep
    public String[] getImeis() {
        return null;
    }

    @Keep
    public List<String> getInstalledPackages() {
        return null;
    }

    @Keep
    public Pair<Double, Double> getLocationPair() {
        return null;
    }

    @Keep
    public String getMacAddress() {
        return "";
    }

    @Keep
    public String getOaid() {
        return "";
    }

    @Keep
    public String getSimOperatorCode() {
        return "";
    }
}

package cj.mobile.wm.common.bean;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MediationAppCfg {

    @SerializedName("a6")
    public int cacheDuration;

    @SerializedName("a1")
    public int checkInstalledStatus;

    @SerializedName("a7")
    public int checkMaxLimit;

    @SerializedName("a2")
    public int recheckDuration;

    public int getCacheDuration() {
        return this.cacheDuration;
    }

    public int getCheckInstalledStatus() {
        return this.checkInstalledStatus;
    }

    public int getCheckMaxLimit() {
        return this.checkMaxLimit;
    }

    public int getRecheckDuration() {
        return this.recheckDuration;
    }

    public void setCacheDuration(int i) {
        this.cacheDuration = i;
    }

    public void setCheckInstalledStatus(int i) {
        this.checkInstalledStatus = i;
    }

    public void setCheckMaxLimit(int i) {
        this.checkMaxLimit = i;
    }

    public void setRecheckDuration(int i) {
        this.recheckDuration = i;
    }
}

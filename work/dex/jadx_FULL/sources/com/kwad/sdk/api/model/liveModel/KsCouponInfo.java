package com.kwad.sdk.api.model.liveModel;

import androidx.annotation.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Keep
public class KsCouponInfo implements Serializable {
    private static final long serialVersionUID = 2072285066847893997L;
    private String displayBase;
    private String displayType;
    private String displayValue;
    private String endFetchTime;
    private String startFetchTime;

    public String getDisplayBase() {
        return this.displayBase;
    }

    public String getDisplayType() {
        return this.displayType;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    public String getEndFetchTime() {
        return this.endFetchTime;
    }

    public String getStartFetchTime() {
        return this.startFetchTime;
    }

    public void setDisplayBase(String str) {
        this.displayBase = str;
    }

    public void setDisplayType(String str) {
        this.displayType = str;
    }

    public void setDisplayValue(String str) {
        this.displayValue = str;
    }

    public void setEndFetchTime(String str) {
        this.endFetchTime = str;
    }

    public void setStartFetchTime(String str) {
        this.startFetchTime = str;
    }

    public String toString() {
        return "KsCouponInfo{displayType='" + this.displayType + "', displayBase='" + this.displayBase + "', displayValue='" + this.displayValue + "', startFetchTime='" + this.startFetchTime + "', endFetchTime='" + this.endFetchTime + "'}";
    }
}

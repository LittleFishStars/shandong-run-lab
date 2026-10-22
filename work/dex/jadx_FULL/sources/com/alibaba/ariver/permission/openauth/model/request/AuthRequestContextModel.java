package com.alibaba.ariver.permission.openauth.model.request;

import androidx.annotation.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public final class AuthRequestContextModel {
    private Map<String, String> ctuExtInfo;
    private String currentLongitudeAndLatitude;
    private String terminalType;

    public Map<String, String> getCtuExtInfo() {
        return this.ctuExtInfo;
    }

    public String getCurrentLongitudeAndLatitude() {
        return this.currentLongitudeAndLatitude;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public void setCtuExtInfo(Map<String, String> map) {
        this.ctuExtInfo = map;
    }

    public void setCurrentLongitudeAndLatitude(String str) {
        this.currentLongitudeAndLatitude = str;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }
}

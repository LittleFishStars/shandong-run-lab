package com.alibaba.triver.utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ErrorLogInfo extends LogInfo {
    public String errorCode;
    public String errorMsg;
    public String pageName;
    public String subType;

    public String toString() {
        return "ErrorLogInfo{errorMsg='" + this.errorMsg + "', subType='" + this.subType + "', appId='" + this.appId + "', pageName='" + this.pageName + "', processName='" + this.processName + "', ext='" + this.ext + "', errorCode='" + this.errorCode + "'}";
    }
}

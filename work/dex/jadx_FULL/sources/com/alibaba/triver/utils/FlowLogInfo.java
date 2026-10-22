package com.alibaba.triver.utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FlowLogInfo extends LogInfo {
    public String eventId;
    public String ext;
    public String info;
    public String stage;

    public String toString() {
        return "StageInfo{appId='" + this.appId + "', eventId='" + this.eventId + "', info='" + this.info + "', ext='" + this.ext + "', stage='" + this.stage + "', processName='" + this.processName + "'}";
    }
}

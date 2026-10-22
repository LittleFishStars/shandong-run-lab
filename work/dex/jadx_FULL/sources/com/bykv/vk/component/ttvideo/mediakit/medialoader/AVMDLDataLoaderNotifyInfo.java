package com.bykv.vk.component.ttvideo.mediakit.medialoader;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class AVMDLDataLoaderNotifyInfo {
    public long code;
    public JSONObject jsonLog;
    public String logExtraJsonStr;
    public String logInfo;
    public String logType;
    public long parameter;
    public int what;

    public AVMDLDataLoaderNotifyInfo() {
        this.what = -1;
        this.code = -1L;
        this.parameter = -1L;
        this.logInfo = null;
        this.jsonLog = null;
    }

    public void logToJson() {
        if (this.logInfo == null) {
            return;
        }
        this.jsonLog = null;
        try {
            this.jsonLog = new JSONObject(this.logInfo);
        } catch (Exception unused) {
            this.jsonLog = null;
        }
    }

    public AVMDLDataLoaderNotifyInfo(int i, int i2, String str) {
        this.what = i;
        this.code = i2;
        this.parameter = -1L;
        this.logInfo = str;
        this.jsonLog = null;
    }
}

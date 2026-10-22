package com.alibaba.ariver.kernel.common.log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum LogType {
    CONNECTION("Connection"),
    API("API"),
    EVENT("Event"),
    PAGE("Page"),
    WORKER("Worker"),
    APP("Application");

    private String mLogType;

    LogType(String str) {
        this.mLogType = str;
    }

    public String getTypeSting() {
        return this.mLogType;
    }
}

package com.aliyun.vod.common.logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class Settings {
    private LogTool logTool;
    private int methodCount = 2;
    private boolean showThreadInfo = true;
    private int methodOffset = 0;
    private LogLevel logLevel = LogLevel.FULL;

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    public LogTool getLogTool() {
        if (this.logTool == null) {
            this.logTool = new AndroidLogTool();
        }
        return this.logTool;
    }

    public int getMethodCount() {
        return this.methodCount;
    }

    public int getMethodOffset() {
        return this.methodOffset;
    }

    public Settings hideThreadInfo() {
        this.showThreadInfo = false;
        return this;
    }

    public boolean isShowThreadInfo() {
        return this.showThreadInfo;
    }

    public Settings logLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    public Settings logTool(LogTool logTool) {
        this.logTool = logTool;
        return this;
    }

    public Settings methodCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.methodCount = i;
        return this;
    }

    public Settings methodOffset(int i) {
        this.methodOffset = i;
        return this;
    }

    @Deprecated
    public Settings setLogLevel(LogLevel logLevel) {
        return logLevel(logLevel);
    }

    @Deprecated
    public Settings setMethodCount(int i) {
        return methodCount(i);
    }

    @Deprecated
    public Settings setMethodOffset(int i) {
        return methodOffset(i);
    }
}

package com.aliyun.player.bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ErrorInfo {
    private ErrorCode mCode;
    private String mExtra;
    private String mMsg;

    public ErrorCode getCode() {
        return this.mCode;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public void setCode(ErrorCode errorCode) {
        this.mCode = errorCode;
    }

    public void setExtra(String str) {
        this.mExtra = str;
    }

    public void setMsg(String str) {
        this.mMsg = str;
    }
}

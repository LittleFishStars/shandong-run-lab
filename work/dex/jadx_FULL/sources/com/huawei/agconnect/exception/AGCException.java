package com.huawei.agconnect.exception;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class AGCException extends Exception {
    private int code;
    private String errMsg;

    public AGCException(String str, int i) {
        this.code = i;
        this.errMsg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return " code: " + this.code + " message: " + this.errMsg;
    }
}

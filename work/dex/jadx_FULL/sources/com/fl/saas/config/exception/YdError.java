package com.fl.saas.config.exception;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class YdError {
    private int code;
    private int errorType;
    private String message;

    public YdError() {
    }

    public YdError(int i, int i2, String str) {
        this.code = i;
        this.message = str;
        this.errorType = i2;
    }

    public YdError(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public YdError(String str) {
        this.message = str;
    }

    public static YdError create(int i, int i2, String str) {
        return new YdError(i, i2, str);
    }

    public static YdError create(int i, String str) {
        return new YdError(i, str);
    }

    public static YdError create(String str) {
        return new YdError(str);
    }

    public int getCode() {
        return this.code;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public String getMsg() {
        return TextUtils.isEmpty(this.message) ? "" : this.message;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setErrorType(int i) {
        this.errorType = i;
    }

    public void setMsg(String str) {
        this.message = str;
    }

    public String toString() {
        return "{code=" + this.code + ", message='" + this.message + "', errorType=" + this.errorType + '}';
    }
}

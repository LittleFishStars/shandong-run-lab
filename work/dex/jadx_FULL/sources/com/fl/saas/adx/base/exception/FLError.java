package com.fl.saas.adx.base.exception;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLError {
    private int code;
    private int errorType;
    private String message;

    public FLError() {
    }

    public static FLError create(int i, int i2, String str) {
        return new FLError(i, i2, str);
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

    public FLError(int i, int i2, String str) {
        this.code = i;
        this.message = str;
        this.errorType = i2;
    }

    public static FLError create(int i, String str) {
        return new FLError(i, str);
    }

    public FLError(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public static FLError create(String str) {
        return new FLError(str);
    }

    public FLError(String str) {
        this.message = str;
    }
}

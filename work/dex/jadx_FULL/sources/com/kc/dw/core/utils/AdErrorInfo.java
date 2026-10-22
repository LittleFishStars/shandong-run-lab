package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdErrorInfo {
    public static int LOAD_ERROR = 1;
    public static int RENDER_ERROR = 2;
    private int code;
    private int errorType;
    private String message;

    public AdErrorInfo(int i, int i2, String str) {
        this.errorType = i;
        this.code = i2;
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setErrorType(int i) {
        this.errorType = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}

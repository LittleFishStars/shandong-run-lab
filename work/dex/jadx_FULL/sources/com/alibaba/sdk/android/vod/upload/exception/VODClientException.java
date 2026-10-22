package com.alibaba.sdk.android.vod.upload.exception;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VODClientException extends RuntimeException {
    private String code;
    private String message;

    public VODClientException() {
    }

    public String getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (getCause() == null) {
            return message;
        }
        return getCause().getMessage() + "\n" + message;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public VODClientException(String str, String str2) {
        super("[ErrorCod]: " + str + ",[ErrorMessage]: " + str2);
        this.code = str;
        this.message = str2;
    }
}

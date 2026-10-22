package com.ali.auth.third.core.exception;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SecRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -2429061914258524220L;
    private int secCode;

    public SecRuntimeException(int i, Throwable th) {
        super(th);
        this.secCode = i;
    }

    public int getErrorCode() {
        return this.secCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " secCode = " + this.secCode;
    }
}

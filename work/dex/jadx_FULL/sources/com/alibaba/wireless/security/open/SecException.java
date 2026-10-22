package com.alibaba.wireless.security.open;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SecException extends Exception {
    public static final int ERROR_NULL_CONTEXT = -100;
    private static final long serialVersionUID = -6038752459848948772L;
    private int errorCode;

    public SecException(int i) {
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStream.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printStream);
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public SecException(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printWriter.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printWriter);
    }

    public SecException(Throwable th, int i) {
        super(th);
        this.errorCode = i;
    }

    public SecException(String str, Throwable th, int i) {
        super(str, th);
        this.errorCode = i;
    }
}

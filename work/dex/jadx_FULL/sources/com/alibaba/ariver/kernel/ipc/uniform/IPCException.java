package com.alibaba.ariver.kernel.ipc.uniform;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IPCException extends IOException {
    public int errorCode;
    public String errorMsg;

    public IPCException() {
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "IPCException{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "'}";
    }

    public IPCException(String str) {
        super(str);
    }

    public IPCException(String str, Throwable th) {
        super(str, th);
    }

    public IPCException(Throwable th) {
        super(th);
    }

    public IPCException(int i, String str) {
        this("errorCode:" + i + " errorMsg:" + str);
        this.errorCode = i;
        this.errorMsg = str;
    }
}

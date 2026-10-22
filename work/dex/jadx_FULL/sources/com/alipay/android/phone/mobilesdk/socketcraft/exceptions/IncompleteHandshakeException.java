package com.alipay.android.phone.mobilesdk.socketcraft.exceptions;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IncompleteHandshakeException extends RuntimeException {
    private static final long serialVersionUID = 7906596804233893092L;
    private int newsize;

    public IncompleteHandshakeException(int i) {
        this.newsize = i;
    }

    public int getPreferedSize() {
        return this.newsize;
    }

    public IncompleteHandshakeException() {
        this.newsize = 0;
    }
}

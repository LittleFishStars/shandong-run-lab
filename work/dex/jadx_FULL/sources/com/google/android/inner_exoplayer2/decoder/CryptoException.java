package com.google.android.inner_exoplayer2.decoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CryptoException extends Exception {
    public final int errorCode;

    public CryptoException(int i, String str) {
        super(str);
        this.errorCode = i;
    }
}

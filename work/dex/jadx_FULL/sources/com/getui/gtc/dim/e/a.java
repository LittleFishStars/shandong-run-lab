package com.getui.gtc.dim.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {
    public static byte[] a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            for (int length = bArr.length - 1; length > 0; length--) {
                bArr[length] = (byte) (bArr[length] ^ bArr[length - 1]);
            }
            bArr[0] = (byte) (bArr[0] ^ com.google.common.base.a.A);
        }
        return bArr;
    }
}

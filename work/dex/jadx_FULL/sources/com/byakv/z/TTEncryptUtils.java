package com.byakv.z;

import com.byazt.bzd.sp;
import com.byazt.yv.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TTEncryptUtils {
    static {
        try {
            sp.c("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e) {
            da.tt(e);
        }
    }

    public static byte[] c(byte[] bArr, int i) {
        try {
            return ttEncrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static native String clientPackedBase64(byte[] bArr, int i);

    public static native byte[] clientUnpackedBase64(String str);

    public static native String getDA0Result(String str);

    public static native int[] getDI0Result(String[] strArr);

    public static byte[] tt(byte[] bArr, int i) {
        try {
            return ttDecrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static native byte[] ttDecrypt(byte[] bArr, int i);

    private static native byte[] ttEncrypt(byte[] bArr, int i);
}

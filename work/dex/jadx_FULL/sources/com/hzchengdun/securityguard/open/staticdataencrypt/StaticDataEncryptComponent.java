package com.hzchengdun.securityguard.open.staticdataencrypt;

import com.hzchengdun.securityguard.adapter.JNICLibrary;
import com.hzchengdun.securityguard.open.SecException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class StaticDataEncryptComponent {
    public static final int ALGORITHM_DECRYPT = 2;
    public static final int ALGORITHM_ENCRYPT = 1;
    public static final int ALGORITHM_MAX_NUMBER = 19;
    public static final int GCRY_CIPHER_AES128 = 16;
    public static final int GCRY_CIPHER_AES192 = 17;
    public static final int GCRY_CIPHER_AES256 = 18;
    public static final int GCRY_CIPHER_ARCFOUR = 3;
    public static final int NEED_BASE64 = 1;

    private byte[] doStaticEncrypt(int i, int i2, int i3, String str, byte[] bArr, String str2) {
        return (byte[]) JNICLibrary.doCommand(10601, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, bArr, str2);
    }

    public byte[] staticDecrypt(int i, String str, byte[] bArr, String str2) throws SecException {
        if (str == null || str.isEmpty() || i < 3 || i >= 19 || bArr == null || bArr.length <= 0) {
            throw new SecException("", 301);
        }
        return doStaticEncrypt(2, i, 1, str, bArr, str2);
    }

    public byte[] staticEncrypt(int i, String str, byte[] bArr, String str2) throws SecException {
        if (str == null || str.isEmpty() || i < 3 || i >= 19 || bArr == null || bArr.length <= 0) {
            throw new SecException("", 301);
        }
        return doStaticEncrypt(1, i, 1, str, bArr, str2);
    }
}

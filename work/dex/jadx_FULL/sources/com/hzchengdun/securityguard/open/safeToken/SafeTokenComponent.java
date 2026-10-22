package com.hzchengdun.securityguard.open.safeToken;

import com.hzchengdun.securityguard.SecExceptionCode;
import com.hzchengdun.securityguard.adapter.JNICLibrary;
import com.hzchengdun.securityguard.open.SecException;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SafeTokenComponent {
    private static final int SAFETOEKN_OPERATION_INVALID = 0;
    private static final int SAFETOKEN_OPERATION_DECRYPT = 5;
    private static final int SAFETOKEN_OPERATION_ENCRYPT = 4;
    private static final int SAFETOKEN_OPERATION_EXSITENCE = 2;
    private static final int SAFETOKEN_OPERATION_REMOVE = 3;
    private static final int SAFETOKEN_OPERATION_SAVE = 1;
    private static final int SAFETOKEN_OPERATION_SIGN = 6;

    private Object SafeTokenOperation(int i, String str, byte[] bArr, String str2, int i2) throws SecException {
        if (str == null || str.isEmpty()) {
            throw new SecException("", SecExceptionCode.SEC_ERROR_SAFETOKEN_INVALID_PARAM);
        }
        if (i > 0 && i < 4) {
            return (Boolean) JNICLibrary.doCommand(12101, Integer.valueOf(i), str, bArr, str2, Integer.valueOf(i2));
        }
        if (i <= 3 || i > 6) {
            return null;
        }
        byte[] bArr2 = (byte[]) JNICLibrary.doCommand(12101, Integer.valueOf(i), str, bArr, str2, Integer.valueOf(i2));
        return i == 6 ? new String(bArr2) : bArr2;
    }

    public byte[] decryptWithToken(String str, byte[] bArr, int i) throws SecException {
        return (byte[]) SafeTokenOperation(5, str, bArr, null, i);
    }

    public byte[] encryptWithToken(String str, byte[] bArr, int i) throws SecException {
        return (byte[]) SafeTokenOperation(4, str, bArr, null, i);
    }

    public boolean isTokenExisted(String str) throws SecException {
        return ((Boolean) SafeTokenOperation(2, str, null, null, 0)).booleanValue();
    }

    public void removeToken(String str) throws SecException {
        SafeTokenOperation(3, str, null, null, 0);
    }

    public boolean saveToken(String str, String str2, String str3, int i) throws SecException {
        if (str2 == null || str2.isEmpty()) {
            throw new SecException("", SecExceptionCode.SEC_ERROR_SAFETOKEN_INVALID_PARAM);
        }
        try {
            return ((Boolean) SafeTokenOperation(1, str, str2.getBytes("UTF-8"), str3, i)).booleanValue();
        } catch (UnsupportedEncodingException unused) {
            throw new SecException("", SecExceptionCode.SEC_ERROR_SAFETOKEN_INVALID_PARAM);
        }
    }

    public String signWithToken(String str, byte[] bArr, int i) throws SecException {
        return (String) SafeTokenOperation(6, str, bArr, null, i);
    }
}

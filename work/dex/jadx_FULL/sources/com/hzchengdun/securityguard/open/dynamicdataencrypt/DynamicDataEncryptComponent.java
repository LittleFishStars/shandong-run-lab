package com.hzchengdun.securityguard.open.dynamicdataencrypt;

import com.hzchengdun.securityguard.adapter.JNICLibrary;
import com.hzchengdun.securityguard.open.SecException;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class DynamicDataEncryptComponent {
    private static final int DDPEX_GETDATA = 11;
    private static final int DDPEX_GETSTRING = 10;
    private static final int DDPEX_PUTDATA = 9;
    private static final int DDPEX_PUTSTRING = 8;
    private static final int DDPEX_REMOVEDATA = 13;
    private static final int DDPEX_REMOVESTRING = 12;
    private static final int DDP_DECRYPT = 4;
    private static final int DDP_ENCRYPT = 3;

    private Object DDpExOperation(int i, String str, byte[] bArr, int i2) throws SecException {
        if (str == null || str.isEmpty()) {
            throw new SecException("", 501);
        }
        if (i == 8 || i == 9 || i == 13 || i == 12) {
            return (Boolean) JNICLibrary.doCommand(10503, Integer.valueOf(i), str, bArr, Integer.valueOf(i2));
        }
        if (i != 10 && i != 11) {
            return null;
        }
        byte[] bArr2 = (byte[]) JNICLibrary.doCommand(10503, Integer.valueOf(i), str, bArr, Integer.valueOf(i2));
        return i == 10 ? new String(bArr2) : bArr2;
    }

    private byte[] dynamicCrypt(int i, byte[] bArr, boolean z) throws SecException {
        if (bArr == null || bArr.length <= 0) {
            throw new SecException("Input byte data is empty", 401);
        }
        return (byte[]) JNICLibrary.doCommand(10501, Integer.valueOf(i), Boolean.valueOf(z), bArr);
    }

    public byte[] dynamicDecrypt(byte[] bArr) throws SecException {
        return dynamicCrypt(4, bArr, true);
    }

    public byte[] dynamicEncrypt(byte[] bArr) throws SecException {
        return dynamicCrypt(3, bArr, true);
    }

    public byte[] getByteArrayDDpEx(String str, int i) throws SecException {
        return (byte[]) DDpExOperation(11, str, null, i);
    }

    public String getStringDDpEx(String str, int i) throws SecException {
        return (String) DDpExOperation(10, str, null, i);
    }

    public boolean putByteArrayDDpEx(String str, byte[] bArr, int i) throws SecException {
        return ((Boolean) DDpExOperation(9, str, bArr, i)).booleanValue();
    }

    public boolean putStringDDpEx(String str, String str2, int i) throws SecException {
        if (str2 == null || str2.isEmpty()) {
            throw new SecException("", 501);
        }
        try {
            return ((Boolean) DDpExOperation(8, str, str2.getBytes("UTF-8"), i)).booleanValue();
        } catch (UnsupportedEncodingException unused) {
            throw new SecException("", 501);
        }
    }

    public void removeByteArrayDDpEx(String str, int i) throws SecException {
        DDpExOperation(13, str, null, i);
    }

    public void removeStringDDpEx(String str, int i) throws SecException {
        DDpExOperation(12, str, null, i);
    }
}

package com.hzchengdun.securityguard.open.dynamicdatastore;

import com.hzchengdun.securityguard.adapter.JNICLibrary;
import com.hzchengdun.securityguard.open.SecException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class DynamicDataStoreComponent {
    private static final int DDPEX_GETDATA = 11;
    private static final int DDPEX_GETSTRING = 10;
    private static final int DDPEX_PUTDATA = 9;
    private static final int DDPEX_PUTSTRING = 8;
    private static final int DDPEX_REMOVEDATA = 13;
    private static final int DDPEX_REMOVESTRING = 12;

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

    public byte[] getByteArrayDDpEx(String str, int i) throws SecException {
        return (byte[]) DDpExOperation(11, str, null, i);
    }

    public boolean putByteArrayDDpEx(String str, byte[] bArr, int i) throws SecException {
        return ((Boolean) DDpExOperation(9, str, bArr, i)).booleanValue();
    }

    public void removeByteArrayDDpEx(String str, int i) throws SecException {
        DDpExOperation(13, str, null, i);
    }
}
